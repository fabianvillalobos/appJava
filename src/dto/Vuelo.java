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
public class Vuelo {
    private int id;
    private char aerolinea;
    private String o_terminal;
    private String o_ciudad;
    private String o_pais;
    private String d_terminal;
    private String d_ciudad;
    private String d_pais;
    private Date salida;
    private int duracion;
    private int capacidad;
    private int ocupados;
    private char activo;
    private int precio;

    public Vuelo(int id, char aerolinea, String o_terminal, String o_ciudad, String o_pais, 
            String d_terminal, String d_ciudad, String d_pais, Date salida, int duracion, 
            int capacidad, int ocupados, char activo, int precio) {
        this.id = id;
        this.aerolinea = aerolinea;
        this.o_terminal = o_terminal;
        this.o_ciudad = o_ciudad;
        this.o_pais = o_pais;
        this.d_terminal = d_terminal;
        this.d_ciudad = d_ciudad;
        this.d_pais = d_pais;
        this.salida = salida;
        this.duracion = duracion;
        this.capacidad = capacidad;
        this.ocupados = ocupados;
        this.activo = activo;
        this.precio = precio;
    }

    public Vuelo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(char aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getO_terminal() {
        return o_terminal;
    }

    public void setO_terminal(String o_terminal) {
        this.o_terminal = o_terminal;
    }

    public String getO_ciudad() {
        return o_ciudad;
    }

    public void setO_ciudad(String o_ciudad) {
        this.o_ciudad = o_ciudad;
    }

    public String getO_pais() {
        return o_pais;
    }

    public void setO_pais(String o_pais) {
        this.o_pais = o_pais;
    }

    public String getD_terminal() {
        return d_terminal;
    }

    public void setD_terminal(String d_terminal) {
        this.d_terminal = d_terminal;
    }

    public String getD_ciudad() {
        return d_ciudad;
    }

    public void setD_ciudad(String d_ciudad) {
        this.d_ciudad = d_ciudad;
    }

    public String getD_pais() {
        return d_pais;
    }

    public void setD_pais(String d_pais) {
        this.d_pais = d_pais;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getOcupados() {
        return ocupados;
    }

    public void setOcupados(int ocupados) {
        this.ocupados = ocupados;
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
