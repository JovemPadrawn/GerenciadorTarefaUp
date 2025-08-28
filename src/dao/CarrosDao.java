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
}
