import java.util.ArrayList;
import java.util.List;

public class Gerente extends Funcionario {
    private String senha;
    private List<Cliente> listaDeClientes;

    public Gerente(String nome, String endereco, String rg, String cpf, String telefone, String matricula) {
        super(nome, endereco, rg, cpf, telefone, matricula);
        this.listaDeClientes = new ArrayList<>();
    }

    // Métodos para cadastrar clientes e contas
    public void cadastrarCliente(Cliente cliente) {
        listaDeClientes.add(cliente);
    }

    public void cadastrarConta(Conta conta, Cliente cliente) {
        cliente.getContas().add(conta);
    }

    // Getters e Setters
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }
}
