package poc.io;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String... args) {
        try {
            Path path = Paths.get(ClassLoader.getSystemResource("resources").toURI());

        } catch (URISyntaxException e) {

        }
    }
}
