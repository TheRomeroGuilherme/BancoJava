import java.util.ArrayList;
import java.util.List;

public class Diretor extends Funcionario {
    private List<Gerente> listaDeGerentes;
    private String senha;

    public Diretor(String nome, String endereco, String rg, String cpf, String telefone, String matricula) {
        super(nome, endereco, rg, cpf, telefone, matricula);
        this.listaDeGerentes = new ArrayList<>();
        this.senha = "ProtocoloX"; // Definindo a senha padrão
    }

    // Métodos para cadastrar e remover gerentes
    public void cadastrarGerente(Gerente gerente) {
        listaDeGerentes.add(gerente);
    }

    public void removerGerente(Gerente gerente) {
        listaDeGerentes.remove(gerente);
    }

    // Getter e Setter para a senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Getters e Setters para listaDeGerentes
    public List<Gerente> getListaDeGerentes() {
        return listaDeGerentes;
    }

    public void setListaDeGerentes(List<Gerente> listaDeGerentes) {
        this.listaDeGerentes = listaDeGerentes;
    }
}
