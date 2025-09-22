package dao;

import modelo.Tarefa;
import java.util.ArrayList;

public class TarefaDao {
    public ArrayList<Tarefa> lista;

    public TarefaDao() {
        lista = new ArrayList<>();
    }

    public ArrayList<Tarefa> getLista() {
        return lista;
    }

    public boolean inserirTarefa(Tarefa tarefa) {
        return lista.add(tarefa);
    }

    public Tarefa buscarPorId(int id) {
        for (Tarefa t : lista) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void atualizar(Tarefa tarefaAtualizada) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == tarefaAtualizada.getId()) {
                lista.set(i, tarefaAtualizada);
                return;
            }
        }
    }

    public void atualizarStatus(Tarefa tarefa, boolean concluida) {
        for (Tarefa t : lista) {
            if (t.getId() == tarefa.getId()) {
                t.setConcluida(concluida);
                return;
            }
        }
    }
}
