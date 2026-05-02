package main;

import controller.UsuarioController;
import model.Usuario;

public class Main {

    public static void main(String[] args) {

        UsuarioController controller = new UsuarioController();

        Usuario u = controller.login("admin", "1234");

        if (u != null) {
            System.out.println("Login OK - Bem vindo " + u.getNome());
        } else {
            System.out.println("Erro no login");
        }

    
        controller.cadastrar("João", "joao", "123");

    
        boolean alterou = controller.alterarSenha(1, "1234", "nova123");

        if (alterou) {
            System.out.println("Senha alterada com sucesso");
        } else {
            System.out.println("Erro ao alterar senha");
        }
    }
}
