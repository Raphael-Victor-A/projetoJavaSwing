package modelo;
/**
 * Essa classe controla qual usuário está logado atualmente no sistema.
 * 
 * @author Jarbas
 */
public class sessaoUsuarioM {
    private static sessaoUsuarioM instance;
    private usuarioM usuarioLogado;

    private sessaoUsuarioM() {}
    /**
     * Obtém a instância da sessão do usuário. Se ela ainda não existir; é criada.
     * @return a instância de sessaoUsuarioM.
     */
    public static sessaoUsuarioM getInstance() {
        if (instance == null) {
            instance = new sessaoUsuarioM();
        }
        return instance;
    }
    /**
     * Define o usuário que está logado.
     * @param usuario o objeto usuarioM representando o usuário autenticado.
     */
    public void setUsuarioLogado(usuarioM usuario) {
        this.usuarioLogado = usuario;
    }
    /**
     * Retorna o usuário atualmente logado na sessão.
     * @return o objeto da sessão, ou null se nenhum estiver logado.
     */
    public usuarioM getUsuarioLogado() {
        return usuarioLogado;
    }

    /**
     * Realiza o logout. Remove o usuário atual.
     */
    public void logout() {
        this.usuarioLogado = null;
    }
}