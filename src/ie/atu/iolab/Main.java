package ie.atu.iolab;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
        
        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            int data;
            while ((data = fis.read()) != -1) {
                char ch = (char) data;
                char lower = Character.toLowerCase(ch);
                // Check if character is t,h,i,s and convert to uppercase if so
                if ("this".indexOf(lower) != -1) {
                    fos.write(Character.toUpperCase(ch));
                } else {
                    fos.write(Character.toLowerCase(ch));
                }
            }
            System.out.println("File processed successfully.");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
