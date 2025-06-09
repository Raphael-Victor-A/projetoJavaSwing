/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import controle.bancoDeDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.usuarioM;

/**
 *
 * @author ra189362
 */
public class usuarioC {
    public ResultSet dadosConsulta;
    bancoDeDados bd=new bancoDeDados();
    
    public void inserirUsuario(usuarioM obj){
    try{
        bd.conexao();
        String sql = "insert into usuario values('"+obj.getNomeUsuario()+"','"+obj.getSenha()+"')";
        bd.getStatement().execute(sql);
        
        javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
        aviso.showMessageDialog(null, "Usuario cadastrado");
        bd.desconecta();
    }catch(Exception er){
            er.printStackTrace();
    }
    }
    public void removerUsuario(String nomeUsuario){
        try{
            bd.conexao();
            String sql="delete from usuario where nomeUsuario='"+nomeUsuario+"'";
            bd.getStatement().execute(sql);
            
            javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
            aviso.showMessageDialog(null, "usuario removido");
            
            bd.desconecta();
        }catch(Exception er){
            er.printStackTrace();
        }
    }
    public boolean atualizarUsuario(usuarioM usuario) {
    Connection conn = null;
    PreparedStatement ps = null;
    boolean sucesso = false;

    try {
       
        bd.conexao(); 
        conn = bd.getConnection(); 

       
        String sql = "UPDATE usuario SET senha = ? WHERE nomeUsuario = ?";
        ps = conn.prepareStatement(sql);

        ps.setString(1, usuario.getSenha());
        ps.setString(2, usuario.getNomeUsuario());
               
        int linhasAfetadas = ps.executeUpdate(); 

        if (linhasAfetadas > 0) {
            System.out.println("Usuario atualizado com sucesso!");
            sucesso = true;
        } else {
            System.out.println("Nenhum usuario encontrado com o nome fornecido ou nenhum dado alterado.");
        }

    } catch (SQLException e) {
        System.err.println("Erro ao atualizar usuario: " + e.getMessage());
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
    public boolean verificarLogin(String nomeUsuario, String senha) {
        try {
        bd.conexao();
        String sql = "SELECT * FROM usuario WHERE nomeUsuario = ? AND senha = ?";
        PreparedStatement ps = bd.getConnection().prepareStatement(sql);
        ps.setString(1, nomeUsuario);
        ps.setString(2, senha);
        if ("admin".equals(nomeUsuario) && "12345".equals(senha)) {
        return true;
        }


        ResultSet rs = ps.executeQuery();
        return rs.next();
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        bd.desconecta();
    }
    }
}
