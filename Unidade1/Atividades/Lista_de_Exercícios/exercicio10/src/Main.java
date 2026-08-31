import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Funcionario[] funcionarios = new Funcionario[10];

    public static void main(String[] args) {

        int opcao;

        do {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarFuncionarios();
                    break;

                case 2:
                    listarFuncionarios();
                    break;

                case 3:
                    maiorSalario();
                    break;

                case 4:
                    mediaSalarial();
                    break;

                case 5:
                    salariosAcimaDaMedia();
                    break;

                case 0:
                    System.out.println("\nEncerrando o sistema...");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // =========================
    // MENU
    // =========================

    public static void exibirMenu() {

        System.out.println("\n=================================");
        System.out.println("       SISTEMA DE FUNCIONÁRIOS");
        System.out.println("=================================");
        System.out.println("1 - Cadastrar funcionários");
        System.out.println("2 - Listar funcionários");
        System.out.println("3 - Maior salário");
        System.out.println("4 - Média salarial");
        System.out.println("5 - Salários acima da média");
        System.out.println("0 - Sair");
    }

    // =========================
    // CADASTRO
    // =========================

    public static void cadastrarFuncionarios() {

        System.out.println("\n=== CADASTRO DE FUNCIONÁRIOS ===");

        for (int i = 0; i < funcionarios.length; i++) {

            System.out.println("\nFuncionário " + (i + 1));

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();

            System.out.print("Salário: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();

            funcionarios[i] = new Funcionario(
                    nome,
                    idade,
                    cargo,
                    salario
            );
        }

        System.out.println("\nFuncionários cadastrados com sucesso!");
    }

    // =========================
    // LISTAR
    // =========================

    public static void listarFuncionarios() {

        System.out.println("\n=== FUNCIONÁRIOS ===");

        for (int i = 0; i < funcionarios.length; i++) {

            Funcionario funcionario = funcionarios[i];

            System.out.println("\nFuncionário " + (i + 1));
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Idade: " + funcionario.getIdade());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.printf("Salário: R$ %.2f%n", funcionario.getSalario());
        }
    }

    // =========================
    // MAIOR SALÁRIO
    // =========================

    public static void maiorSalario() {

        Funcionario maior = funcionarios[0];

        for (int i = 1; i < funcionarios.length; i++) {

            if (funcionarios[i].getSalario() > maior.getSalario()) {
                maior = funcionarios[i];
            }
        }

        System.out.println("\n=== MAIOR SALÁRIO ===");

        System.out.println("Nome: " + maior.getNome());
        System.out.println("Cargo: " + maior.getCargo());
        System.out.printf("Salário: R$ %.2f%n", maior.getSalario());
    }

    // =========================
    // MÉDIA SALARIAL
    // =========================

    public static double calcularMedia() {

        double soma = 0;

        for (int i = 0; i < funcionarios.length; i++) {
            soma += funcionarios[i].getSalario();
        }

        return soma / funcionarios.length;
    }

    public static void mediaSalarial() {

        double media = calcularMedia();

        System.out.println("\n=== MÉDIA SALARIAL ===");

        System.out.printf("Média salarial: R$ %.2f%n", media);
    }

    // =========================
    // SALÁRIOS ACIMA DA MÉDIA
    // =========================

    public static void salariosAcimaDaMedia() {

        double media = calcularMedia();

        System.out.println("\n=== SALÁRIOS ACIMA DA MÉDIA ===");

        System.out.printf("Média salarial: R$ %.2f%n", media);

        for (int i = 0; i < funcionarios.length; i++) {

            if (funcionarios[i].getSalario() > media) {

                System.out.println(
                        funcionarios[i].getNome()
                                + " - "
                                + funcionarios[i].getCargo()
                                + " - R$ "
                                + funcionarios[i].getSalario()
                );
            }
        }
    }
}