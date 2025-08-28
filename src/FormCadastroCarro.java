import dao.CarrosDao;
import modelo.Carros;
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

    CarrosDao carrosDao;

    String[] colunas = {"IDCARRO","MODELO","COR","ESTOQUE","VALOR"};

    DefaultTableModel model = new DefaultTableModel(colunas, 0);

    public FormCadastroCarro(){
        setContentPane(Principal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cadastro de Carro");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        table1.setModel(model);

        carrosDao = new CarrosDao();

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(TF_ID.getText());
                String modelo = TF_Modelo.getText();
                String cor = TF_Cor.getText();
                int estoque = Integer.parseInt(TF_Estoque.getText());
                double valor= Double.parseDouble(TF_Valor.getText());

                Carros carros = new Carros();

                carros.setIdCarro(id);
                carros.setModeloCarro(modelo);
                carros.setCorCarro(cor);
                carros.setEstoque(estoque);
                carros.setValor(valor);

                if(carrosDao.inserirCarro(carros)){
                    JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar carro!");
                }

            }
        });
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                for (Carros l : carrosDao.getListaCarros()){
                    Object[] linha = {
                            l.getIdCarro(),
                            l.getModeloCarro(),
                            l.getCorCarro(),
                            l.getEstoque(),
                            l.getValor()
                    };
                    model.addRow(linha);
                }
            }
        });
        /*Vendas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormVendaCarro formVendaCarro = new FormVendaCarro();
                formVendaCarro.setVisible(true);
            }
        });*/
    }
}