
package Modelo;

public class Partido implements Comparable<Partido> {

    private int id;
    private String nombrepartido;
    private String siglas;
    private String logo;
    private int votos;

    public Partido() {
    }

    public Partido(int id, String nombrepartido, String siglas, String logo, int votos) {
        this.id = id;
        this.nombrepartido = nombrepartido;
        this.siglas = siglas;
        this.logo = logo;
        this.votos = votos;
    }

    public Partido(String nombrepartido, String siglas, String logo, int votos) {
        this.nombrepartido = nombrepartido;
        this.siglas = siglas;
        this.logo = logo;
        this.votos = votos;
    }

    public Partido(String siglas) {
        this.siglas = siglas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrepartido() {
        return nombrepartido;
    }

    public void setNombrepartido(String nombrepartido) {
        this.nombrepartido = nombrepartido;
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

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int compareTo(Partido o) {
        if (this.votos < o.votos) {
            return -1;
        } else if (this.votos > o.votos) {
            return 1;
        }
        return 0;
    }

}
