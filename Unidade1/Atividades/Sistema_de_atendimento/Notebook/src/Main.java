public class Main {

    public static void main(String[] args) {

        //Instacia a classe F
        FilaClinica clinica = new FilaClinica();

        System.out.println("=== 1. CHEGADA DE PACIENTES NORMAIS E PRIORITÁRIOS ===");

        clinica.adicionar("João", 30);
        clinica.adicionar("Maria", 25);
        clinica.adicionar("Vovó Ana", 72);
        clinica.adicionar("Pedro", 40);
        clinica.adicionar("Vovô Bento", 80);

        clinica.listar_espera();

        System.out.println("=== 2. ATENDIMENTO DOS PACIENTES ===");

        clinica.atender();
        clinica.listar_espera();

        clinica.atender();
        clinica.listar_espera();

        System.out.println("=== 3. ATENDENDO O RESTANTE DOS PACIENTES ===");

        clinica.atender();
        clinica.atender();
        clinica.atender();

        System.out.println();

        System.out.println("=== 4. TENTANDO ATENDER COM FILA VAZIA ===");

        clinica.atender();
        clinica.listar_espera();
    }
}