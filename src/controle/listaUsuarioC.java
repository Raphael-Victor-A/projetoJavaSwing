/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.listaUsuarioM;
import modelo.usuarioM;

/**
 *
 * @author ra189362
 */
public class listaUsuarioC {
    
    public ResultSet dadosConsulta;
    bancoDeDados bd=new bancoDeDados();
    
    public void inserirFilmeUsuario(listaUsuarioM obj, usuarioM user) {
    Connection conn = null;
    PreparedStatement psFilme = null;
    PreparedStatement psInsert = null;
    ResultSet rs = null;

    try {
        bd.conexao();
        conn = bd.getConnection();

        // 1. Verifica se o filme já existe na tabela filmes
        String sqlCheck = "SELECT idFilme FROM filmes WHERE nomeFilme = ?";
        psFilme = conn.prepareStatement(sqlCheck);
        psFilme.setString(1, obj.getNomeFilme());
        rs = psFilme.executeQuery();

        if (rs.next()) {
            int idFilme = rs.getInt("idFilme");

            // 2. Insere na tabela filmesAvaliados (relacionando com o filme existente)
            String sqlInsert = "INSERT INTO filmesAvaliados (idFilme, nomeUsuario, nota, comentarios) VALUES (?, ?, ?, ?)";
            psInsert = conn.prepareStatement(sqlInsert);
            psInsert.setInt(1, idFilme);
            psInsert.setString(2, user.getNomeUsuario());  
            psInsert.setInt(3, obj.getNotaFilme());
            psInsert.setString(4, obj.getComentarios());

            psInsert.executeUpdate();

            javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
            aviso.showMessageDialog(null, "Filme avaliado com sucesso!");

        } else {
            javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
            aviso.showMessageDialog(null, "Filme não encontrado no catálogo!");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (psFilme != null) psFilme.close();
            if (psInsert != null) psInsert.close();
            bd.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    public void removerFilmeUsuario(String nomeFilme, String nomeUsuario){
        try{
            bd.conexao();
            String sql="delete from filmesAvaliados where nomeFilme='"+nomeFilme+"' and '"+nomeUsuario+"'";
            bd.getStatement().execute(sql);
            
            javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
            aviso.showMessageDialog(null, "Filme removido");
            
            bd.desconecta();
        }catch(Exception er){
            er.printStackTrace();
        }
    }
    public boolean atualizarUsuario(listaUsuarioM usuario, usuarioM user) {
    Connection conn = null;
    PreparedStatement ps = null;
    boolean sucesso = false;

    try {
       
        bd.conexao(); 
        conn = bd.getConnection(); 

       
        String sql = "UPDATE filmesAvaliados SET notaFilme=?,comentarios=? WHERE nomeFilme = ? and nomeUsuario = ?";
        ps = conn.prepareStatement(sql);

        ps.setInt(1, usuario.getNotaFilme());
        ps.setString(2, usuario.getComentarios());
        ps.setString(3, usuario.getNomeFilme());
        ps.setString(4, user.getNomeUsuario());

       
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
