package org.rlnieto.tutoriales.apibasico.controller;

import org.rlnieto.tutoriales.apibasico.model.Evento;
import org.rlnieto.tutoriales.apibasico.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private EventoService eventoService;

    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }

    @GetMapping
    Iterable<Evento> todosLosEventos(){
        return this.eventoService.todosLosEventos();
    }

    @GetMapping("/{id}")
    Optional<Evento> findAllEventos(@PathVariable Long id){
        return this.eventoService.datosEvento(id);
    }


/*    @GetMapping("/{id}")
    ResponseEntity<Optional<Evento>> findAllEventos(@PathVariable Long id){
        HttpStatus status = HttpStatus.OK;

        Optional<Evento> evento =  this.eventoService.datosEvento(id);
        if(evento.isEmpty()) status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<Optional<Evento>>(evento, status);
    }
*/

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    Evento postEvento(@RequestBody Evento evento){
        return this.eventoService.altaEvento(evento);
    }

    @PutMapping()
    ResponseEntity<Evento>putEvento(@RequestBody Evento evento){
        HttpStatus status = HttpStatus.OK;

        Optional<Evento> eventoAux = this.eventoService.datosEvento(evento.getId());

        if(eventoAux.isEmpty()){
            status = HttpStatus.CREATED;
        }

        return new ResponseEntity<Evento>(this.eventoService.modificarEvento(evento), status);


    }

}
