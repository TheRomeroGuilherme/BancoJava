import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClienteUsuario extends Cliente {
    private String senha;
    private List<Conta> contas = new ArrayList<>();
    private List<String> extrato = new ArrayList<>();

    public ClienteUsuario(String nome, String endereco, String rg, String cpf, String telefone, Gerente gerente,
            String senha) {
        super(nome, endereco, rg, cpf, telefone, gerente);
        this.senha = senha;
    }

    // Método para exibir a interface gráfica de login
    public void login() {
        JFrame frame = new JFrame("Login de Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField();
        JLabel senhaLabel = new JLabel("Senha:");
        JPasswordField senhaField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        frame.add(cpfLabel);
        frame.add(cpfField);
        frame.add(senhaLabel);
        frame.add(senhaField);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String senha = new String(senhaField.getPassword());

                if (cpf.equals(getCpf()) && senha.equals(getSenha())) {
                    frame.dispose();
                    showMenu();
                } else {
                    JOptionPane.showMessageDialog(frame, "CPF ou senha incorretos.");
                }
            }
        });

        frame.setVisible(true);
    }

    // Método para exibir o menu de cliente
    private void showMenu() {
        JFrame frame = new JFrame("Menu do Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel nomeLabel = new JLabel("Bem-vindo, " + getPrimeiroUltimoNome());
        frame.add(nomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton consultaSaldoButton = new JButton("Consultar Saldo");
        JButton extratoButton = new JButton("Extrato");
        JButton transferenciaButton = new JButton("Transferência");
        JButton transferenciaPoupancaButton = new JButton("Transferência Poupança");
        JButton depositoButton = new JButton("Depósito");

        consultaSaldoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultaSaldo();
            }
        });

        extratoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarExtrato();
            }
        });

        transferenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarTransferencia();
            }
        });

        transferenciaPoupancaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferirParaPoupanca();
            }
        });

        depositoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarDeposito();
            }
        });

        buttonPanel.add(consultaSaldoButton);
        buttonPanel.add(extratoButton);
        buttonPanel.add(transferenciaButton);
        buttonPanel.add(transferenciaPoupancaButton);
        buttonPanel.add(depositoButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void consultaSaldo() {
        Conta conta = contas.get(0); // Assume a primeira conta como exemplo
        JOptionPane.showMessageDialog(null, "Saldo: " + conta.getSaldo());
        logOperation("Consulta de Saldo", conta.getSaldo());
    }

    private void mostrarExtrato() {
        JFrame frame = new JFrame("Extrato");
        frame.setSize(400, 300);
        JTextArea extratoArea = new JTextArea();
        extratoArea.setEditable(false);
        for (String linha : extrato) {
            extratoArea.append(linha + "\n");
        }
        frame.add(new JScrollPane(extratoArea));
        frame.setVisible(true);
        logOperation("Extrato", 0);
    }

    private void realizarTransferencia() {
        JFrame frame = new JFrame("Transferência");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel valorLabel = new JLabel("Valor:");
        JTextField valorField = new JTextField();
        JButton transferirButton = new JButton("Transferir");
        JButton voltarButton = new JButton("Voltar");

        transferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(valorField.getText());
                Conta contaAtual = contas.get(0); // Assume a primeira conta como exemplo
                Conta contaPoupanca = contas.get(1); // Assume a segunda conta como exemplo

                if (valor > 0 && valor <= contaAtual.getSaldo()) {
                    contaAtual.setSaldo(contaAtual.getSaldo() - valor);
                    contaPoupanca.setSaldo(contaPoupanca.getSaldo() + valor);
                    JOptionPane.showMessageDialog(frame, "Transferência realizada com sucesso!");
                    extrato.add("Transferência: -R$ " + valor);
                    logOperation("Transferência", valor);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Valor inválido para transferência.");
                }
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(valorLabel);
        frame.add(valorField);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(transferirButton);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(voltarButton);

        frame.setVisible(true);
    }

    private void transferirParaPoupanca() {
        JFrame frame = new JFrame("Transferência para Poupança");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel valorLabel = new JLabel("Valor:");
        JTextField valorField = new JTextField();
        JButton transferirButton = new JButton("Transferir");
        JButton voltarButton = new JButton("Voltar");

        transferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(valorField.getText());
                Conta contaAtual = contas.get(0); // Assume a primeira conta como exemplo
                Conta contaPoupanca = contas.get(1); // Assume a segunda conta como exemplo

                if (valor > 0 && valor <= contaAtual.getSaldo()) {
                    contaAtual.setSaldo(contaAtual.getSaldo() - valor);
                    contaPoupanca.setSaldo(contaPoupanca.getSaldo() + valor);
                    JOptionPane.showMessageDialog(frame, "Transferência para poupança realizada com sucesso!");
                    extrato.add("Transferência para Poupança: -R$ " + valor);
                    logOperation("Transferência Poupança", valor);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Valor inválido para transferência.");
                }
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(valorLabel);
        frame.add(valorField);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(transferirButton);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(voltarButton);

        frame.setVisible(true);
    }

    private void realizarDeposito() {
        JFrame frame = new JFrame("Depósito");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2));

        JLabel receptorLabel = new JLabel("Receptor:");
        JTextField receptorField = new JTextField();
        JLabel valorLabel = new JLabel("Valor:");
        JTextField valorField = new JTextField();
        JButton depositarButton = new JButton("Depositar");
        JButton voltarButton = new JButton("Voltar");

        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String receptor = receptorField.getText();
                double valor = Double.parseDouble(valorField.getText());
                Conta contaAtual = contas.get(0); // Assume a primeira conta como exemplo

                if (valor > 0 && !receptor.isEmpty()) {
                    contaAtual.setSaldo(contaAtual.getSaldo() - valor);
                    JOptionPane.showMessageDialog(frame, "Depósito realizado com sucesso para " + receptor);
                    extrato.add("Depósito: -R$ " + valor + " para " + receptor);
                    logOperation("Depósito", valor);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Valor ou receptor inválido.");
                }
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(receptorLabel);
        frame.add(receptorField);
        frame.add(valorLabel);
        frame.add(valorField);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(depositarButton);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(voltarButton);

        frame.setVisible(true);
    }

    // Método para registrar operações em um arquivo de log
    private void logOperation(String operationType, double amount) {
        try (FileWriter writer = new FileWriter("HistoricoLOG.txt", true)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = now.format(formatter);
            String logEntry = String.format(
                    "ID: %s, Operação: %s, Conta: %s, Valor: %.2f, Saldo Antes: %.2f, Saldo Depois: %.2f, Data e Hora: %s\n",
                    getCpf(), operationType, "", amount, 0.0, 0.0, timestamp);
            writer.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters e Setters
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String getPrimeiroUltimoNome() {
        String[] nomes = getNome().split(" ");
        if (nomes.length > 1) {
            return nomes[0] + " " + nomes[nomes.length - 1];
        } else {
            return getNome();
        }
    }
}
