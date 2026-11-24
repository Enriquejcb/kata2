package software.ulpgc.kata2;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    private static final String DEFAULT_INPUT = "data/games.csv";
    private static final String OUTPUT_FILE = "summary.txt";
    private static final String MEMORY_SAMPLE = """
            title,platform,year
            Tetris,Game Boy,1989
            Pokemon Red,Game Boy,1996
            Sonic,Mega Drive,1991
            """;

    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : DEFAULT_INPUT;
        try {
            try (InputStream file = new FileInputStream(path)) {
                summarize(file, System.out);
            }

            try (InputStream memory = new ByteArrayInputStream(MEMORY_SAMPLE.getBytes(StandardCharsets.UTF_8));
                 OutputStream file = new FileOutputStream(OUTPUT_FILE)) {
                summarize(memory, file);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Could not process the data. " + e.getMessage());
        }
    }

    private static void summarize(InputStream input, OutputStream output) throws IOException {
        var games = new CsvGameLoader().load(input);
        var summary = new PlatformCounter().count(games);
        new PlatformSummaryWriter().writer(summary, output);
    }
}