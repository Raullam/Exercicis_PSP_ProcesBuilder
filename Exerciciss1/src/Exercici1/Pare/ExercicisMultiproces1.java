package Exercici1.Pare;

import java.io.*;

public class ExercicisMultiproces1 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("Introdueix un nombre: ");
                String input = reader.readLine();

                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }

                int numero;
                try {
                    numero = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Si us plau, introdueix un nombre enter positiu.");
                    continue;
                }


                ProcessBuilder pb = new ProcessBuilder("java",
                        "-cp", ".\\out\\production\\Exercicis_per_entregar_PSP",
                        "Exercici1.fill.ExercicisMultiproces1_ParellSenar",
                        String.valueOf(numero));

                Process process = pb.start();

                BufferedReader processReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String respostaDelFill = processReader.readLine();

                System.out.println("El Fill diu: " + respostaDelFill);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
