/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Anabe
 */
public class Parametros {
    private int id;
    private String circunscripcion;
    private int candidatos;
    private String tipoConsulta;
    private LocalDate fechaConsulta;
    private String estadoEscrutiño;

    public Parametros() {
    }

    
    public Parametros(String circunscripcion, int candidatos, String tipoConsulta, LocalDate fechaConsulta, String estadoEscrutiño) {
        this.circunscripcion = circunscripcion;
        this.candidatos = candidatos;
        this.tipoConsulta = tipoConsulta;
        this.fechaConsulta = fechaConsulta;
        this.estadoEscrutiño = estadoEscrutiño;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCircunscripcion() {
        return circunscripcion;
    }

    public void setCircunscripcion(String circunscripcion) {
        this.circunscripcion = circunscripcion;
    }

    public int getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(int candidatos) {
        this.candidatos = candidatos;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getEstadoEscrutiño() {
        return estadoEscrutiño;
    }

    public void setEstadoEscrutiño(String estadoEscrutiño) {
        this.estadoEscrutiño = estadoEscrutiño;
    }
    
    
    
}

