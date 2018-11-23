/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author diego.cifuentes
 */
public class UsuarioDTO {
    
    private int idUsr;
    private String loginUsr;
    private String passUsr;
    private int idTipoUsuario;
    private char activo;

    public UsuarioDTO(String loginUsr, String passUsr, int idTipoUsuario, char activo) {
        this.loginUsr = loginUsr;
        this.passUsr = passUsr;
        this.idTipoUsuario = idTipoUsuario;
        this.activo = activo;
    }

    public UsuarioDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(int idUsr) {
        this.idUsr = idUsr;
    }

    public String getLoginUsr() {
        return loginUsr;
    }

    public void setLoginUsr(String loginUsr) {
        this.loginUsr = loginUsr;
    }

    public String getPassUsr() {
        return passUsr;
    }

    public void setPassUsr(String passUsr) {
        this.passUsr = passUsr;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }
    
}
