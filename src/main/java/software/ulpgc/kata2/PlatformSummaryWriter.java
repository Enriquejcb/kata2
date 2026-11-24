package software.ulpgc.kata2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class PlatformSummaryWriter {
    public void writer(Map<String, Integer> summary, OutputStream output) throws IOException{
        Writer writer = new OutputStreamWriter(output, StandardCharsets.UTF_8);
        writer.write("Games per platform\n");
        if (summary.isEmpty()) writer.write("(nodata)\n");
        for (Map.Entry<String,Integer> entry: summary.entrySet()){
            writer.write(entry.getKey() + ": " +  entry.getValue() + "\n");
        }
        writer.flush();
    }


}
