package Exercici4;

import java.io.*;

public class ExecutarFind {
    public static void main(String[] args) {
        // Verificar que se haya pasado el texto y el nombre del archivo como argumentos
        if (args.length < 2) {
            System.out.println("Cal passar un text per buscar i el nom del fitxer.");
            return;
        }

        String outputFileName = args[0];  // El archivo que contiene los resultados de 'dir'
        String searchText = args[1];      // El texto a buscar en el archivo

        String command = "find /i \"" + searchText + "\" " + outputFileName;  // Comando de búsqueda

        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", command);

        try {
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                found = true;
                System.out.println(line);
            }

            if (!found) {
                System.out.println("No s'ha trobat el nom del fitxer.");
            }else {
                System.out.println("S'ha trobat el nom del fitxer.");
            }

            process.waitFor();  // Esperar a que el proceso termine
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
