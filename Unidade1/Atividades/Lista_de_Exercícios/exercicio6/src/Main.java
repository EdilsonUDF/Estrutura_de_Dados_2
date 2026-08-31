import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[][] matriz = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int soma = 0;
        int[] diagonal = new int[matriz.length];

        System.out.printf("");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++){
                diagonal[i] = matriz[i][i];
            }
        }

        for (int i = 0; i < diagonal.length; i++) {
            soma += diagonal[i];
            System.out.printf(diagonal[i] + ", ");
        }
        System.out.printf("\nSoma: " + soma);

    }
}