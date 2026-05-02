package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() throws Exception {
String url = "jdbc:mysql://localhost:3306/login_cleo";

        String user = "root";

        String password = ""; // altere a senha!

        return DriverManager.getConnection(url, user, password); 
    }