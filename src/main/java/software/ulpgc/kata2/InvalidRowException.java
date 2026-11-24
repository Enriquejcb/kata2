package software.ulpgc.kata2;

import java.io.IOException;

public class InvalidRowException extends IOException {
    public InvalidRowException(int lineNumber, String reason) {

        super("Invalid row at line" + lineNumber + ": " + reason);
    }
}
