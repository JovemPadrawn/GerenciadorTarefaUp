import dao.LoginDao;
import modelo.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCadastroLogin extends JFrame{
    private JPanel Principal;
    private JTextField TF_Nome;
    private JPasswordField TF_Senha;
    private JTextField TF_Email;
    private JButton cadastrarButton;
    private JButton listarButton;
    private JTable table1;

    LoginDao loginDao;

    String[] colunas = {"ID", "NOME", "E-MAIL", "DATA CADASTRO", "DATA ATUALIZAÇÂO"};

    DefaultTableModel model = new DefaultTableModel(colunas, 0);

    public FormCadastroLogin() {
        setContentPane(Principal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        table1.setModel(model);

        loginDao = new LoginDao();

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = TF_Nome.getText();
                String email = TF_Email.getText();
                String senha = TF_Senha.getText();

                String dataCadastro = "2025-08-14" ;
                String dataAtualizacao= "";

                Login login = new Login(nome, email, senha, dataCadastro, dataAtualizacao);
                if(loginDao.inserirLogin(login)){
                    JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario!");
                }

            }
        });
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(loginDao.getLista());

                model.setRowCount(0);
                for (Login l : loginDao.getLista()){
                    Object[] linha = {
                            l.getId(),
                            l.getNome(),
                            l.getEmail(),
                            l.getDataCadastro(),
                            l.getDataAtualizacao()
                    };
                    model.addRow(linha);
                }
            }
        });
    }
}
