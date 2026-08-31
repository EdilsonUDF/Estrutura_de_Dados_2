public class Main {

    public static void main(String[] args) {

        // Instancia a fila da clínica
        FilaClinica clinica = new FilaClinica();

        System.out.println("=== 1. CHEGADA DE PACIENTES NORMAIS E PRIORITÁRIOS ===");

        // Adiciona os pacientes na fila
        clinica.adicionar("João", 30);
        clinica.adicionar("Maria", 25);
        clinica.adicionar("Vovó Ana", 72);
        clinica.adicionar("Pedro", 40);
        clinica.adicionar("Vovô Bento", 80);

        // Mostra como a fila ficou depois das chegadas
        // Os pacientes com 60 anos ou mais ficam na frente
        clinica.listar_espera();

        System.out.println("=== 2. ATENDIMENTO DOS PACIENTES ===");

        // Primeiro deve ser atendida a Vovó Ana, que é prioritária
        clinica.atender();
        clinica.listar_espera();

        // Agora o próximo prioritário é o Vovô Bento
        clinica.atender();
        clinica.listar_espera();

        System.out.println("=== 3. ATENDENDO O RESTANTE DOS PACIENTES ===");

        // Depois dos prioritários, atende os pacientes normais
        clinica.atender();
        clinica.atender();
        clinica.atender();

        System.out.println();

        System.out.println("=== 4. TENTANDO ATENDER COM FILA VAZIA ===");

        // Aqui a fila já está vazia, então não deve atender ninguém
        clinica.atender();

        // Confirma que realmente não ficou ninguém na fila
        clinica.listar_espera();
    }
}