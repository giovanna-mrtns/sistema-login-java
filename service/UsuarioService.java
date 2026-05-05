package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public Usuario realizarLogin(String login, String senha) {

        if (login == null || login.isBlank() || senha == null || senha.isBlank()) {
            return null;
        }
        login = login.trim();
        senha = senha.trim();

    
        Usuario usuario = dao.autenticar(login, senha);

    
        if (usuario != null) {
            dao.atualizarUltimoAcesso(usuario.getId());
        }

        return usuario;
    }

    
    public void cadastrarUsuario(String nome, String login, String senha) {

        if (nome == null || nome.isBlank() ||
            login == null || login.isBlank() ||
            senha == null || senha.isBlank()) {
            System.out.println("Erro: nome, login e senha são obrigatórios.");
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);

        dao.cadastrar(usuario);
    }


    public boolean alterarSenha(int id, String antiga, String nova) {
        return dao.alterarSenha(id, antiga, nova);
    }
}