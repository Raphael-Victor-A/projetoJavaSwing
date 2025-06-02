/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import modelo.listaAdmM;

/**
 *
 * @author jarba e rarpha e vinir
 */
public class listaUsuarioM extends listaAdmM{
    private int notaFilme;
    private String comentarios;

    public listaUsuarioM(int notaFilme, String comentarios, String nomeFilme, int anoPublicacao, String autor, String genero, String idioma, int duracaoMinutos) {
        super(nomeFilme, anoPublicacao, autor, genero, idioma, duracaoMinutos);
        this.notaFilme = notaFilme;
        this.comentarios = comentarios;
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
