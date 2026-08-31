public class Paciente {

    String nome;
    int idade;
    boolean prioridade;

    public Paciente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.prioridade = idade >= 60;
    }

    @Override
    public String toString() {
        if (prioridade) {
            return nome + " - " + idade + " anos [PRIORIDADE]";
        }

        return nome + " - " + idade + " anos [NORMAL]";
    }
}