/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa um modelo de um usuário com nome e senha.
 * 
 * Esta classe é usada para armazenar e manipular os dados básicos de 
 * um usuário. 
 * @author Jarbas
 */

public class usuarioM {
    private String nomeUsuario;
    private String senha;
    
    /**
     * Construtor para inicializar um novo objeto usuarioM com nome e senha.
     * 
     * @param nomeUsuario o nome de login do usuário.
     * @param senha a senha do usuário.
     */
    public usuarioM(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }
    /**
     * Obtém o nome do usuário
     * @return o nome de login de usuário.
     */
        
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    /**
     * Define o nome do usuário
     * 
     * @param nomeUsuario o novo nome de login do usuário.
     */

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    /**
     * Obtém a senha do usuário 
     * @return a senha atual do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define ou altera a senha do usuário
     * 
     * @param senha a nova senha a ser definida. 
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
  
}
