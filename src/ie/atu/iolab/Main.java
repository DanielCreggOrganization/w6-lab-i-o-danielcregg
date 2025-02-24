package ie.atu.iolab;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

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
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("second")) {
                    writer.write(line.toUpperCase());
                    writer.newLine();
                }
            }
            System.out.println("File processed with buffered I/O.");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }

        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long lineCount = lines.count();
            System.out.println("Number of lines: " + lineCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long wordCount = lines
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .count();
            System.out.println("Number of words: " + wordCount);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }

        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            String longestWord = lines
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .max(Comparator.comparingInt(String::length))
                .orElse("No words found");
            System.out.println("Longest word: " + longestWord);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
