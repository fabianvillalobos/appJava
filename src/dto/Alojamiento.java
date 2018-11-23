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
public class Alojamiento {
    private int id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
    private int habitacion;
    private int precio;
    private char ocupada;
    private char activa;
    private String servicios;

    public Alojamiento() {
    }

    public Alojamiento(int id, String nombre, String direccion, String ciudad, String pais, int habitacion, int precio, char ocupada, char activa, String servicios) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.habitacion = habitacion;
        this.precio = precio;
        this.ocupada = ocupada;
        this.activa = activa;
        this.servicios = servicios;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public char getOcupada() {
        return ocupada;
    }

    public void setOcupada(char ocupada) {
        this.ocupada = ocupada;
    }

    public char getActiva() {
        return activa;
    }

    public void setActiva(char activa) {
        this.activa = activa;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }
}
