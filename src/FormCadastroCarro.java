import dao.CarrosDao;
import modelo.Carros;
import dao.VendaDao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCadastroCarro extends JFrame{
    private JTextField TF_ID;
    private JTextField TF_Modelo;
    private JTextField TF_Cor;
    private JTextField TF_Estoque;
    private JTextField TF_Valor;
    private JButton cadastrarButton;
    private JButton listarButton;
    private JPanel Principal;
    private JTable table1;
    private JButton Vendas;
    private JButton excluirButton;
    private JButton alterarButton;
    private JButton salvarButton;

    private CarrosDao carrosDao;
    //private VendaDao vendaDao;

    String[] colunas = {"IDCARRO","MODELO","COR","ESTOQUE","VALOR"};

    DefaultTableModel model = new DefaultTableModel(colunas, 0);

    public FormCadastroCarro(CarrosDao carrosDao, VendaDao vendaDao){
        this.carrosDao = carrosDao;
        //this.vendaDao = vendaDao;
        setContentPane(Principal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Carro");
        setSize(650, 400);
        setLocationRelativeTo(null);

        table1.setModel(model);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(TF_ID.getText());
                    String modelo = TF_Modelo.getText();
                    String cor = TF_Cor.getText();
                    int estoque = Integer.parseInt(TF_Estoque.getText());
                    double valor = Double.parseDouble(TF_Valor.getText());

                    Carros carros = new Carros();

                    carros.setIdCarro(id);
                    carros.setModeloCarro(modelo);
                    carros.setCorCarro(cor);
                    carros.setEstoque(estoque);
                    carros.setValor(valor);

                    if (carrosDao.inserirCarro(carros)) {
                        JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
                        TF_ID.setText("");
                        TF_Modelo.setText("");
                        TF_Cor.setText("");
                        TF_Estoque.setText("");
                        TF_Valor.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar carro!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro de formato!");
                }
            }
        });
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarCarros();
            }
        });
        Vendas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormVendaCarro formVenda = new FormVendaCarro(carrosDao, vendaDao);
                formVenda.setVisible(true);
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = table1.getSelectedRow();
                if (linhaSelecionada == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um carro na tabela para excluir.");
                    return;
                }
                int idCarroParaExcluir = (int) table1.getValueAt(linhaSelecionada, 0);
                int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este carro?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
                    if (carrosDao.excluirCarro(idCarroParaExcluir)) {
                        JOptionPane.showMessageDialog(null, "Carro excluído com sucesso!");
                        listarCarros();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro: Carro não encontrado para exclusão.");
                    }
                }
            }
        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = table1.getSelectedRow();

                if (linhaSelecionada == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um carro na tabela para alterar.");
                    return;
                }

                int id = (int) table1.getValueAt(linhaSelecionada, 0);
                String modelo = (String) table1.getValueAt(linhaSelecionada, 1);
                String cor = (String) table1.getValueAt(linhaSelecionada, 2);
                int estoque = (int) table1.getValueAt(linhaSelecionada, 3);
                double valor = (double) table1.getValueAt(linhaSelecionada, 4);

                TF_ID.setText(String.valueOf(id));
                TF_Modelo.setText(modelo);
                TF_Cor.setText(cor);
                TF_Estoque.setText(String.valueOf(estoque));
                TF_Valor.setText(String.valueOf(valor));

                TF_ID.setEnabled(false);
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(TF_ID.getText());
                    String modelo = TF_Modelo.getText();
                    String cor = TF_Cor.getText();
                    int estoque = Integer.parseInt(TF_Estoque.getText());
                    double valor = Double.parseDouble(TF_Valor.getText());

                    Carros carroAtualizado = new Carros(id, modelo, cor, estoque, valor);

                    if (carrosDao.atualizarCarro(carroAtualizado)) {
                        JOptionPane.showMessageDialog(null, "Carro atualizado com sucesso!");
                        listarCarros();

                        TF_ID.setText("");
                        TF_Modelo.setText("");
                        TF_Cor.setText("");
                        TF_Estoque.setText("");
                        TF_Valor.setText("");
                        TF_ID.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro: Carro não encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro inesperado.");
                }
            }
        });
    }
    public void listarCarros() {
        model.setRowCount(0);
        for (Carros carro : this.carrosDao.getListaCarros()){
            Object[] linha = {
                    carro.getIdCarro(),
                    carro.getModeloCarro(),
                    carro.getCorCarro(),
                    carro.getEstoque(),
                    carro.getValor()
            };
            model.addRow(linha);
        }
    }
}