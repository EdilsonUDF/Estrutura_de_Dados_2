import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[10];

        System.out.printf("Digite 10 numeros: ");

        for (int i = 0; i < valores.length; i++){
            valores[i] = scanner.nextInt();
        }
        for (int i = valores.length - 1; i >= 0 ; i--) {
            System.out.printf(valores[i] + ", ");
        }
    }
}