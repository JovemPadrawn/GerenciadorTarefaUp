package modelo;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private boolean concluida;
    private String nomeResponsavel;
    private String dataInicio;
    private String dataTermino;
    private String local;

    // Construtores
    public Tarefa() {}

    public Tarefa(String titulo, String descricao, boolean concluida, String nomeResponsavel, String dataInicio, String dataTermino, String local) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = concluida;
        this.nomeResponsavel = nomeResponsavel;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.local = local;
    }

    public int getId() { return id; }

    public void setId(int id) {
        if(id >= 0)
           this.id = id;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean isConcluida() { return concluida; }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }

    public String getNomeResponsavel() { return nomeResponsavel; }
    public void setNomeResponsavel(String nomeResponsavel) { this.nomeResponsavel = nomeResponsavel; }

    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }

    public String getDataTermino() { return dataTermino; }
    public void setDataTermino(String dataTermino) { this.dataTermino = dataTermino; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    @Override
    public String toString() {
        return "Tarefa [id=" + id +
                ", titulo=" + titulo +
                ", descricao=" + descricao +
                ", concluida=" + concluida +
                ", responsavel=" + nomeResponsavel +
                ", inicio=" + dataInicio +
                ", termino=" + dataTermino +
                ", local=" + local + "]";
    }
}
