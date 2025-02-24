package ie.atu.iolab;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.FileReader;
import java.io.FileWriter;
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

        String inputPath = projectRoot.resolve("resources").resolve("input.txt").toString();
        String outputPath = projectRoot.resolve("resources").resolve("output.txt").toString();
        
        try (FileReader reader = new FileReader(inputPath)) {
            StringBuilder content = new StringBuilder();
            int character;
            // Read all content
            while ((character = reader.read()) != -1) {
                content.append((char) character);
            }
            
            // Write reversed content
            try (FileWriter writer = new FileWriter(outputPath)) {
                writer.write(content.reverse().toString());
                System.out.println("File content reversed successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
