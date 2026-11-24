package software.ulpgc.kata2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    private static final String RESOURCE = "/books.tsv";
    private static final String MEMORY_SAMPLE = "title\tgenre\tpages\n"
            + "Foundation\tScience Fiction\t255\n"
            + "Misery\tHorror\t320\n";

    public static void main(String[] args) {
        try {

            try (InputStream resource = Main.class.getResourceAsStream(RESOURCE)) {
                if (resource == null) throw new FileNotFoundException("Resource not found: " + RESOURCE);
                summarize(resource, System.out);
            }

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            try (InputStream memory = new ByteArrayInputStream(MEMORY_SAMPLE.getBytes(StandardCharsets.UTF_8))) {
                summarize(memory, buffer);
            }
            System.out.println();
            System.out.print("Captured in memory:\n" + buffer.toString(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Could not process the data. " + e.getMessage());
        }
    }

    private static void summarize(InputStream input, OutputStream output) throws IOException {
        var books = new TsvBookLoader().load(input);
        var averages = new AveragePagesByGenre().calculate(books);
        new GenreSummaryWriter().writer(averages, output);
    }
}