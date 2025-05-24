/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author jarba
 */
public class bancoDeDados {
      // Objeto de COnexão com BD
    public Connection conn;
    // Objeto de Consulta SQL
    public Statement stmt;
    // Objeto com dados SQL
    private ResultSet res;
    
    public void conexao(){
       try
       {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(
               "jdbc:postgresql://localhost:5433/paradigmas","postgres", "ucdb");
        System.out.println("Conectado ao PostGreSQL.");        
        }catch(Exception e){
            System.out.println("Falha ao tentar a conexão");
            e.printStackTrace();
        }
       
       try{
           stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);      
       }catch(Exception e){
           System.out.println("Falha no Cursor de Execução");
           e.printStackTrace();
       }
    }
    
     public Connection getConnection(){
        return conn;
    }
    
    public Statement getStatement(){
        return stmt;
    }
    
    public void desconecta(){
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException erro){
                erro.printStackTrace();
            }
            
        }
    }
}
    

