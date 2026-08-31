import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de produto:");

        Produto[] produtos = new Produto[3];

        double soma = 0;
        String produtoQtd;
        int maiorQtd;

        // Cadastro dos produtos
        for (int i = 0; i < produtos.length; i++) {

            System.out.println("\nProduto " + (i + 1));

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Código: ");
            int codigo = scanner.nextInt();

            System.out.print("Preço: ");
            double preco = scanner.nextDouble();

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();

            scanner.nextLine(); // consome o Enter

            produtos[i] = new Produto(nome, codigo, preco, quantidade);
        }

        // Considera o primeiro produto como o maior inicialmente
        maiorQtd = produtos[0].getQuantidade();
        produtoQtd = produtos[0].getNome();

        // Percorre os produtos
        for (int i = 0; i < produtos.length; i++) {

            soma += produtos[i].getPreco();

            if (produtos[i].getQuantidade() > maiorQtd) {
                maiorQtd = produtos[i].getQuantidade();
                produtoQtd = produtos[i].getNome();
            }
        }

        System.out.println("\nMaior Quantidade: " + produtoQtd
                + " com: " + maiorQtd);

        System.out.println("Soma dos Preços: " + soma);

        scanner.close();
    }
}