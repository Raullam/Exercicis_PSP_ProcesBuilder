package Exercici3.ProjectePare;

import java.io.*;

public class ExercicisMultiproces3 {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "./out/production/Exercicis_per_entregar_PSP", "Exercici3.ProjecteFill.ExercicisMultiproces3_Missatges");
        processBuilder.redirectErrorStream(true);  // Redirigir errores al flujo de salida

        Process process = null;

        try {
            process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String input;

            while (true) {
                System.out.print("Pare: envia missatge: ");
                input = consoleInput.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    writer.write(input);
                    writer.newLine();
                    writer.flush();
                    break;
                }


                writer.write(input);
                writer.newLine();
                writer.flush();

                String response = reader.readLine();
                if (response != null) {
                    System.out.println("Fill: rep missatge del pare: \"" + input + "\"");
                    System.out.println("Fill: envia missatge al pare: \"" + response + "\"");
                    System.out.println("Pare: rep missatge del fill: \"" + response + "\"");
                    break;
                } else {
                    System.out.println("El fill ha tancat la comunicació.");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (process != null) {
                    process.destroy();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
