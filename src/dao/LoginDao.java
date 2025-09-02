package dao;

import modelo.Login;
import modelo.Tarefa;

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

    public Login buscarPorId(int id){
        for (Login l : lista) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public void atualizar(Login login){

    }

    public void atualizarStatus(Login login, Boolean ativo){

    }
}
