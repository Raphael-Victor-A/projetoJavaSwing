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
 * Esta classe é utilizada para manipular os dados de usuário
 * 
 * A classe possui métodos para inserir um novo usuário, remoção de usuário,
 * atualização de senha e verificação de login.
 *
 * @author Jarbas Ribeiro
 * @since Maio de 2025
 */
public class usuarioC {
    public ResultSet dadosConsulta;
    bancoDeDados bd=new bancoDeDados();
    
    /**
     * Insere um novo usuário no banco de dados
     * 
     * O metódo estabelece conexão com o banco, insere os dados do usuário na tabela usuário,
     * exibe uma mensagem de confirmação e fecha a conexão.
     * 
     *
     * @param obj Objeto do tipo usuarioM que contém nome de usuário e senha
     */
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
    /**
     * Remove um usuário do banco de dados com base no nome de usuário fornecido.
     * 
     * Este método estabelece conexão com o banco, executa o comando para remover
     * o usuário da tabela "usuario" e exibe uma mensagem de confirmação.
     * 
     * @param nomeUsuario O nome do usuário que será removido do banco de dados
     */
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
    /**
     * Atualiza a senha de um usuário no banco de dados
     * 
     * O método estabelece conexão com o banco de dados, utiliza um PreparedStatement
     * para atualizar a senha do usuário com base no seu nome de usuário e retorna um valor booleano
     * indicando se a operaçao foi bem-sucedida.
     * 
     * @param usuario Objeto do tipo usuarioM contendo o nome do usuário e a nova senha.
     * @return True se a atualização ocorrer com sucesso; False caso contrário
     */
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
    /**
     * Verifica se as informações para o login são válidas.
     * 
     * O método realiza a autenticação do usuário utilizando os parâmetros informados para consulta
     * no banco de dados. Se o usuário "admin" e a senha for "1234" o login é automaticamente aceito,
     * sem precisar verificar no banco de dados.
     * 
     * @param nomeUsuario O nome do usuário utilizado para login.
     * @param senha A senha correspondente ao nome de usuário
     * @return True se as credenciais forem válidas; False caso contrário.
     */
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
