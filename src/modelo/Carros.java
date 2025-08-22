package modelo;

public class Carros {
    public int idCarro;
    public String modeloCarro;
    public String corCarro;
    public int estoque;
    public double valor;
    public String dataVenda;

    public Carros() {
    }

    public Carros(int idCarro, String modeloCarro, String corCarro, int estoque, double valor, String dataVenda) {
        this.idCarro = idCarro;
        this.modeloCarro = modeloCarro;
        this.corCarro = corCarro;
        this.estoque = estoque;
        this.valor = valor;
        this.dataVenda = dataVenda;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getCorCarro() {
        return corCarro;
    }

    public void setCorCarro(String corCarro) {
        this.corCarro = corCarro;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
}