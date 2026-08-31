import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int[] valores = new int[10];

            System.out.println("Digite 10 valores:");

            for (int i = 0; i < valores.length; i++) {
                valores[i] = scanner.nextInt();
            }

            int maiorValor = valores[0];
            int menorValor = valores[0];

            for (int i = 1; i < valores.length; i++) {
                if (valores[i] > maiorValor) {
                    maiorValor = valores[i];
                }
                if (valores[i] < menorValor) {
                    menorValor = valores[i];
                }
            }

            System.out.println("Maior valor: " + maiorValor);
            System.out.println("Menor valor: " + menorValor);
            scanner.close();
        }
}