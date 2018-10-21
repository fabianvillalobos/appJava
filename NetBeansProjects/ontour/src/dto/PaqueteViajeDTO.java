/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author luisponce
 */
public class PaqueteViajeDTO {
    
    private int id_paqueteviaje;
    private String desc_paqueteviaje;
    private int valor_paqueteviaje;
    private char activo;
    private Date fecha_creacion_paqviaje;

    public PaqueteViajeDTO() {
    }

    public int getId_paqueteviaje() {
        return id_paqueteviaje;
    }

    public void setId_paqueteviaje(int id_paqueteviaje) {
        this.id_paqueteviaje = id_paqueteviaje;
    }

    public String getDesc_paqueteviaje() {
        return desc_paqueteviaje;
    }

    public void setDesc_paqueteviaje(String desc_paqueteviaje) {
        this.desc_paqueteviaje = desc_paqueteviaje;
    }

    public int getValor_paqueteviaje() {
        return valor_paqueteviaje;
    }

    public void setValor_paqueteviaje(int valor_paqueteviaje) {
        this.valor_paqueteviaje = valor_paqueteviaje;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public Date getFecha_creacion_paqviaje() {
        return fecha_creacion_paqviaje;
    }

    public void setFecha_creacion_paqviaje(Date fecha_creacion_paqviaje) {
        this.fecha_creacion_paqviaje = fecha_creacion_paqviaje;
    }
    
    
    
}
