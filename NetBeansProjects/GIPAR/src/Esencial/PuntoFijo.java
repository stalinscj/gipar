/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esencial;

/**
 *
 * @author Stalin
 */
public class PuntoFijo {
    private String nombre;
    private String descripcion;

    public PuntoFijo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
     
    public PuntoFijo() {
        this.nombre = "";
        this.descripcion = "";
    }
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
