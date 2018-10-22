/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author luisponce
 */
public class Vuelo {
    private int id;
    private char aerolinea;
    private String origen;
    private String destino;
    private Date salida;
    private int duracion;
    private int capacidad;
    private int ocupados;
    private char activo;
    private int precio;

    public Vuelo(int id, char aerolinea, String origen, String destino, Date salida, int duracion, int capacidad, int ocupados, char activo, int precio) {
        this.id = id;
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
        this.salida = salida;
        this.duracion = duracion;
        this.capacidad = capacidad;
        this.ocupados = ocupados;
        this.activo = activo;
        this.precio = precio;
    }

    public Vuelo(int id, char aerolinea) {
        this.id = id;
        this.aerolinea = aerolinea;
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

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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
