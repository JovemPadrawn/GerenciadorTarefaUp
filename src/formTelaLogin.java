import dao.CarrosDao;
import dao.LoginDao;
import dao.VendaDao;
import modelo.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formTelaLogin extends JFrame {
    private JPanel Principal;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JButton entrarButton;
    private JButton cadastrarButton;

    private LoginDao loginDao;
    private CarrosDao carrosDao;
    private VendaDao vendaDao;

    public formTelaLogin(LoginDao loginDao, CarrosDao carrosDao, VendaDao vendaDao) {
        this.loginDao = loginDao;
        this.carrosDao = carrosDao;
        this.vendaDao = vendaDao;

        setContentPane(Principal);
        setTitle("Login do Sistema");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textField2.getText();
                String senha = new String(passwordField1.getPassword());

                Login usuarioLogado = null;
                for (Login usuario : loginDao.getLista()) {
                    if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                        usuarioLogado = usuario;
                        break;
                    }
                }

                if (usuarioLogado != null) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo, " + usuarioLogado.getNome() + "!");
                    TelaPrincipalBotoes telaPrincipal = new TelaPrincipalBotoes(loginDao, carrosDao, vendaDao);
                    telaPrincipal.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "E-mail ou senha inválidos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCadastroLogin formCadastro = new FormCadastroLogin(loginDao);
                formCadastro.setVisible(true);
            }
        });
    }
}