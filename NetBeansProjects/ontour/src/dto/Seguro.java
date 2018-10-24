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
public class Seguro {
    private int id;
    private String nombre;
    private String empresa;
    private String desc;
    private Date vigencia;
    private char activo;
    private int precio;

    public Seguro() {
    }

    public Seguro(int id, String nombre, String empresa, String desc, Date vigencia, char activo, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
        this.desc = desc;
        this.vigencia = vigencia;
        this.activo = activo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }    
}
