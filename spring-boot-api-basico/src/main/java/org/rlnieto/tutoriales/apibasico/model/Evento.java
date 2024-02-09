package org.rlnieto.tutoriales.apibasico.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="evento")
public class Evento {
    @Id
    @SequenceGenerator(name = "evento_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_seq")
    private Long id;
    private String motivo;
    private short tipo;
    private Date fecha;
    private Time hora;

    /**
     * Empty constructor
     *
     */
    public Evento(){}


    // Getters & setters
    public Long getId() {
        return id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

}
