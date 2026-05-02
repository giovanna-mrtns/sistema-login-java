package model;

import java.time.LocalDateTime;
public class usuario {


public class Usuario {

    private int id;
    private String nome;
    private String login;
    private String senha;
    private LocalDateTime ultimoAcesso;

    public Usuario() {}


    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public LocalDateTime getUltimoAcesso() { return ultimoAcesso; }
    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }
}
}
