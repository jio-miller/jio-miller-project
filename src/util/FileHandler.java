package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileHandler {
    private static final String filePath = "data/contacts.txt";

    public static List<String> getFileContents() {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            System.err.println("Could not read file: " + filePath + ". Maybe it doesn't exist?");
            return null;
        }
    }

    public static void writeLines(List<String> lines, boolean overwrite) {
        try {
            Files.write(Paths.get(filePath), lines, overwrite
                    ? StandardOpenOption.TRUNCATE_EXISTING : StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Could not write to file: " + filePath);
        }
    }

}
