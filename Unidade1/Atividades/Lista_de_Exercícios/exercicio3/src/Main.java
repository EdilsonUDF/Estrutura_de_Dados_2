import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[4];
        int cont = 0;
        int soma = 0;
        System.out.printf("Digite 20 numeros:");

        for (int i = 0; i < valores.length; i++){
            valores[i] = scanner.nextInt();
        }

        for (int i = 0; i < valores.length; i++){
            if (valores[i] % 2 == 0){
                System.out.print("Numeros Digitados: " +valores[i] + ", ");
                cont++;
                soma += valores[i];
            }
        }
        System.out.println("\nQuantidade: " + cont + "\nSoma: " + soma);
    }
}