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
    private int notaLivro;
    private String comentarios;
    
    
    public listaUsuarioM(int notaLivro, String comentarios, String nomeLivro, int anoPublicacao, String autor, String genero, String idioma) {
        super(nomeLivro, anoPublicacao, autor, genero, idioma);
        this.notaLivro = notaLivro;
        this.comentarios = comentarios;
    }

    public int getNotaLivro() {
        return notaLivro;
    }

    public void setNotaLivro(int notaLivro) {
        this.notaLivro = notaLivro;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    

}
