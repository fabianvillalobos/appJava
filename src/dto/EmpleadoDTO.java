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
public class EmpleadoDTO {
    
    private int numrutEmp;
    private char drutEmp;
    private String nombreEmp;
    private String apellidoPatEmp;
    private String apelliddoMatEmp;
    private String mailLaboral;
    private String direccionEmp;
    private char activo;
    private int idUsr;
    private Date fechaNacimientoEmp;
    private String fonoEmp;

    public EmpleadoDTO(){
        
    }
    public EmpleadoDTO(int numrutEmp, char drutEmp, String nombreEmp, String apellidoPatEmp, String apelliddoMatEmp, String mailLaboral, String direccionEmp, char activo, int idUsr, Date fechaNacimientoEmp, String fonoEmp) {
        this.numrutEmp = numrutEmp;
        this.drutEmp = drutEmp;
        this.nombreEmp = nombreEmp;
        this.apellidoPatEmp = apellidoPatEmp;
        this.apelliddoMatEmp = apelliddoMatEmp;
        this.mailLaboral = mailLaboral;
        this.direccionEmp = direccionEmp;
        this.activo = activo;
        this.idUsr = idUsr;
        this.fechaNacimientoEmp = fechaNacimientoEmp;
        this.fonoEmp = fonoEmp;
    }

    public int getNumrutEmp() {
        return numrutEmp;
    }

    public void setNumrutEmp(int numrutEmp) {
        this.numrutEmp = numrutEmp;
    }

    public char getDrutEmp() {
        return drutEmp;
    }

    public void setDrutEmp(char drutEmp) {
        this.drutEmp = drutEmp;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public String getApellidoPatEmp() {
        return apellidoPatEmp;
    }

    public void setApellidoPatEmp(String apellidoPatEmp) {
        this.apellidoPatEmp = apellidoPatEmp;
    }

    public String getApelliddoMatEmp() {
        return apelliddoMatEmp;
    }

    public void setApelliddoMatEmp(String apelliddoMatEmp) {
        this.apelliddoMatEmp = apelliddoMatEmp;
    }

    public String getMailLaboral() {
        return mailLaboral;
    }

    public void setMailLaboral(String mailLaboral) {
        this.mailLaboral = mailLaboral;
    }

    public String getDireccionEmp() {
        return direccionEmp;
    }

    public void setDireccionEmp(String direccionEmp) {
        this.direccionEmp = direccionEmp;
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

    public Date getFechaNacimientoEmp() {
        return fechaNacimientoEmp;
    }

    public void setFechaNacimientoEmp(Date fechaNacimientoEmp) {
        this.fechaNacimientoEmp = fechaNacimientoEmp;
    }

    public String getFonoEmp() {
        return fonoEmp;
    }

    public void setFonoEmp(String fonoEmp) {
        this.fonoEmp = fonoEmp;
    }
    
    
}
