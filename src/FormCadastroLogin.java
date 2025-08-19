import dao.LoginDao;
import model.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormCadastroLogin extends JFrame{
    private JPanel Principal;
    private JTextField TF_Nome;
    private JPasswordField TF_Senha;
    private JTextField TF_Email;
    private JButton cadastrarButton;
    private JButton listarButton;

    LoginDao loginDao;

    public FormCadastroLogin() {
        setContentPane(Principal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);

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
                loginDao.inserirLogin(login);
               // loginDao.inserirLogin(new Login(nome, email, senha, dataCadastro, dataAtualizacao));

                System.out.println(loginDao.getLista());

                /*System.out.println("Nome: " + TF_Nome.getText());
                System.out.println("E-mail: " + TF_Email.getText());
                System.out.println("Senha: " + TF_Senha.getText());*/
            }
        });
    }
}
