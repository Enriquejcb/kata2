package software.ulpgc.kata2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvGameLoader implements GameLoader{
    private static final String SEPARATOR = ",";
    private static final int COLUMS = 3;


    @Override
    public List<Game> load(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        List<Game> games = new ArrayList<>();
        reader.readLine();
        int lineNumber = 1;
        String line;
        while ((line = reader.readLine()) != null) {
            lineNumber++;
            if (line.isBlank()) continue;
            games.add(parse(line, lineNumber));
        }
        return games;
    }

    private Game parse(String line, int lineNumber) throws InvalidRowException {
        String[] fields = line.split(SEPARATOR, -1);
        if (fields.length != COLUMS) {
            throw new InvalidRowException(lineNumber, "expected " + COLUMS + " colums but found " + fields.length);
        }
        try{
            return new Game(fields[0].trim(), fields[1].trim(), Integer.parseInt(fields[2].trim()));
    } catch (NumberFormatException e){
        throw new InvalidRowException(lineNumber, "year is not a number: '" + fields[2].trim() + "'");
        }
    }
}
