/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import modelo.usuarioM;

/**
 *
 * @author ra189362
 */
public class usuarioC {
    bancoDeDados usuario = new bancoDeDados();
    
    public void inserirUsuario(){
        try{
            usuario.conexao();
            String sql = "insert into usuarios values ('"+obj.getNomeUsuario()+"',"+obj.getIdadeUsuario()+","
                    +obj.getCodUsuario()+")";
            usuario.getStatement().execute(sql);
            
        }catch(){
            
        }
    }
}
