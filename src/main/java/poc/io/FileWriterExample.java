package poc.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class FileWriterExample {

    public static void main(String... args) {
        try {
            File resourceDir = new File(ClassLoader.getSystemResource("resources").toURI());
            File file = new File(resourceDir.getPath() + "/toWrite.txt");
            boolean isFileCreated = file.createNewFile();
            if (isFileCreated) {
                System.out.println("the new file is created in ->" + file.getAbsolutePath());
            } else {
                System.out.println("File already exists ->" + file.getAbsolutePath());
            }
            String[] contents = resourceDir.list();
            System.out.println("----All Files list ---");
            System.out.println(Arrays.toString(contents));

            FilenameFilter filter = (fileHolder, fileName) -> {
                return fileName.contains(".log");
            };
            contents = resourceDir.list(filter);
            System.out.println("----Log Files list ---");
            System.out.println(Arrays.toString(contents));

        } catch (IOException | URISyntaxException e) {
            System.err.println(e.getMessage());
        }
    }
}
