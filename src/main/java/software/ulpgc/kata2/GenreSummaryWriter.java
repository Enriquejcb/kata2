package software.ulpgc.kata2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class GenreSummaryWriter {
    public void writer(Map<String, Double> averages, OutputStream output) throws IOException{
        Writer writer = new OutputStreamWriter(output, StandardCharsets.UTF_8);
        writer.write("Averages per genre\n");
        if (averages.isEmpty()) writer.write("(no data)\n");
        for (Map.Entry<String,Double> entry: averages.entrySet()){
            writer.write(entry.getKey() + ": " +  entry.getValue() + "\n");
        }
        writer.flush();
    }


}
