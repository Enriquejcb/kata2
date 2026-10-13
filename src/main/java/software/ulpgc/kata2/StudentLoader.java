package software.ulpgc.kata2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public interface StudentLoader {
    public List<Student> load(InputStream is) throws IOException;
}
