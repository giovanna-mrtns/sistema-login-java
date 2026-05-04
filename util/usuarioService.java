package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public Usuario realizarLogin(String login, String senha) {

        if (login.isEmpty() || senha.isEmpty()) {
            return null;
        }

    
        Usuario usuario = dao.autenticar(login, senha);

    
        if (usuario != null) {
            dao.atualizarUltimoAcesso(usuario.getId());
        }

        return usuario;
    }

    
    public void cadastrarUsuario(String nome, String login, String senha) {

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