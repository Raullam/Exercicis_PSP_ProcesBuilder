package Exercici2.ProjectePare;

import java.io.*;
import java.util.Scanner;

public class ExercicisMultiproces2 {
    static String workingDir = System.getProperty("user.dir");
    static final String dirPath = workingDir + "\\out\\production\\Exercicis_per_entregar_PSP";

    // no consigo que me funcione la ruta relativa asi como en los otros proyectos si que funciona, no lo entiendo.
    static final String[] command = {"java", "-cp", dirPath, "Exercici2.ProjecteFill.ExercicisMultiproces2_ModificarString"};


    public static Process execPrograma() throws IOException {
        ProcessBuilder programa = new ProcessBuilder(command);
        programa.directory(new File(dirPath));  // Apunta al directorio donde está el archivo .class
        programa.redirectError(new File(dirPath + "\\error.txt"));  // Redirige errores a un archivo
        return programa.start();  // Lanza el proceso hijo
    }

    private static void enviar(Process proces, String text) throws IOException {
        OutputStream outS = proces.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outS));

        writer.write(text);
        writer.newLine();
        writer.flush();
        writer.close();
    }

    // Método para leer datos del hijo
    private static String llegir(Process proces) throws IOException {
        InputStream inS = proces.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inS));
        return reader.readLine();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("El PARE diu: ");
                String input = scanner.nextLine();

                if ("exit".equals(input)) break;

                // Crear proceso hijo
                Process proces = execPrograma();

                // Enviar datos al hijo
                enviar(proces, input);

                // Leer la respuesta del hijo
                String respostaDelFill = llegir(proces);
                System.out.println("El Fill diu: " + respostaDelFill);

                proces.waitFor();  // Espera a que el hijo termine
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
