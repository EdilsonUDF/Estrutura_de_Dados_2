
public class FilaClinica {

    Node inicio;
    Node fim;

    public void adicionar(String nome, int idade) {

        Paciente paciente = new Paciente(nome, idade);
        Node novo = new Node(paciente);

        // 1. Fila vazia
        if (inicio == null) {
            inicio = novo;
            fim = novo;
            return;
        }

        // 2. Paciente prioritário
        if (paciente.prioridade) {

            // Se o primeiro não for prioritário,
            // o novo paciente entra antes dele.
            if (!inicio.paciente.prioridade) {

                novo.proximo = inicio;
                inicio = novo;

                return;
            }

            // Procura o último paciente prioritário
            Node atual = inicio;

            while (atual.proximo != null &&
                    atual.proximo.paciente.prioridade) {

                atual = atual.proximo;
            }

            // Insere depois do último prioritário
            novo.proximo = atual.proximo;
            atual.proximo = novo;

            // Se foi inserido no final, atualiza o fim
            if (novo.proximo == null) {
                fim = novo;
            }

            return;
        }

        // 3. Paciente normal
        fim.proximo = novo;
        fim = novo;
    }

    public void atender() {

        if (inicio == null) {
            System.out.println("Não há pacientes na fila.");
            return;
        }

        Paciente pacienteAtendido = inicio.paciente;

        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        System.out.println("Atendendo: " + pacienteAtendido);
    }

    public void listar_espera() {

        if (inicio == null) {
            System.out.println("Fila vazia.");
            return;
        }

        Node atual = inicio;

        System.out.println("Fila de espera:");

        while (atual != null) {

            System.out.println(atual.paciente);

            atual = atual.proximo;
        }

        System.out.println();
    }
}