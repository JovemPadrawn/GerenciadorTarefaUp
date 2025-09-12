package dao;

import modelo.Venda;

import java.util.ArrayList;

public class VendaDao {
    private ArrayList<Venda> listaVendas = new ArrayList<>();

    public boolean registrarVenda(Venda venda) {
        return listaVendas.add(venda);
    }

    public ArrayList<Venda> getListaVendas() {
        return listaVendas;
    }
}
