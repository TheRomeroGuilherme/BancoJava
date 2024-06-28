import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DiretorUsuario extends Diretor {

    private String senha;

    public DiretorUsuario(String nome, String endereco, String rg, String cpf, String telefone, String matricula,
            String senha) {
        super(nome, endereco, rg, cpf, telefone, matricula);
        this.senha = senha;
    }

    // Método para exibir a interface gráfica de login
    public void login() {
        JFrame frame = new JFrame("Login de Diretor");
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

                if (matricula.equals(getMatricula()) && senha.equals(DiretorUsuario.this.senha)) {
                    frame.dispose();
                    showMenu();
                } else {
                    JOptionPane.showMessageDialog(frame, "Matrícula ou senha incorretos.");
                }
            }
        });

        frame.setVisible(true);
    }

    // Método para exibir o menu do diretor
    private void showMenu() {
        JFrame frame = new JFrame("Menu do Diretor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JButton cadastrarGerenteButton = new JButton("Cadastrar Gerente");
        JButton removerGerenteButton = new JButton("Remover Gerente");
        JButton alterarGerenteButton = new JButton("Alterar Gerente");
        JButton voltarButton = new JButton("Voltar");

        cadastrarGerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarGerente();
            }
        });

        removerGerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerGerente();
            }
        });

        alterarGerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarGerente();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(cadastrarGerenteButton);
        frame.add(removerGerenteButton);
        frame.add(alterarGerenteButton);
        frame.add(voltarButton);

        frame.setVisible(true);
    }

    private void cadastrarGerente() {
        JFrame frame = new JFrame("Cadastrar Gerente");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel enderecoLabel = new JLabel("Endereço:");
        JTextField enderecoField = new JTextField();
        JLabel rgLabel = new JLabel("RG:");
        JTextField rgField = new JTextField();
        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField();
        JLabel telefoneLabel = new JLabel("Telefone:");
        JTextField telefoneField = new JTextField();
        JLabel matriculaLabel = new JLabel("Matrícula:");
        JTextField matriculaField = new JTextField();
        JLabel senhaLabel = new JLabel("Senha:");
        JPasswordField senhaField = new JPasswordField();
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton voltarButton = new JButton("Voltar");

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String endereco = enderecoField.getText();
                String rg = rgField.getText();
                String cpf = cpfField.getText();
                String telefone = telefoneField.getText();
                String matricula = matriculaField.getText();
                String senha = new String(senhaField.getPassword());

                Gerente gerente = new Gerente(nome, endereco, rg, cpf, telefone, matricula);
                gerente.setSenha(senha);

                // Simula o cadastro adicionando o gerente a uma estrutura de dados
                // No contexto real, isso seria armazenado em um banco de dados
                // ou outra fonte de persistência de dados.
                JOptionPane.showMessageDialog(frame, "Gerente cadastrado com sucesso!");
                frame.dispose();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(nomeLabel);
        frame.add(nomeField);
        frame.add(enderecoLabel);
        frame.add(enderecoField);
        frame.add(rgLabel);
        frame.add(rgField);
        frame.add(cpfLabel);
        frame.add(cpfField);
        frame.add(telefoneLabel);
        frame.add(telefoneField);
        frame.add(matriculaLabel);
        frame.add(matriculaField);
        frame.add(senhaLabel);
        frame.add(senhaField);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(cadastrarButton);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(voltarButton);

        frame.setVisible(true);
    }

    private void removerGerente() {
        JFrame frame = new JFrame("Remover Gerente");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel matriculaLabel = new JLabel("Matrícula do Gerente:");
        JTextField matriculaField = new JTextField();
        JLabel motivoLabel = new JLabel("Motivo da Remoção:");
        JTextField motivoField = new JTextField();
        JButton removerButton = new JButton("Remover");
        JButton voltarButton = new JButton("Voltar");

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = matriculaField.getText();
                String motivo = motivoField.getText();

                int confirmacao = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja remover o gerente?",
                        "Confirmação de Remoção", JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
                    // Lógica para remover o gerente (simulada)
                    JOptionPane.showMessageDialog(frame, "Gerente removido com sucesso!");
                    frame.dispose();
                }
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(matriculaLabel);
        frame.add(matriculaField);
        frame.add(motivoLabel);
        frame.add(motivoField);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(removerButton);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(voltarButton);

        frame.setVisible(true);
    }

    private void alterarGerente() {
        JFrame frame = new JFrame("Alterar Gerente");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        JLabel matriculaLabel = new JLabel("Matrícula do Gerente:");
        JTextField matriculaField = new JTextField();
        JLabel nomeLabel = new JLabel("Novo Nome:");
        JTextField nomeField = new JTextField();
        JLabel enderecoLabel = new JLabel("Novo Endereço:");
        JTextField enderecoField = new JTextField();
        JLabel rgLabel = new JLabel("Novo RG:");
        JTextField rgField = new JTextField();
        JLabel cpfLabel = new JLabel("Novo CPF:");
        JTextField cpfField = new JTextField();
        JButton salvarButton = new JButton("Salvar");
        JButton voltarButton = new JButton("Voltar");

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = matriculaField.getText();
                String nome = nomeField.getText();
                String endereco = enderecoField.getText();
                String rg = rgField.getText();
                String cpf = cpfField.getText();

                // Simula a alteração dos dados do gerente (atualização simulada)
                JOptionPane.showMessageDialog(frame, "Alteração salva!");
                frame.dispose();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(matriculaLabel);
        frame.add(matriculaField);
        frame.add(nomeLabel);
        frame.add(nomeField);
        frame.add(enderecoLabel);
        frame.add(enderecoField);
        frame.add(rgLabel);
        frame.add(rgField);
        frame.add(cpfLabel);
        frame.add(cpfField);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(salvarButton);
        frame.add(new JLabel()); // Espaço vazio
        frame.add(voltarButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Exemplo de inicialização do diretor
        DiretorUsuario diretor = new DiretorUsuario("Nome Diretor", "Endereço Diretor", "123456789", "987654321",
                "999999999", "#DIR001", "ProtocoloX");
        diretor.login();
    }
}
