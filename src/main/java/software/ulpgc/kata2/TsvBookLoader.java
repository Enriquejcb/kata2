package software.ulpgc.kata2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TsvBookLoader implements BookLoader{
    private static final String SEPARATOR = "\t";
    private static final int COLUMS = 3;


    @Override
    public List<Book> load(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        List<Book> books = new ArrayList<>();
        reader.readLine();
        int lineNumber = 1;
        String line;
        while ((line = reader.readLine()) != null) {
            lineNumber++;
            if (line.isBlank()) continue;
            books.add(parse(line, lineNumber));
        }
        return books;
    }

    private Book parse(String line, int lineNumber) throws InvalidRowException {
        String[] fields = line.split(SEPARATOR, -1);
        if (fields.length != COLUMS) {
            throw new InvalidRowException(lineNumber, "expected " + COLUMS + " colums but found " + fields.length);
        }
        try{
            int pages = Integer.parseInt(fields[2].trim());
            if (pages <= 0) throw new InvalidRowException(lineNumber, "pages must be a positive but was " + pages);
            return new Book(fields[0].trim(), fields[1].trim(), pages);
    } catch (NumberFormatException e){
        throw new InvalidRowException(lineNumber, "pages is not a number: '" + fields[2].trim() + "'");
        }
    }
}
