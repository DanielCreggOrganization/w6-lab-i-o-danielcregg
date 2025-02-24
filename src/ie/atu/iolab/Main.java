package ie.atu.iolab;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

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
    }
}
