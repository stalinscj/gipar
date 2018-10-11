
package Esencial;

import java.util.ArrayList;

/**
 *
 * @author Stalin
 */
public class Reunion {
    
    private String id;
    private String fecha;
    private String hora;
    private String coordinador;
    private ArrayList<PuntoFijo> puntosFijos;
    private ArrayList<PuntoVario> puntosVarios;

    public Reunion(String fecha, String hora, String coordinador,String id, ArrayList<PuntoFijo> puntosFijos, ArrayList<PuntoVario> puntosVarios) {
        this.id=id;
        this.fecha = fecha;
        this.hora = hora;
        this.coordinador = coordinador;
        this.puntosFijos = puntosFijos;
        this.puntosVarios = puntosVarios;
    }
    
    public Reunion() {
        this.id=id;
        this.fecha = "";
        this.hora = "";
        this.coordinador = "";
        this.puntosFijos = null;
        this.puntosVarios = null;
    }
    
    

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the coordinador
     */
    public String getCoordinador() {
        return coordinador;
    }

    /**
     * @param coordinador the coordinador to set
     */
    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }

    /**
     * @return the puntosFijos
     */
    public ArrayList<PuntoFijo> getPuntosFijos() {
        return puntosFijos;
    }

    /**
     * @param puntosFijos the puntosFijos to set
     */
    public void setPuntosFijos(ArrayList<PuntoFijo> puntosFijos) {
        this.puntosFijos = puntosFijos;
    }

    /**
     * @return the puntosVarios
     */
    public ArrayList<PuntoVario> getPuntosVarios() {
        return puntosVarios;
    }

    /**
     * @param puntosVarios the puntosVarios to set
     */
    public void setPuntosVarios(ArrayList<PuntoVario> puntosVarios) {
        this.puntosVarios = puntosVarios;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
    
    
}
