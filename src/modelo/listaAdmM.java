/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * A classe armazena os dados de um filme que podem ser manipulados por um administrados.
 * @author Jarbas
 */
public class listaAdmM {
    private String nomeFilme;
    private int anoPublicacao;
    private String autor;
    private String genero;
    private String idioma;
    private int duracaoMinutos;
    /**
     * Construtor para inicializar os dados do filme.
     * @param nomeFilme o título do filme.
     * @param anoPublicacao o ano em que o filme foi publicado.
     * @param autor o autor ou diretor do filme.
     * @param genero o gênero do filme.
     * @param idioma o idioma original do filme
     * @param duracaoMinutos a duração total do filme em minutos.
     */
    public listaAdmM(String nomeFilme, int anoPublicacao, String autor, String genero, String idioma, int duracaoMinutos) {
        this.nomeFilme = nomeFilme;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
        this.genero = genero;
        this.idioma = idioma;
        this.duracaoMinutos = duracaoMinutos;
    }
    /**
     * Obtém o nome do filme.
     * @return o nome do filme.
     */
    public String getNomeFilme() {
        return nomeFilme;
    }
    /**
     * Define o nome do filme.
     * @param nomeFilme o nome do filme.
     */
    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }
    /**
     * Retorna o ano de publicação do filme.
     * @return o ano de publicação;
     */
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    /**
     * Define o ano em que o filme fui publicado/lançado.
     * @param anoPublicacao o ano de lançamento/publicação.
     */
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    /**
     * Retorna o autor do filme
     * @return o nome do autor.
     */
    public String getAutor() {
        return autor;
    }
    /**
     * Define o autor/diretor do filme.
     * @param autor o autor do filme a ser atribuido.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /**
     * Retorna o gênero do filme.
     * @return o gênero do filme.
     */
    public String getGenero() {
        return genero;
    }
    /**
     * Define o gênero do filme.
     * @param genero O gênero do filme a ser definido.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    /**
     * Retorna o idioma original do filme.
     * @return o idioma original do filme.
     */
    public String getIdioma() {
        return idioma;
    }
    /**
     * Define o idioma do filme
     * @param idioma o idioma a ser atribuido.
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    /**
     * Obtém o tempo de duração do filme, em minutos.
     * @return a duração do filme em minutos.
     */
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
    /**
     * Define a duração do filme em minutos.
     * @param duracaoMinutos o novo tempo de duração do filme.
     */
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }  
}
