import javax.swing.*;
import dao.VendaDao;
import dao.CarrosDao;
import modelo.Venda;
import modelo.Carros;

public class formTelaLogin extends JFrame{
    private JPanel Principal;
    private JTextField textField1;
    private JTextField textField2;
    private JButton entrarButton;
    private JButton cadastrarButton;
    private JPasswordField passwordField1;

    private VendaDao vendaDao;
    private CarrosDao carrosDao;

    public formTelaLogin(){
        setContentPane(Principal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Registro de Venda");
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

}
