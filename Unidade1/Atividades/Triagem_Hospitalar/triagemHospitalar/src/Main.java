import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //FIFO
    private static Queue<String> filaNormal = new LinkedList<>();
    //LIFO
    private static Stack<String> filaPrioridade = new Stack<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== 1. CHEGADA DE PACIENTES NORMAIS E PRIORITÁRIOS ===");
        System.out.println("Adicionar: 1");
        System.out.println("Adicionar Prioritario: 2");
        System.out.println("Atender: 3");
        System.out.println("Exibir: 4");
        System.out.println("Encerrando 0");
        int opcao;
        do{
            System.out.printf("Escolha uma Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("Paciente Normal Adicionado!");
                    adicionarPacienteNormal();
                    break;
                case 2:
                    System.out.println("Paciente Prioritario Adicionado!");
                    adicionarPacientePrioritario();
                    break;
                case 3:
                    System.out.println("Atendido");
                    atender();
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    exibirFila();
                    break;
                case 0:

                    break;
            }
        }while (opcao != 0 );




    }
    private static void adicionarPacienteNormal(){
        System.out.println("DIGITE O NOME DO PACIENTE:");
        String nome = scanner.nextLine();
        filaNormal.offer(nome);
    }
    private static void adicionarPacientePrioritario(){
        System.out.println("DIGITE O NOME DO PACIENTE:");
        String nome = scanner.nextLine();
            filaPrioridade.push(nome);
    }
    private static void atender(){
        if (!filaPrioridade.isEmpty()){
            String paciente = filaPrioridade.pop();
            System.out.println("Paciente: " + paciente );
        }else if (!filaNormal.isEmpty()){
            String paciente = filaNormal.poll();
            System.out.println("Paciente: " + paciente );
        }else {
            System.out.println("Não a pacientes aguardando atendimento");
        }

    }
    private static void exibirFila(){
        if (filaPrioridade.isEmpty()){
            System.out.println("Nenhum paciente prioritario");
        }else{
            System.out.println(filaPrioridade);
        }
        if (filaNormal.isEmpty()){
            System.out.println("Nenhum paciente normal");
        }else {
            System.out.println(filaNormal);
        }
    }
}