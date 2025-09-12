package dao;

import modelo.Carros;

import java.util.ArrayList;

public class CarrosDao {
    public ArrayList<Carros> listaCarros;

    public CarrosDao(){
        listaCarros = new ArrayList<>();
    }

    public ArrayList<Carros> getListaCarros(){
        return listaCarros;
    }

    public boolean inserirCarro(Carros carros){
        return listaCarros.add(carros);
    }

    public void darBaixaEstoque(int idCarro) {
        for (Carros carro : listaCarros) {
            if (carro.getIdCarro() == idCarro) {
                int estoqueAtual = carro.getEstoque();
                if (estoqueAtual > 0) {
                    carro.setEstoque(estoqueAtual - 1);
                }
                return;
            }
        }
    }
}
