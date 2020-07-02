/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Anabe
 */
public class Escaños {
    private int id_partido;
    private String siglas; //NO ES NECESARIO 100%
    private String logo;    //NO ES NECESARIO 100%
    private int numescaños;

    public Escaños(int id_partido, String siglas, String logo, int numescaños) {
        this.id_partido = id_partido;
        this.siglas = siglas;
        this.logo = logo;
        this.numescaños = numescaños;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
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

    public int getNumescaños() {
        return numescaños;
    }

    public void setNumescaños(int numescaños) {
        this.numescaños = numescaños;
    }

    //NECESITAMOS EL HASCODE Y EL EQUALS PARA EL INDEXOF QUE REALIZAMOS EN LA VISTA DE ELECTOS (ARRAYLIST)
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.siglas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Escaños other = (Escaños) obj;
        if (!Objects.equals(this.siglas, other.siglas)) {
            return false;
        }
        return true;
    }
    
    
    
}

