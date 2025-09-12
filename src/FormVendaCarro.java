import dao.VendaDao;
import dao.CarrosDao;
import modelo.Venda;
import modelo.Carros;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormVendaCarro extends JFrame{
    private JTextField TF_IDVENDA;
    private JTextField TF_VALORVENDA;
    private JTextField TF_DATAVENDA;
    private JButton CONFIRMARButton;
    private JButton EXCLUIRButton;
    private JTable table2;
    private JPanel Principal2;
    private JComboBox<Carros> CB_Carros;

    private VendaDao vendaDao;
    private CarrosDao carrosDao;

    public FormVendaCarro(CarrosDao carrosDao) {
        this.carrosDao = carrosDao;
        this.vendaDao = new VendaDao();
        setContentPane(Principal2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Registro de Venda");
        setSize(500, 400);
        setLocationRelativeTo(null);

        carregarCarros();

        CONFIRMARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Carros carroSelecionado = (Carros) CB_Carros.getSelectedItem();

                    if (carroSelecionado == null) {
                        JOptionPane.showMessageDialog(null, "Por favor, selecione um carro para vender.");
                        return;
                    }

                    if (carroSelecionado.getEstoque() <= 0) {
                        JOptionPane.showMessageDialog(null, "Este carro não possui estoque disponível para venda.");
                        return;
                    }

                    double valorVenda = Double.parseDouble(TF_VALORVENDA.getText());
                    String dataVenda = TF_DATAVENDA.getText();
                    int idVenda = Integer.parseInt(TF_IDVENDA.getText());

                    Venda novaVenda = new Venda();
                    novaVenda.setIdVenda(idVenda);
                    novaVenda.setValorFinal(valorVenda);
                    novaVenda.setDataVenda(dataVenda);
                    novaVenda.setIdCarro(carroSelecionado.getIdCarro());
                    novaVenda.setIdUsuario(1);

                    if (vendaDao.registrarVenda(novaVenda)) {
                        JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");
                        carrosDao.darBaixaEstoque(carroSelecionado.getIdCarro());  //tinha um this aqui ein, oia só
                        TF_IDVENDA.setText("");
                        TF_VALORVENDA.setText("");
                        TF_DATAVENDA.setText("");

                        carregarCarros();

                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao registrar a venda.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro de formato! Verifique se os campos ID e Valor contêm apenas números válidos.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + ex.getMessage());
                }
            }
        });
        EXCLUIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    private void carregarCarros() {
        CB_Carros.removeAllItems();
        for (Carros carro : carrosDao.getListaCarros()) {
            CB_Carros.addItem(carro);
        }
    }
}
