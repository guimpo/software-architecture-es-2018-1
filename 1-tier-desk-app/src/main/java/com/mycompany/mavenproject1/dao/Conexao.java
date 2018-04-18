package com.mycompany.mavenproject1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author nGuilhen
 */
public class Conexao{
    private static Connection con;
    
    private static String url = "jdbc:mysql://localhost:3306/saapp";
    private static String username = "root";
    private static String password = "root";
    
    private Conexao(){}
    
    public static synchronized Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("Erro ao conectar com o banco.");
            }
        }
        
        return con;
    }
    
}