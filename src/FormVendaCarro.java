import dao.VendaDao;
import dao.CarrosDao;
import modelo.Venda;
import modelo.Carros;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormVendaCarro extends JFrame{
    private JTextField TF_VALORVENDA;
    private JTextField TF_DATAVENDA;
    private JButton CONFIRMARButton;
    private JButton EXCLUIRButton;
    private JTable table2;
    private JPanel Principal2;
    private JComboBox<Carros> CB_Carros;

    String[] colunasVendas = {"ID Venda", "Modelo Carro", "Valor Final", "Data"};
    DefaultTableModel modelVendas = new DefaultTableModel(colunasVendas, 0);

    private VendaDao vendaDao;
    private CarrosDao carrosDao;

    public FormVendaCarro(CarrosDao carrosDao, VendaDao vendaDao) {
        this.carrosDao = carrosDao;
        this.vendaDao = vendaDao;
        table2.setModel(modelVendas);
        listarVendas();
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

                    Venda novaVenda = new Venda();
                    novaVenda.setValorFinal(valorVenda);
                    novaVenda.setDataVenda(dataVenda);
                    novaVenda.setIdCarro(carroSelecionado.getIdCarro());
                    novaVenda.setIdUsuario(1);

                    if (vendaDao.registrarVenda(novaVenda)) {
                        JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");
                        carrosDao.darBaixaEstoque(carroSelecionado.getIdCarro());
                        TF_VALORVENDA.setText("");
                        TF_DATAVENDA.setText("");

                        carregarCarros();
                        listarVendas();

                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao registrar a venda.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro de formato!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + ex.getMessage());
                }
            }
        });
        EXCLUIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = table2.getSelectedRow();
                if (linhaSelecionada == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma venda na tabela para excluir.");
                    return;
                }
                int idVendaParaExcluir = (int) table2.getValueAt(linhaSelecionada, 0);

                int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta venda?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

                if (confirmacao == JOptionPane.YES_OPTION) {
                    Venda vendaExcluida = vendaDao.buscarVendaPorId(idVendaParaExcluir);
                    if (vendaExcluida == null) {
                        JOptionPane.showMessageDialog(null, "Erro: Venda não encontrada");
                        return;
                    }

                    if (vendaDao.excluirVenda(idVendaParaExcluir)) {
                        carrosDao.aumentarEstoque(vendaExcluida.getIdCarro());
                        JOptionPane.showMessageDialog(null, "Venda excluída com sucesso!");

                        listarVendas();
                        carregarCarros();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir a venda.");
                    }
                }
            }
        });
    }
    private void carregarCarros() {
        CB_Carros.removeAllItems();
        for (Carros carro : carrosDao.getListaCarros()) {
            CB_Carros.addItem(carro);
        }
    }
    public void listarVendas() {
        modelVendas.setRowCount(0);

        for (Venda venda : this.vendaDao.getListaVendas()) {
            Carros carroVendido = this.carrosDao.buscarCarroPorId(venda.getIdCarro());

            String modeloCarro = (carroVendido != null) ? carroVendido.getModeloCarro() : "Carro não encontrado";

            Object[] linha = {
                    venda.getIdVenda(),
                    modeloCarro,
                    venda.getValorFinal(),
                    venda.getDataVenda()
            };
            modelVendas.addRow(linha);
        }
    }
}
