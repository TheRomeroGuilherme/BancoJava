public class Funcionario extends Pessoa {
    private String matricula;

    public Funcionario(String nome, String endereco, String rg, String cpf, String telefone, String matricula) {
        super(nome, endereco, rg, cpf, telefone);
        this.matricula = matricula;
    }

    // Getter e Setter
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
