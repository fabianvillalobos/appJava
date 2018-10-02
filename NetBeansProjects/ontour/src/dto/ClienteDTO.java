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
public class ClienteDTO {
    
    private int numrutCli;
    private char drutCli;
    private String nombreCli;
    private String apellidoPatCli;
    private String apelliddoMatCli;
    private String mailCli;
    private char activo;
    private int idUsr;
    private String direccionCli;
    private Date fechaNacimientoCli;
    private String fonoCli;

    public ClienteDTO(int numrutCli, char drutCli, String nombreCli, String apellidoPatCli, String apelliddoMatCli, String mailCli, char activo, int idUsr, String direccionCli, Date fechaNacimientoCli, String fonoCli) {
        this.numrutCli = numrutCli;
        this.drutCli = drutCli;
        this.nombreCli = nombreCli;
        this.apellidoPatCli = apellidoPatCli;
        this.apelliddoMatCli = apelliddoMatCli;
        this.mailCli = mailCli;
        this.activo = activo;
        this.idUsr = idUsr;
        this.direccionCli = direccionCli;
        this.fechaNacimientoCli = fechaNacimientoCli;
        this.fonoCli = fonoCli;
    }

    public int getNumrutCli() {
        return numrutCli;
    }

    public void setNumrutCli(int numrutCli) {
        this.numrutCli = numrutCli;
    }

    public char getDrutCli() {
        return drutCli;
    }

    public void setDrutCli(char drutCli) {
        this.drutCli = drutCli;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getApellidoPatCli() {
        return apellidoPatCli;
    }

    public void setApellidoPatCli(String apellidoPatCli) {
        this.apellidoPatCli = apellidoPatCli;
    }

    public String getApelliddoMatCli() {
        return apelliddoMatCli;
    }

    public void setApelliddoMatCli(String apelliddoMatCli) {
        this.apelliddoMatCli = apelliddoMatCli;
    }

    public String getMailCli() {
        return mailCli;
    }

    public void setMailCli(String mailCli) {
        this.mailCli = mailCli;
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

    public String getDireccionCli() {
        return direccionCli;
    }

    public void setDireccionCli(String direccionCli) {
        this.direccionCli = direccionCli;
    }

    public Date getFechaNacimientoCli() {
        return fechaNacimientoCli;
    }

    public void setFechaNacimientoCli(Date fechaNacimientoCli) {
        this.fechaNacimientoCli = fechaNacimientoCli;
    }

    public String getFonoCli() {
        return fonoCli;
    }

    public void setFonoCli(String fonoCli) {
        this.fonoCli = fonoCli;
    }
}
