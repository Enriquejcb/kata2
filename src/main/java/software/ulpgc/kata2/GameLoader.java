package software.ulpgc.kata2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public interface GameLoader {
    public List<Game> load(InputStream input) throws IOException;
}
