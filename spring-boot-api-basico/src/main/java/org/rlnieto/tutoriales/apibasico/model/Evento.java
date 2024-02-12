package org.rlnieto.tutoriales.apibasico.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private Long id;
    private String motivo;
    private String tipo;
    private LocalDate fecha;
    private LocalTime hora;

    /**
     * Empty constructor
     *
     */
    public Evento(){}


    // Getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        String datos = String.format("ID: %d - Fecha: %s - Hora: %s - Tipo: %s - Motivo: %s",
                this.id,
                this.fecha.toString(),
                this.hora.toString(),
                this.tipo,
                this.motivo);

        return datos;
    }
}
