package org.rlnieto.tutoriales.apibasico.service;

import org.rlnieto.tutoriales.apibasico.model.Evento;
import org.rlnieto.tutoriales.apibasico.model.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventoService {

    private EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    /**
     * Devuelve la lista de eventos "enriquecida"
     *
     * @return
     */
    public Iterable<Evento> todosLosEventos(){
        return this.eventoRepository.findAll();
    }

    public Optional<Evento> datosEvento(Long idEvento){
        return this.eventoRepository.findById(idEvento);
    }

    public Evento altaEvento(Evento evento){
        return this.eventoRepository.save(evento);
    }

    public Evento modificarEvento(Evento evento){
        return(this.eventoRepository.save(evento));
    }

    public void bajaEvento(Evento evento){
        this.eventoRepository.delete(evento);
    }

}
