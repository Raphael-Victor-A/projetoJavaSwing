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
    public void ListarFilmesAdm(listaAdmM obj){
        try{
            bd.conexao();
            String sql = "select * from filmes";
            bd.getStatement().execute(sql);
           
            javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
            aviso.showMessageDialog(null, "Busca realizada");
            bd.desconecta();
        }catch(Exception er){
            er.printStackTrace();
        }  
    }
    
    
    public void removerFilmeAdm(int idFilme){
        try{
            bd.conexao();
            String sql="delete from filmes where idFilme='"+idFilme+"'";
            bd.getStatement().execute(sql);
            
            javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
            aviso.showMessageDialog(null, "Filme removido");
            
            bd.desconecta();
        }catch(Exception er){
            er.printStackTrace();
        }
    }
    public boolean atualizarListaFilmes(int idFilme, listaAdmM filmeParaAtualizar) {
    Connection conn = null;
    PreparedStatement ps = null;
    boolean sucesso = false;

    try {
        // Assume que 'bd' é uma instância da sua classe de conexão ao banco de dados
        bd.conexao();
        conn = bd.getConnection();

        // Query SQL com parâmetros para evitar injeção de SQL
        String sql = "UPDATE filmes SET anoPublicacao=?, autor=?, genero=?, idioma=?, duracaoMinutos=?, nomeFilme=? WHERE idFilme=?";
        ps = conn.prepareStatement(sql);

        // Define os valores dos parâmetros do PreparedStatement
        // Os valores são pegos do objeto 'filmeParaAtualizar'
        ps.setInt(1, filmeParaAtualizar.getAnoPublicacao());
        ps.setString(2, filmeParaAtualizar.getAutor());
        ps.setString(3, filmeParaAtualizar.getGenero());
        ps.setString(4, filmeParaAtualizar.getIdioma());
        ps.setInt(5, filmeParaAtualizar.getDuracaoMinutos());
        ps.setString(6, filmeParaAtualizar.getNomeFilme());
        ps.setInt(7, idFilme); // O ID do filme para a cláusula WHERE

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Filme atualizado com sucesso!");
            sucesso = true;
        } else {
            System.out.println("Nenhum filme encontrado com o ID fornecido ou nenhum dado alterado.");
        }

    } catch (SQLException e) {
        System.err.println("Erro ao atualizar filme: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Fechar recursos em um bloco finally é crucial para evitar vazamentos
        try {
            if (ps != null) ps.close();
            if (conn != null) bd.desconecta(); // Assumindo que desconecta fecha a conexão
        } catch (SQLException e) {
            System.err.println("Erro ao fechar recursos após atualização: " + e.getMessage());
        }
    }
    return sucesso;
}

}
