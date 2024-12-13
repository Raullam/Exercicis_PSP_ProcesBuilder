package Exercici2.ProjecteFill;

import java.io.*;

public class ExercicisMultiproces2_ModificarString {
    public static void main(String[] args) {
        try {
            // Leer la entrada del proceso padre
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            String input;
            while ((input = reader.readLine()) != null) {
                // Convertir a mayúsculas y reemplazar vocales por "_"
                String output = input.toUpperCase().replaceAll("[AEIOU]", "_");

                // Enviar la salida al padre
                writer.write(output);
                writer.newLine();
                writer.flush();  // Enviar la respuesta al padre
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
