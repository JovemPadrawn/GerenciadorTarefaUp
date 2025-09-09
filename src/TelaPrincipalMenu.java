import javax.swing.*;
import javax.swing.text.html.FormView;
import java.awt.*;

public class TelaPrincipalMenu extends JFrame{
    private JPanel principal;

    public TelaPrincipalMenu(){
        setContentPane(principal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        setTitle("Tela de menus");
        setVisible(true);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuUsuario = new JMenu("Usuario");
        menuBar.add(menuUsuario);

        JMenuItem cadastroUsuario = new JMenuItem("Novo Usuario");
        menuUsuario.add(cadastroUsuario);
        menuUsuario.addActionListener(e -> new FormCadastroLogin());

        JMenuItem relatorioUsuario = new JMenuItem("Relatorio");
        menuUsuario.add(relatorioUsuario);

        JMenu menuTarefa = new JMenu("Tarefa");
        menuBar.add(menuTarefa);

        JMenu menuSobre = new JMenu("Sobre");
        menuBar.add(menuSobre);

        JMenu menuSair = new JMenu("Sair");
        menuBar.add(menuSair);
    }
}
