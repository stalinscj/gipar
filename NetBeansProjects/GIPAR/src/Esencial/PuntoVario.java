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
public class PuntoVario {
    private String nombre;
    private String descripcion;
    private String responsable;

    public PuntoVario(String nombre, String descripcion, String responsable) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
    }

    
    public PuntoVario() {
        this.nombre = "";
        this.descripcion = "";
        this.responsable = "";
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

    /**
     * @return the responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
}
