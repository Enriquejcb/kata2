package software.ulpgc.kata2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public interface StudentLoader {
    public List<Software.ulpgc.kata2.Student> load(InputStream is) throws IOException;
}
