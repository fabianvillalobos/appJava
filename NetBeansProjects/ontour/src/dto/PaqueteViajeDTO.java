/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author luisponce
 */
public class PaqueteViajeDTO {
    
    private int idPaqueteviaje;
    private String descPaqueteviaje;
    private int valorPaqueteviaje;
    private char activo;
    private Date fechaCreacionPaqviaje;

    public PaqueteViajeDTO() {
    }

    public PaqueteViajeDTO(String descPaqueteviaje, int valorPaqueteviaje, char activo, Date fechaCreacionPaqviaje) {
        this.descPaqueteviaje = descPaqueteviaje;
        this.valorPaqueteviaje = valorPaqueteviaje;
        this.activo = activo;
        this.fechaCreacionPaqviaje = fechaCreacionPaqviaje;
    }

    public int getId_paqueteviaje() {
        return idPaqueteviaje;
    }

    public void setId_paqueteviaje(int idPaqueteviaje) {
        this.idPaqueteviaje = idPaqueteviaje;
    }

    public String getDescPaqueteviaje() {
        return descPaqueteviaje;
    }

    public void setDescPaqueteviaje(String descPaqueteviaje) {
        this.descPaqueteviaje = descPaqueteviaje;
    }

    public int getValorPaqueteviaje() {
        return valorPaqueteviaje;
    }

    public void setValorPaqueteviaje(int valorPaqueteviaje) {
        this.valorPaqueteviaje = valorPaqueteviaje;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public Date getFechaCreacionPaqviaje() {
        return fechaCreacionPaqviaje;
    }

    public void setFechaCreacionPaqviaje(Date fechaCreacionPaqviaje) {
        this.fechaCreacionPaqviaje = fechaCreacionPaqviaje;
    }

    
    
    
    
}
