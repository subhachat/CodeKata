package poc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ReaderExample {
    private static String REGEX_INFO_LINE = "(INFO\\])(\\D+)";
    private static String REGEX_DATE = "(\\d{4}-\\d{2}-\\d{2})";
    private static String REGEX_TIME = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";

    public static void main(String... args) {
        BufferedReader reader = null;
        try {
            File file = new File(ClassLoader.getSystemResource("sample.log").toURI());
            //System.out.println("Current working directory -> " + System.getProperty("user.dir"));
            reader = new BufferedReader(new FileReader(file));
            String line; //this is the buffer for each line read
            List<String> infoLines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.contains("everything normal for")) {
                    infoLines.add(line);
                }
            }
            String[] sections = infoLines.get(0).split(REGEX_DATE);
            System.out.println("First line dissect -> " + sections[0]);
            System.out.println("Number of info lines -> " + infoLines.size());
        } catch (IOException | URISyntaxException e) {
            System.err.println("Exception occurred-> " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("----Input stream is closed----");
                }
            } catch (IOException e) {
                System.err.println("~~~~Error closing the input stream -> " + e.getMessage());
            }
        }
    }
}
