
package Modelo;

public class Electo {

    private int id;
    private String siglas;
    private String logo;
    private String nombre_elegido;

    public Electo(String siglas, String logo, String nombre_elegido) {
        this.siglas = siglas;
        this.logo = logo;
        this.nombre_elegido = nombre_elegido;
    }

    public Electo(int id, String siglas, String logo, String nombre_elegido) {
        this.id = id;
        this.siglas = siglas;
        this.logo = logo;
        this.nombre_elegido = nombre_elegido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNombre_elegido() {
        return nombre_elegido;
    }

    public void setNombre_elegido(String nombre_elegido) {
        this.nombre_elegido = nombre_elegido;
    }

}
