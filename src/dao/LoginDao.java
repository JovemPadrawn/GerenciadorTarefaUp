package dao;

import modelo.Login;

import java.util.ArrayList;

public class LoginDao {
    public ArrayList<Login> lista;

    public LoginDao(){
        lista = new ArrayList<>();
    }

    public ArrayList<Login> getLista() {
        return lista;
    }

    public boolean inserirLogin(Login login){
        return lista.add(login);
    }

    public void listar(){

    }

    public void buscarPorId(int id){

    }

    public void atualizar(Login login){

    }

    public void atualizarStatus(Login login, Boolean ativo){

    }
}
