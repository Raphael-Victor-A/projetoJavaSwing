/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.listaAdmM;

/**
 *
 * @author ra189362
 */
public class listaAdmC {
    
    /*private String nomeFilme;
    private int anoPublicacao;
    private String autor;
    private String genero;
    private String idioma;
    private int duracaoMinutos;*/
    
    public ResultSet dadosConsulta;
    bancoDeDados bd=new bancoDeDados();
    
    public void inserirFilmeAdm(listaAdmM obj){
    try{
        bd.conexao();
            String sql = "insert into filmes (nomeFilme,anoPublicacao,autor,genero,idioma,duracaoMinutos)values('"+obj.getNomeFilme()+"',"+obj.getAnoPublicacao()+",'"+obj.getAutor()+"','"+obj.getGenero()+"','"+obj.getIdioma()+"',"+obj.getDuracaoMinutos()+");";
        bd.getStatement().execute(sql);
        
        javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
        aviso.showMessageDialog(null, "Filme cadastrado");
        bd.desconecta();
    }catch(Exception er){
            er.printStackTrace();
    }
    }
    public void buscaFilmeAdm(listaAdmM obj){
        try{
            bd.conexao();
            String sql = "select * from filmes";
            bd.getStatement().execute(sql);
           
            javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
            aviso.showMessageDialog(null, "busca realizada");
            bd.desconecta();
        }catch(Exception er){
            er.printStackTrace();
    }
        
    }
    
    
    public void removerFilmeAdm(String nomeFilme){
        try{
            bd.conexao();
            String sql="delete from filmes where nomeFilme='"+nomeFilme+"'";
            bd.getStatement().execute(sql);
            
            javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
            aviso.showMessageDialog(null, "Filme removido");
            
            bd.desconecta();
        }catch(Exception er){
            er.printStackTrace();
        }
    }
    public boolean atualizarListaFilmes(listaAdmM usuario) {
    Connection conn = null;
    PreparedStatement ps = null;
    boolean sucesso = false;

    try {
       
        bd.conexao(); 
        conn = bd.getConnection(); 

       
        String sql = "UPDATE filmes SET anoPublicacao=?, autor=?, genero=?, idioma=?,duracaoMinutos=? WHERE nomeFilme = ?";
        ps = conn.prepareStatement(sql);

        
        ps.setInt(1, usuario.getAnoPublicacao());
        ps.setString(2, usuario.getAutor());
        ps.setString(3, usuario.getGenero());
        ps.setString(4, usuario.getIdioma());
        ps.setInt(5, usuario.getDuracaoMinutos());
        ps.setString(6, usuario.getNomeFilme());
       
        int linhasAfetadas = ps.executeUpdate(); 

        if (linhasAfetadas > 0) {
            System.out.println("Filme atualizado com sucesso!");
            sucesso = true;
        } else {
            System.out.println("Nenhum Filme encontrado com o nome fornecido ou nenhum dado alterado.");
        }

    } catch (SQLException e) {
        System.err.println("Erro ao atualizar Filme: " + e.getMessage());
        e.printStackTrace(); 
    } finally {
       
        try {
            if (ps != null) ps.close();
            bd.desconecta(); 
        } catch (SQLException e) {
            System.err.println("Erro ao fechar recursos após atualização: " + e.getMessage());
        }
    }
    return sucesso;
}

}
