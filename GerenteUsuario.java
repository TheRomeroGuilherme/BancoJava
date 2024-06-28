import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenteUsuario extends Gerente {

    private String senha;

    public GerenteUsuario(String nome, String endereco, String rg, String cpf, String telefone, String matricula,
            String senha) {
        super(nome, endereco, rg, cpf, telefone, matricula);
        this.senha = senha;
    }

    // Método para exibir a interface gráfica de login
    public void login() {
        JFrame frame = new JFrame("Login de Gerente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel matriculaLabel = new JLabel("Matrícula:");
        JTextField matriculaField = new JTextField();
        JLabel senhaLabel = new JLabel("Senha:");
        JPasswordField senhaField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        frame.add(matriculaLabel);
        frame.add(matriculaField);
        frame.add(senhaLabel);
        frame.add(senhaField);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = matriculaField.getText();
                String senha = new String(senhaField.getPassword());

                if (matricula.equals(getMatricula()) && senha.equals(GerenteUsuario.this.senha)) {
                    frame.dispose();
                    showMenu();
                } else {
                    JOptionPane.showMessageDialog(frame, "Matrícula ou senha incorretos.");
                }
            }
        });

        frame.setVisible(true);
    }

    // Método para exibir o menu do gerente
    private void showMenu() {
        JFrame frame = new JFrame("Menu do Gerente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JLabel nomeGerenteLabel = new JLabel("Gerente: " + getNome());
        nomeGerenteLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(nomeGerenteLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton pesquisarClienteButton = new JButton("Pesquisar Cliente");
        JButton visualizarSaldosButton = new JButton("Visualizar Saldos");
        JButton rendimentosButton = new JButton("Rendimentos");
        JButton realizarTransferenciaButton = new JButton("Realizar Transferência");
        JButton realizarDepositoButton = new JButton("Realizar Depósito");
        JButton voltarButton = new JButton("Voltar");

        pesquisarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para pesquisar cliente
                JOptionPane.showMessageDialog(frame, "Pesquisar Cliente");
            }
        });

        visualizarSaldosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para visualizar saldos
                JOptionPane.showMessageDialog(frame, "Visualizar Saldos");
            }
        });

        rendimentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para rendimentos
                JOptionPane.showMessageDialog(frame, "Rendimentos");
            }
        });

        realizarTransferenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para realizar transferência
                JOptionPane.showMessageDialog(frame, "Realizar Transferência");
            }
        });

        realizarDepositoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para realizar depósito
                JOptionPane.showMessageDialog(frame, "Realizar Depósito");
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        buttonPanel.add(pesquisarClienteButton);
        buttonPanel.add(visualizarSaldosButton);
        buttonPanel.add(rendimentosButton);
        buttonPanel.add(realizarTransferenciaButton);
        buttonPanel.add(realizarDepositoButton);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GerenteUsuario gerente = new GerenteUsuario("Gerente", "Endereço", "00000000", "00000000000", "0000000000",
                "#GER001", "senha1234");
        gerente.login();
    }
}
