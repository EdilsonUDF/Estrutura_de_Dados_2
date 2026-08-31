import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Aluno[] alunos = new Aluno[5];

        // Cadastro dos alunos
        for (int i = 0; i < alunos.length; i++) {

            System.out.println("\nAluno " + (i + 1));

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = scanner.nextInt();

            System.out.print("Nota 1: ");
            double nota1 = scanner.nextDouble();

            System.out.print("Nota 2: ");
            double nota2 = scanner.nextDouble();

            System.out.print("Nota 3: ");
            double nota3 = scanner.nextDouble();

            scanner.nextLine(); // consome o Enter

            alunos[i] = new Aluno(
                    nome,
                    idade,
                    nota1,
                    nota2,
                    nota3
            );
        }

        int aprovados = 0;
        int reprovados = 0;

        double maiorMedia = 0;
        String alunoMaiorMedia = "";

        // Cálculo das médias
        for (int i = 0; i < alunos.length; i++) {

            double media = (
                    alunos[i].getNota1()
                            + alunos[i].getNota2()
                            + alunos[i].getNota3()
            ) / 3;

            System.out.printf(
                    "\n%s - Média: %.2f",
                    alunos[i].getNome(),
                    media
            );

            // Classificação
            if (media >= 7.0) {
                System.out.println(" - Aprovado");
                aprovados++;
            } else {
                System.out.println(" - Reprovado");
                reprovados++;
            }

            // Maior média
            if (media > maiorMedia) {
                maiorMedia = media;
                alunoMaiorMedia = alunos[i].getNome();
            }
        }

        // Resultado final
        System.out.println("\n==========================");
        System.out.println("RESULTADO FINAL");
        System.out.println("==========================");

        System.out.println("Quantidade de aprovados: " + aprovados);
        System.out.println("Quantidade de reprovados: " + reprovados);

        System.out.printf(
                "Aluno com maior média: %s (%.2f)%n",
                alunoMaiorMedia,
                maiorMedia
        );

        scanner.close();
    }
}