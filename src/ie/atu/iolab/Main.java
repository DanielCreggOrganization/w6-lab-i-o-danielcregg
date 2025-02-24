package ie.atu.iolab;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Path projectRoot = Paths.get(System.getProperty("user.dir"));
        System.out.println("Project root directory: " + projectRoot.toAbsolutePath());
        System.out.println("The input.txt file is located at: " + projectRoot.resolve("resources").resolve("input.txt").toAbsolutePath());
        Path outputFilePath = projectRoot.resolve("resources").resolve("output.txt");
        if (Files.exists(outputFilePath)) {
            System.out.println("output.txt found at: " + outputFilePath.toAbsolutePath());
        } else {
            System.out.println("output.txt not found at: " + outputFilePath.toAbsolutePath());
        }

        Path filePath = projectRoot.resolve("resources").resolve("input.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath.toFile());
            int data;
            String fileContent = ""; // Start with an empty string
            int charCount = 0;
            int byteCount = 0;
            
            while ((data = fis.read()) != -1) {
                fileContent = fileContent + (char) data; // Append each character
                byteCount++;
            }
            
            System.out.println("\nFile content:\n" + fileContent);
            charCount = fileContent.length();
            System.out.println("Total characters: " + charCount);
            System.out.println("Total bytes: " + byteCount);
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
