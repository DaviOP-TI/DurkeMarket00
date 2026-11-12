/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author sesi2dia
 */
public class MySQLConnection {

    // Define String de conexão com o Banco
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://172.16.0.30/davi_estoque";
    private static final String USER = "davi";
    private static final String PASS = "2diSenai";

    /**
     * Cria conexão com o banco de dados MySQL.
     * @return Connection
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na Conexao com o BD. Verifique!", ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Falha na carga do Driver", ex);
        }
    }

    /**
     * Fecha a conexão com o DB.
     * @param conn Connection a ser fechada.
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fecha a conexão e o PreparedStatement.
     * @param conn Connection a ser fechada.
     * @param stmt PreparedStatement a ser fechado.
     */
    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        closeConnection(conn);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fecha a conexão, o PreparedStatement e o ResultSet.
     * @param conn Connection a ser fechada.
     * @param stmt PreparedStatement a ser fechado.
     * @param rs ResultSet a ser fechado.
     */
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeConnection(conn, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

