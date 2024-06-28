import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Cria o frame principal
            JFrame frame = new JFrame("Menu Principal");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 450); // Tamanho para proporção 16:9
            frame.setLayout(new BorderLayout());

            // Cria um painel para o texto "Usuário"
            JPanel userPanel = new JPanel();
            JLabel userLabel = new JLabel("Usuários");
            userLabel.setFont(new Font("Arial", Font.BOLD, 24));
            userPanel.add(userLabel);
            frame.add(userPanel, BorderLayout.NORTH);

            // Cria um painel para os botões com GridBagLayout para centralizar e alinhar os
            // botões
            JPanel buttonPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os botões
            gbc.fill = GridBagConstraints.HORIZONTAL; // Para fazer os botões preencherem horizontalmente

            // Adiciona um painel branco como fundo para os botões
            JPanel backgroundPanel = new JPanel();
            backgroundPanel.setBackground(Color.WHITE);
            backgroundPanel.setLayout(new GridBagLayout());
            backgroundPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Adiciona uma borda preta

            // Botão "Clientes"
            JButton clientesButton = new JButton("Clientes");
            clientesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Clientes");
                }
            });
            clientesButton.setPreferredSize(new Dimension(200, 50)); // Define o tamanho dos botões
            gbc.gridx = 0;
            gbc.gridy = 0;
            backgroundPanel.add(clientesButton, gbc);

            // Botão "Funcionário"
            JButton funcionarioButton = new JButton("Funcionário");
            funcionarioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Funcionário");
                }
            });
            funcionarioButton.setPreferredSize(new Dimension(200, 50)); // Define o tamanho dos botões
            gbc.gridy = 1;
            backgroundPanel.add(funcionarioButton, gbc);

            // Botão "Gerente"
            JButton gerenteButton = new JButton("Gerente");
            gerenteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Gerente");
                }
            });
            gerenteButton.setPreferredSize(new Dimension(200, 50)); // Define o tamanho dos botões
            gbc.gridy = 2;
            backgroundPanel.add(gerenteButton, gbc);

            // Botão "Diretor"
            JButton diretorButton = new JButton("Diretor");
            diretorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Diretor");
                }
            });
            diretorButton.setPreferredSize(new Dimension(200, 50)); // Define o tamanho dos botões
            gbc.gridy = 3;
            backgroundPanel.add(diretorButton, gbc);

            // Adiciona o painel branco ao painel de botões
            buttonPanel.add(backgroundPanel);
            frame.add(buttonPanel, BorderLayout.CENTER);

            // Torna o frame visível
            frame.setVisible(true);
        });
    }
}
