package Exercici3.ProjecteFill;

import java.io.*;

public class ExercicisMultiproces3_Missatges {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            String input;

            while (true) {
                input = reader.readLine();
                if (input == null || input.equalsIgnoreCase("exit")) {
                    System.out.println("El pare ha tancat la comunicació.");
                    break;
                }


                System.out.println("Salutacions del Fill");

                String response = "Salutacions de part del fill";  // Respuesta predefinida
                writer.write(response);
                writer.newLine();
                writer.flush();

                System.out.println("Fill: envia missatge al pare: \"" + response + "\"");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
