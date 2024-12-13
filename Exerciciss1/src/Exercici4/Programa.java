package Exercici4;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix el nom del fitxer (per exemple 'sortida.txt'): ");
        String outputFileName = scanner.nextLine();

        try {
            ExecutarDir.main(new String[]{outputFileName});

            System.out.print("Introdueix el text per cercar a '" + outputFileName + "': ");
            String searchText = scanner.nextLine();

            ExecutarFind.main(new String[]{outputFileName, searchText});

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
