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
public class listaUsuarioM extends listaAdmM{
    private int notaFilme;
    private String comentarios;

    /**
     * Constutor que inicializa um objeto listaUsuarioM com dados do filme e avaliação.
     * @param notaFilme a nota atribuída ao filme.
     * @param comentarios os comentários do usuário sobre o filme.
     * @param nomeFilme o nome do filme.
     * @param anoPublicacao o ano de publicação do filme.
     * @param autor o autor ou diretor do filme.
     * @param genero o gênero do filme.
     * @param idioma o idioma do filme.
     * @param duracaoMinutos a duração do filme em minutos.
     */
    public listaUsuarioM(int notaFilme, String comentarios, String nomeFilme, int anoPublicacao, String autor, String genero, String idioma, int duracaoMinutos) {
        super(nomeFilme, anoPublicacao, autor, genero, idioma, duracaoMinutos);
        this.notaFilme = notaFilme;
        this.comentarios = comentarios;
    }
/**
 * Retorna a nota atribuida ao filme.
 * @return a nota do filme
 */
    public int getNotaFilme() {
        return notaFilme;
    }
/**
 * Define a nota do filme.
 * @param notaFilme a nova nota do filme.
 */
    public void setNotaFilme(int notaFilme) {
        this.notaFilme = notaFilme;
    }
/**
 * Retorna os comentários feitos pelo usuário sobre o filme.
 * @return os comentários do usuário.
 */
    public String getComentarios() {
        return comentarios;
    }
/**
 * Define ou altera os comentário do usuário sobre o filme.
 * @param comentarios os novos comentarios.
 */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
       
}
