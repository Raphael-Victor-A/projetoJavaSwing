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
 * Essa classe possui métodos para interação com o banco de dados.
 * 
 * A classe possui métodos para fazer a conexão e a desconexão com o banco de dados.
 * @author Alexsandro
 */
public class bancoDeDados {
      // Objeto de COnexão com BD
    public Connection conn;
    // Objeto de Consulta SQL
    public Statement stmt;
    // Objeto com dados SQL
    private ResultSet res;
    /**
     * Esse método realiza a conexão com o banco de dados e cria um Statement 
     * para a excução de comandos SQL.
     * 
     * O metodo carrega o driver JDBC do PostgreSQL, realiza a conexão com o BD 
     * utilizando as credenciais fornecidas, e cria o Statement configurado para permitir
     * a leitura dos resultados.
     * 
     * Em caso de erro, mensagens são exibidas no console e exceções são impressas.
     */
    public void conexao(){
       try
       {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(
               "jdbc:postgresql://localhost:5432/imdb","postgres", "4661");
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
    
    /**
     * Retorna o objeto Connection associado a conexão com o BD.
     * @return um objeto conn se a conexão for estabelecida com sucesso; caso contrário, pode 
     * retornar null.
     */
     public Connection getConnection(){
        return conn;
    }
    /**
     * Retorna o objeto Statement para execução de comandos SQL.
     * @return um objeto Statement se for criado com sucesso; caso contrário Null.
     */
    public Statement getStatement(){
        return stmt;
    }
    /**
     * Encerra a conexão com o banco de dados.
     * 
     * O método verifica se o objeto conn é nulo antes de fechá-lo. Caso ocorra 
     * uma exceção ao tentar encerrar a conexão, a pilha de erro será impressa no 
     * console.
     */
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
    

