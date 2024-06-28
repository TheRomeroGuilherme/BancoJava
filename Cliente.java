import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private Gerente gerente;
    private List<Conta> contas;

    public Cliente(String nome, String endereco, String rg, String cpf, String telefone, Gerente gerente) {
        super(nome, endereco, rg, cpf, telefone);
        this.gerente = gerente;
        this.contas = new ArrayList<>();
    }

    // Getters e Setters
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
