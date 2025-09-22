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
            }
        }
    }
    public boolean excluirCarro(int idCarro) {
        return listaCarros.removeIf(carro -> carro.getIdCarro() == idCarro);
    }
    public boolean atualizarCarro(Carros carroAtualizado) {
        for (int i = 0; i < listaCarros.size(); i++) {
            if (listaCarros.get(i).getIdCarro() == carroAtualizado.getIdCarro()) {
                listaCarros.set(i, carroAtualizado);
                return true;
            }
        }
        return false;
    }
    public Carros buscarCarroPorId(int idCarro) {
        for (Carros carro : listaCarros) {
            if (carro.getIdCarro() == idCarro) {
                return carro;
            }
        }
        return null;
    }
    public void aumentarEstoque(int idCarro) {
        for (Carros carro : listaCarros) {
            if (carro.getIdCarro() == idCarro) {
                carro.setEstoque(carro.getEstoque() + 1);
                return;
            }
        }
    }
}
