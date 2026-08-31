import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[][] notas = new double[4][3];

        // Entrada das notas
        for (int i = 0; i < notas.length; i++) {

            System.out.println("Aluno " + (i + 1));

            for (int j = 0; j < notas[i].length; j++) {

                System.out.print("Digite a nota P" + (j + 1) + ": ");
                notas[i][j] = scanner.nextDouble();
            }
        }

        // Cálculo das médias
        for (int i = 0; i < notas.length; i++) {

            double soma = 0;

            for (int j = 0; j < notas[i].length; j++) {
                soma += notas[i][j];
            }

            double media = soma / notas[i].length;

            System.out.printf(
                    "Média do Aluno %d: %.2f%n",
                    i + 1,
                    media
            );
        }

        scanner.close();
    }
}