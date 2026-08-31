import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        int soma = 0;
        System.out.printf("Digite 10 valores para a matriz:");

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = scanner.nextInt();
            }
            System.out.println();
        }

        int maiorValor = matriz[0][0];
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                soma += matriz[i][j];
                if (matriz[i][j] > maiorValor){
                    maiorValor = matriz[i][j];
                }
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nSoma dos valores na matriz: " + soma + "\nMaior Valor é: " + maiorValor);
    }
}