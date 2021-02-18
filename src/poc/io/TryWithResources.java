package poc.io;

import java.io.*;
import java.net.URISyntaxException;

public class TryWithResources {
    public static void main(String... args) {
        try (
                BufferedReader reader = new BufferedReader(
                        new FileReader(
                                new File(
                                        ClassLoader.getSystemResource("resources/sample.log").toURI()
                                )
                        )
                );
                StringWriter writer = new StringWriter();
        ) {
            String readLine;
            while((readLine = reader.readLine()) != null){
                if (readLine.contains("WARN")) {
                    writer.write(readLine.split("\\b([WARN]\\b)")[0]);
                    writer.write("\n");
                }
            }
            System.out.println(writer.toString());
        } catch (IOException | URISyntaxException e) {
            System.err.println("Exception occurred -> "+e.getMessage());
        }
    }
}
