/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import modelo.listaAdmM;

/**
 * Representa o modelo de filme avaliado por um usário.
 * 
 * A classe herda atributos de listaAdmM, e adiciona informações especificas da avaliação
 * feitas por um usuário.
 * @author Jarbas, Raphael e Vinicius.
 */
public class listaUsuarioM {
    private int idFilme;
    private String nomeUsuario;
    private int notaFilme;
    private String comentarios;

    public listaUsuarioM(int idFilme, String nomeUsuario, int notaFilme, String comentarios) {
        this.idFilme = idFilme;
        this.nomeUsuario = nomeUsuario;
        this.notaFilme = notaFilme;
        this.comentarios = comentarios;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getNotaFilme() {
        return notaFilme;
    }

    public void setNotaFilme(int notaFilme) {
        this.notaFilme = notaFilme;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
    
    
       
}
