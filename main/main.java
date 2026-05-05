package main;

import controller.UsuarioController;
import java.util.Scanner;
import model.Usuario;

public class Main {

    public static void main(String[] args) {

        UsuarioController controller = new UsuarioController();
        Scanner scanner = new Scanner(System.in);
        Usuario loggedUser = null;

        while (true) {
            if (loggedUser != null) {

                System.out.println("----------------------------");
                System.out.println("SEJA BEM-VINDO! - CLEO MODAS FEMININAS");
                System.out.println("----------------------------");

                System.out.println("Logado como: " + loggedUser.getNome());
                System.out.println("1. Alterar senha");
                System.out.println("2. Logout");
                System.out.println("3. Fechar aplicação");
            } else {

                System.out.println("------------------------------");
                System.out.println("LOGIN - CLEO MODAS FEMININAS");
                System.out.println("------------------------------");

                System.out.println("1. Login");
                System.out.println("2. Cadastrar usuário");
                System.out.println("3. Alterar senha");
                System.out.println("4. Fechar aplicação");
            }
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (loggedUser != null) {
                switch (opcao) {
                    case 1:
                        System.out.print("Senha antiga: ");
                        String senhaAntiga = scanner.nextLine();
                        System.out.print("Nova senha: ");
                        String novaSenha = scanner.nextLine();
                        boolean alterou = controller.alterarSenha(loggedUser.getId(), senhaAntiga, novaSenha);
                        if (alterou) {
                            System.out.println("Senha alterada com sucesso");
                        } else {
                            System.out.println("Erro ao alterar senha");
                        }
                        break;
                    case 2:
                        System.out.println("Logout realizado.");
                        loggedUser = null;
                        break;
                    case 3:
                        System.out.println("Fechando aplicação...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida");
                }
            } else {
                switch (opcao) {
                    case 1:
                        System.out.print("Login: ");
                        String login = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();
                        Usuario u = controller.login(login, senha);
                        if (u != null) {
                            loggedUser = u;
                            System.out.println("Login OK - Bem vindo " + u.getNome());
                        } else {
                            System.out.println("Erro no login");
                        }
                        break;
                    case 2:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Login: ");
                        String log = scanner.nextLine();
                        System.out.print("Senha: ");
                        String sen = scanner.nextLine();
                        controller.cadastrar(nome, log, sen);
                        System.out.println("Usuário cadastrado com sucesso");
                        break;
                    case 3:
                        System.out.print("ID do usuário: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Senha antiga: ");
                        String senhaAntiga = scanner.nextLine();
                        System.out.print("Nova senha: ");
                        String novaSenha = scanner.nextLine();
                        boolean alterou = controller.alterarSenha(id, senhaAntiga, novaSenha);
                        if (alterou) {
                            System.out.println("Senha alterada com sucesso");
                        } else {
                            System.out.println("Erro ao alterar senha");
                        }
                        break;
                    case 4:
                        System.out.println("Fechando aplicação...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida");
                }
            }
            System.out.println();
        }
    }
}
