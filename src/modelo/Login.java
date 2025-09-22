package modelo;

import java.util.Locale;

public class Login {
    public int id;
    public String nome;
    public String email;
    public String senha;
    public boolean ativo;
    public String dataCadastro;
    public String dataAtualizacao;

    public Login() {
    }

    public Login(String nome, String email, String senha, String dataCadastro, String dataAtualizacao) {
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.setAtivo(true);
        this.setDataCadastro(dataCadastro);
        this.setDataAtualizacao(dataAtualizacao);
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", ativo=" + ativo +
                ", dataCadastro='" + dataCadastro + '\'' +
                ", dataAtualizacao='" + dataAtualizacao + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0) {
            this.id = id;
        }else {
            throw new NumberFormatException("Id deve ser maior que zero!!!");
        }
    }
    public void setNome(String nome) {
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }else {
            this.nome = nome.trim();
        }
    }
    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException(
                    "O e-mail não pode estar ser nulo.");
        }else if (email.isBlank()) {
            throw new IllegalArgumentException(
                    "O e-mail não pode estar vazio");
        }else if (!email.contains("@")) {
            throw new IllegalArgumentException(
                    "O Formato do e-mail está incorreto,");
        }else{
            this.email = email.trim().toLowerCase();
        }
    }

    public void setSenha(String senha) {
        if(senha == null || senha.isBlank() || senha.length() < 4){
            throw new IllegalArgumentException(
                    "A senha não pode ser vazia e deve ter no minimo 4 caracteres");
        }else{
            this.senha = senha.trim();
        }

    }

    public void setAtivo(boolean ativo) {
            this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
