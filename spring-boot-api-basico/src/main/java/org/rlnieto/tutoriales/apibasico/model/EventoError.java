package org.rlnieto.tutoriales.apibasico.model;

public class EventoError {
    String codigo;
    String mensaje;

    public EventoError(String codigo, String mensaje){
        this.codigo = codigo;
        this.mensaje = mensaje;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }





}
