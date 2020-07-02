
package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Votante {
    private int id;
    private String nif;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private LocalDate fechanac;
    private String password;
    private String votado; 
    private String rol;

    public Votante(){}

    public Votante(String nombre, String apellidos, String domicilio, LocalDate fechanac, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.fechanac = fechanac;
        this.password = password;
    }
    
    public Votante(String nif, String nombre, String apellidos, String domicilio, LocalDate fechanac, String password, String votado, String rol) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.fechanac = fechanac;
        this.password = password;
        this.votado = votado;
        this.rol = rol;
    } // LO USAMOS PARA AÑADIR VOTANTE

    public Votante(String nif, String nombre, String apellidos, String domicilio, LocalDate fechanac, String password) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.fechanac = fechanac;
        this.password= password;
    } // LO USAMOS PARA MODIFICAR VOTANTE

    public Votante(String nif, String nombre, String apellidos, String domicilio, String votado, LocalDate fechanac) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.fechanac = fechanac;
        this.votado = votado;
    } // LO USAMOS PARA LISTAR VOTANTES

    public Votante(String nif, String password) {
        this.nif = nif;
        this.password = password;
    } //LO USAMOS PARA EL LOGIN
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public LocalDate getFechanac() {
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha= fechanac.format(formato);
        return LocalDate.parse(fecha,formato);
    }
    public String getFechaNacString(){
    DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy"); //ESTE EL FORMATO QUE QUEREMOS PERO PODEMOS PONER EL QUE QUERAMOS
    return fechanac.format(formato);
    } //LO UTILIZAMOS PARA SACAR LA FECHA EN EL CENSO

    public void setFechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVotado() {
        return votado;
    }

    public void setVotado(String votado) {
        this.votado = votado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
    
}
