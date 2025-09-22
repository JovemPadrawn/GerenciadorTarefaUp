package dao;

import modelo.Venda;

import java.util.ArrayList;

public class VendaDao {
    private ArrayList<Venda> listaVendas = new ArrayList<>();
    private int proximoId = 1;

    public boolean registrarVenda(Venda venda) {
        venda.setIdVenda(proximoId);
        proximoId++;
        return listaVendas.add(venda);
    }
    public ArrayList<Venda> getListaVendas() {
        return listaVendas;
    }
    public Venda buscarVendaPorId(int idVenda) {
        for (Venda venda : listaVendas) {
            if (venda.getIdVenda() == idVenda) {
                return venda;
            }
        }
        return null;
    }
    public boolean excluirVenda(int idVenda) {
        return listaVendas.removeIf(venda -> venda.getIdVenda() == idVenda);
    }
}
