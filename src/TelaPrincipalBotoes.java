import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipalBotoes extends JFrame{
    private JPanel Principal;
    private JButton usuariosButton;
    private JButton sairButton;
    private JButton CADASTROButton;
    private JButton VENDASButton;

    public TelaPrincipalBotoes(){
        setContentPane(Principal);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu com botões");
        setLocationRelativeTo(null);
        setVisible(true);

        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCadastroLogin formCadLogin = new FormCadastroLogin();
                formCadLogin.setVisible(true);
            }
        });
    }
}
