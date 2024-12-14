package Exercici1.fill;

public class ExercicisMultiproces1_ParellSenar {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: Se espera un número como argumento.");
            return;
        }

        try {//
            int numero = Integer.parseInt(args[0]);
            String resultado = (numero % 2 == 0) ? "Parell" : "Senar";
            System.out.println(resultado);
        } catch (NumberFormatException e) {
            System.out.println("Error: Se espera un número entero.");
        }
    }
}
