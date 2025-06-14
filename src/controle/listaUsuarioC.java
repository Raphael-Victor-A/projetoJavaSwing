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
import modelo.sessaoUsuarioM;

/**
 * Esse método contém as funções para manipular a lista de filmes de um usuário logado.
 * 
 * 
 * 
 * @author Raphael
 */
public class listaUsuarioC {
    
    public ResultSet dadosConsulta;
    bancoDeDados bd=new bancoDeDados();
    
    /**
     * Insere uma nova avaliação de filmes na lista do usuário que realizou o login
     * 
     * Verifica se o usuário está logado na sessão atual. Depois, verifica se o filme
     * informado existe na tabela "filmes". Caso exista, insere os dados da avaliação
     * na tabela filmesAvaliados, associando o usuário ao filme. Além disso, exibe men
     * sagens de aviso em caso de sucesso, erro ou quando não encontrar o filme no catá
     * logo.
     * 
     * @param obj Objeto do tipo listaUsuarioM contendo os dados da avalição: nome do filme,
     * nota e comentários.
     */
    public void inserirFilmeUsuario(listaUsuarioM obj) {
    usuarioM user = sessaoUsuarioM.getInstance().getUsuarioLogado();
    if (user == null) {
        javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
        aviso.showMessageDialog(null, "Nenhum usuário logado!");
        return;
    }
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
    /**
     * Remove um filme da lista do usuário logado. 
     * 
     * Este método remove um registro com base no nome do filme e no nome do usuário.
     * Exibe uma mensagem dizendo o resultado da operação.
     * 
     * @param nomeFilme O nome do filme a ser removido
     * @param nomeUsuario O nome do usuário que avaliou o filme
     */
    public void removerFilmeUsuario(String nomeFilme, String nomeUsuario){
        try{
            bd.conexao();
            String sql="delete from filmesAvaliados where nomeFilme='"+nomeFilme+"' and nomeUsuario='"+nomeUsuario+"'";
            bd.getStatement().execute(sql);
            
            javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
            aviso.showMessageDialog(null, "Filme removido");
            
            bd.desconecta();
        }catch(Exception er){
            er.printStackTrace();
        }
    }
    /**
     * Atualiza a nota e os comentários de um filme avaliado por um usuário.
     * 
     * Esse método acessa a tabela "filmesAvaliados" e atualiza a avaliação de um filme
     * com base no nome do filme e no nome do usuário.
     * Nota e comentários são substituidos por valores informados.
     * 
     * @param usuario Objeto contendo o nome do filme, a nova nota e os novos comentários.
     * @param user Representa o usuário logado que avaliou o filme.
     * @return True se a atualização foi bem-sucedida, caso altere algum registro; False caso contrário, ou seja, não 
     * encontrou um registro ou dos dados estão inalterados.
     */
    public boolean atualizarListaUsuario(listaUsuarioM usuario, usuarioM user) {
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
    public ResultSet ListarUsuarios(){
         ResultSet rsu = null;
            try{
                bd.conexao();
                String sql = "select * from usuario";
                bd.getStatement().execute(sql);         
                rsu = bd.getStatement().executeQuery(sql);   
        }catch(Exception er){
            er.printStackTrace();
        }  
        return rsu;
    }
}
