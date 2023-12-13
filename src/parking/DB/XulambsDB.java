package parking.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XulambsDB {

    private static String banco = "xulambs";
    private static String usuario = "root";
    private static String senha = "laranbanas02.";
    private static String url = "jdbc:mariadb://localhost:3306/xulambs";

    private static XulambsDB instancia = null;
    private static Connection conexao = null;

    private XulambsDB() {

    }

    public static XulambsDB getInstancia() {
        if (instancia == null) {
            instancia = new XulambsDB();
            conectar();
        }
        return instancia;
    }

    private static void conectar() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão OK!");
        } catch (SQLException ex) {
            Logger.getLogger(XulambsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexao() {
        return conexao;
    }

    public void desconectar() {
        try {
            conexao.close();
            System.out.println("Conexão Encerrada!");
        } catch (SQLException ex) {
            Logger.getLogger(XulambsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
