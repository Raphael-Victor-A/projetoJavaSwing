package modelo;

public class sessaoUsuarioM {
    private static sessaoUsuarioM instance;
    private usuarioM usuarioLogado;

    private sessaoUsuarioM() {}

    public static sessaoUsuarioM getInstance() {
        if (instance == null) {
            instance = new sessaoUsuarioM();
        }
        return instance;
    }

    public void setUsuarioLogado(usuarioM usuario) {
        this.usuarioLogado = usuario;
    }

    public usuarioM getUsuarioLogado() {
        return usuarioLogado;
    }

    public void logout() {
        this.usuarioLogado = null;
    }
}