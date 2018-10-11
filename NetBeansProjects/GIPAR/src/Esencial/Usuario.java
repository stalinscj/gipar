package Esencial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * Clase que representa a un usuario el cual podrá interactuar con el sistema a través de su cuenta, ya sea como un jugador durante el juego, el cual puede seleccionar la acción que desee ejecutar durante su turno o simplemente interactuar con las ventanas.
 * @author Stalin
 */
public class Usuario{
    private String nombre;
    private String apellido;
    private String cedula;
    private String clave;
    private String imagen;
    private String correo;
    private String telefono;
    private String cargo;
    private String areaInteres;
    private String sexo;
    private String hostname;

    
    /**
     * Constructor de usuario con todos sus atributos sin medios de comnicacion ideal para guardar todos sus datos y estadísticas
     * @param nombre
     * @param apellido
     * @param cedula
     * @param clave
     * @param imagen
     * @param correo
     * @param telefono
     * @param areaInteres
     * @param cargo
     * @param sexo
     */
    public Usuario(String nombre, String apellido, String cedula, String clave, String imagen, String correo, String telefono, 
                   String areaInteres, String cargo, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.clave = clave;
        this.imagen = imagen;
        this.correo = correo;
        this.areaInteres = areaInteres;
        this.telefono = telefono;
        this.cargo = cargo;
        this.sexo = sexo;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the eimail
     */
    public String getEimail() {
        return getCorreo();
    }

    /**
     * @param eimail the eimail to set
     */
    public void setEimail(String eimail) {
        this.setCorreo(eimail);
    }


    /**
     * @return the areaInteres
     */
    public String getAreaInteres() {
        return areaInteres;
    }

    /**
     * @param areaInteres the areaInteres to set
     */
    public void setAreaInteres(String areaInteres) {
        this.areaInteres = areaInteres;
    }


    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    /**
     * @param hostname the tablero to set
     */
    public void setHostname(String hostname){
        this.hostname = hostname;
    }
    
    /**
     * @return the hostname
     */
    public String getHostname(){
        return hostname;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
        
}
