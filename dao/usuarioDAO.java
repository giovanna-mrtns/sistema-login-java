package dao;

import java.sql.*;
import model.Usuario;
import util.Conexao;

public class UsuarioDAO {

    public Usuario autenticar(String login, String senha) {

        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";

        try (
            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));

                return u; 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; 
    }


    public void atualizarUltimoAcesso(int id) {

        String sql = "UPDATE usuario SET ultimo_acesso = NOW() WHERE id = ?";

        try (
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);
            stmt.executeUpdate(); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrar(Usuario usuario) {

        String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";

        try (
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());

            stmt.executeUpdate(); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean alterarSenha(int id, String senhaAntiga, String senhaNova) {

        String sql = "UPDATE usuario SET senha = ? WHERE id = ? AND senha = ?";

        try (
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, senhaNova);
            stmt.setInt(2, id);
            stmt.setString(3, senhaAntiga);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}