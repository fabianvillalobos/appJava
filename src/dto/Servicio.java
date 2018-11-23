/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author luisponce
 */
public class Servicio {
    private int id;
    private int idWs;
    private char activo;
    private int idTipoServicio;

    public Servicio() {
    }

    public Servicio(int idWs, char activo, int idTipoServicio) {
        this.idWs = idWs;
        this.activo = activo;
        this.idTipoServicio = idTipoServicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdWs() {
        return idWs;
    }

    public void setIdWs(int idWs) {
        this.idWs = idWs;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public int getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(int idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    
    
}
