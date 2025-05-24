/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jarba
 */
public class listaAvaliacoesM {
    private String nomeLivro;
    private int anoPublicacao;
    private String autor;
    private String genero;
    private String idioma;
    
    private int notaLivro;
    private String comentarios;

    public listaAvaliacoesM(String nomeLivro, int anoPublicacao, String autor, String genero, String idioma, int notaLivro, String comentarios) {
        this.nomeLivro = nomeLivro;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
        this.genero = genero;
        this.idioma = idioma;
        this.notaLivro = notaLivro;
        this.comentarios = comentarios;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
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
