/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author diego.cifuentes
 */
public class UsuarioPersonaDTO {

    private String loginUsr;
    private String passUsr;
    private int idTipoUsuario;
    private char Usuarioactivo;
    private int numrut;
    private char drut;
    private String nombre;
    private String apellidoPat;
    private String apelliddoMat;
    private String mail;
    private char activo;
    private int idUsr;
    private String direccion;
    private Date fechaNacimiento;
    private String fono;

    public UsuarioPersonaDTO() {
    }

    public UsuarioPersonaDTO(String loginUsr, String passUsr, int idTipoUsuario, char Usuarioactivo, int numrut, char drut, String nombre, String apellidoPat, String apelliddoMat, String mail, char activo, int idUsr, String direccion, Date fechaNacimiento, String fono) {
        this.loginUsr = loginUsr;
        this.passUsr = passUsr;
        this.idTipoUsuario = idTipoUsuario;
        this.Usuarioactivo = Usuarioactivo;
        this.numrut = numrut;
        this.drut = drut;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apelliddoMat = apelliddoMat;
        this.mail = mail;
        this.activo = activo;
        this.idUsr = idUsr;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fono = fono;
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

    public char getUsuarioactivo() {
        return Usuarioactivo;
    }

    public void setUsuarioactivo(char Usuarioactivo) {
        this.Usuarioactivo = Usuarioactivo;
    }

    public int getNumrut() {
        return numrut;
    }

    public void setNumrut(int numrut) {
        this.numrut = numrut;
    }

    public char getDrut() {
        return drut;
    }

    public void setDrut(char drut) {
        this.drut = drut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApelliddoMat() {
        return apelliddoMat;
    }

    public void setApelliddoMat(String apelliddoMat) {
        this.apelliddoMat = apelliddoMat;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public int getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(int idUsr) {
        this.idUsr = idUsr;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    
}
