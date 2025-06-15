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
 * Essa classe manipula o banco de dados quando o usuário logado for o Adm.
 * 
 * Possui métodos para inserção, listagem e deleção de filmes no banco de dados. Além
 * de poder remover um usuário.
 * 
 * @author Raphael
 */
public class listaAdmC {
    
    public ResultSet dadosConsulta;
    bancoDeDados bd=new bancoDeDados();
    
    /**
     * Insere um novo filme no banco de dados, utilizando dados fornecidos pelo ADM.
     * 
     * O método estabelece uma conexão com o banco, monta uma String SQL para inserção
     * baseada nos atributos do objeto fornecido e executa. Se for bem sucedido, exibe
     * uma mensagem de confirmação ao usuário. Se ocorrer um erro, a exceção é impressa.
     * @param obj Objeto do tipo listaAdmM contendo os dados do filmes a ser inserido.
     */
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
    /**
     * Lista todos os filmes presentes na tabela filmes do banco de dados.
     * 
     * O método estabelece uma conexão com o BD, executa uma instrução SQL
     * e retorna um ResultSet contendo os resultados.
     * 
     * @return um ResultSet com todos os filmes cadastrados; em caso de erro
     * retorna NULL.
     */
    public ResultSet ListarFilmesAdm(){
    ResultSet rs = null;
        try{
            bd.conexao();
            String sql = "select * from filmes";
            bd.getStatement().execute(sql);         
            rs = bd.getStatement().executeQuery(sql);   
        }catch(Exception er){
            er.printStackTrace();
        }  
        return rs;
    }
    /**
     * Exibe todos os registros da tabela filmesAvaliados no banco de dados.
     * 
     * O método abre uma conexão com o banco, executa um comando SQL
     * para selecionar todos os registros e retorna um ResultSet com os dados
     * obtidos.
     * 
     * @return um ResultSet contendo os filmes avaliados; retorna null em caso
     * de erro.
     */
    public ResultSet ListarFilmesAvaliados(){
        ResultSet rsa = null;
            try{
                bd.conexao();
                String sql = "select * from filmesAvaliados";
                bd.getStatement().execute(sql);         
                rsa = bd.getStatement().executeQuery(sql);   
            }catch(Exception er){
                er.printStackTrace();
            }  
            return rsa;
    }
    /**
     * Remove um filme da tabela filmes com base no id.
     * 
     * O método estabelece uma conexão com o BD, executa um comando
     * DELETE para remover o registro com o idFilme fornecido e exibe 
     * uma mensagem de confirmação. Em caso de erro, imprime a exceção.
     * 
     * @param idFilme o identificador do filme a ser removido do banco de
     * dados.
     */
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
    /**
     * Remove um usuário da tabela usuario com base no id do usuário.
     * 
     * O metodo estabelece a conexão, utiliza um DELETE para remover o registro
     * com o idUsuario fornecido, e exibe uma mensagem de confirmação de usuário.
     * Se tiver um erro, imprime a exceção.
     * 
     * @param idUsuario o identificador do usuário a ser removido. 
     */
    public void removerUsuario(int idUsuario){
        try{
            bd.conexao();
            String sql="delete from usuario where idUsuario='"+idUsuario+"'";
            bd.getStatement().execute(sql);
            
            javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
            aviso.showMessageDialog(null, "Usuario removido");
            
            bd.desconecta();
        }catch(Exception er){
            er.printStackTrace();
        }
    }
    /**
     * Atualiza as informações de um filme na tabela filmes, com base no ID.
     * 
     * O método utiliza um PreparedStatement para atualizar de forma segura
     * os campos do filme com os dados fornecidos no objeto listaAdmM.
     * 
     * @param idFilme O identificador do filme a ser atualizado.
     * @param filmeParaAtualizar objeto contendo os novos dados do filme.
     * @return True se a atualização for bem-sucedida; False caso contrário ou 
     * em caso de erro.
     */
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
