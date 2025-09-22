import dao.CarrosDao;
import dao.LoginDao;
import dao.VendaDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipalBotoes extends JFrame {
    private JPanel Principal;
    private JButton usuariosButton;
    private JButton sairButton;
    private JButton CADASTROButton;
    private JButton VENDASButton;

    public TelaPrincipalBotoes(LoginDao loginDao, CarrosDao carrosDao, VendaDao vendaDao) {
        setContentPane(Principal);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setLocationRelativeTo(null);

        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCadastroLogin formCadLogin = new FormCadastroLogin(loginDao);
                formCadLogin.setVisible(true);
            }
        });

        CADASTROButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCadastroCarro formCadCarro = new FormCadastroCarro(carrosDao, vendaDao);
                formCadCarro.setVisible(true);
            }
        });

        VENDASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormVendaCarro formVenda = new FormVendaCarro(carrosDao, vendaDao);
                formVenda.setVisible(true);
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcao = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja sair?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}