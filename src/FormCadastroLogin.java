import dao.LoginDao;
import modelo.Login;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCadastroLogin extends JFrame {
    private JPanel Principal;
    private JTextField TF_Nome;
    private JPasswordField TF_Senha;
    private JTextField TF_Email;
    private JButton cadastrarButton;
    private JButton listarButton;
    private JTable table1;
    private JButton usuarioButton;

    private LoginDao loginDao;

    private String[] colunas = {"ID", "NOME", "E-MAIL", "DATA CADASTRO", "DATA ATUALIZAÇÃO"};
    private DefaultTableModel model = new DefaultTableModel(colunas, 0);

    public FormCadastroLogin(LoginDao loginDao) {
        this.loginDao = loginDao;

        setContentPane(Principal);
        table1.setModel(model);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        setSize(600, 600);
        setLocationRelativeTo(null);

        habilitarCampos(false);
        cadastrarButton.setEnabled(false);
        listarUsuarios();

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                String nome = TF_Nome.getText();
                String email = TF_Email.getText();
                String senha = new String(TF_Senha.getPassword());

                try {
                    login.setNome(nome);
                    login.setEmail(email);
                    login.setSenha(senha);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                login.setDataCadastro("2025-01-01"); // Exemplo
                if (loginDao.inserirLogin(login)) {
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.");
                    listarUsuarios();
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar o usuário.");
                }
                usuarioButton.setEnabled(true);
                listarButton.setEnabled(true);
                cadastrarButton.setEnabled(false);
                habilitarCampos(false);
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarUsuarios();
            }
        });

        usuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habilitarCampos(true);
                cadastrarButton.setEnabled(true);
                usuarioButton.setEnabled(false);
                listarButton.setEnabled(false);
            }
        });
    }

    public void limparCampos() {
        TF_Nome.setText("");
        TF_Email.setText("");
        TF_Senha.setText("");
    }

    public void habilitarCampos(boolean status) {
        TF_Senha.setEnabled(status);
        TF_Email.setEnabled(status);
        TF_Nome.setEnabled(status);
    }

    public void listarUsuarios() {
        model.setRowCount(0);
        if (this.loginDao != null && this.loginDao.getLista() != null) {
            for (Login l : this.loginDao.getLista()) {
                Object[] linha = {
                        l.getId(), l.getNome(), l.getEmail(),
                        l.getDataCadastro(), l.getDataAtualizacao()
                };
                model.addRow(linha);
            }
        }
    }
}