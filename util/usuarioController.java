package controller;

import model.Usuario;
import service.UsuarioService;

public class UsuarioController {

    private UsuarioService service = new UsuarioService();

    public Usuario login(String login, String senha) {
        return service.realizarLogin(login, senha);
    }
    public void cadastrar(String nome, String login, String senha) {
        service.cadastrarUsuario(nome, login, senha);
    }

    public boolean alterarSenha(int id, String antiga, String nova) {
        return service.alterarSenha(id, antiga, nova);
    }
}