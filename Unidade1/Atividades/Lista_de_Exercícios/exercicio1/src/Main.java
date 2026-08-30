import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite 10 numeros interiros:");
        int[] valor = new int[10];
        int soma = 0;
        double media;

            for (int i = 0; i < valor.length; i++) {
                valor[i] = scanner.nextInt();
                System.out.println("digitou:" + valor[i]);
            }

            System.out.printf("Numeros Digitados: ");
            for (int i = 0; i < valor.length; i++){
                soma += valor[i];
                System.out.print(valor[i] + ", ");
            }
        media = soma / valor.length;

        System.out.print(
                "\nSoma: " + soma +
                "\nMedia: " + media );
        scanner.close();
    }
}