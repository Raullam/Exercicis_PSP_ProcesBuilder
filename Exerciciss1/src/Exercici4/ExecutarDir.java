package Exercici4;

import java.io.*;

public class ExecutarDir {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Error: No s'ha proporcionat el nom del fitxer.");
            return;
        }

        String outputFileName = args[0];

        File outputFile;
        if (outputFileName.contains(":")) {
            outputFile = new File(outputFileName);
        } else {
            outputFile = new File(System.getProperty("user.home"), "Desktop/" + outputFileName);
        }

        try {
            File parentDir = outputFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                System.out.println("La carpeta de destinació no existeix. Creant carpeta...");
                parentDir.mkdirs();
            }

            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "dir", "C:\\Users\\Rulox\\Desktop");
            processBuilder.redirectOutput(outputFile);

            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Fitxer creat a: " + outputFile.getAbsolutePath());
            } else {
                System.out.println("Error al crear el fitxer. Codi de sortida: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
