package org.rlnieto.tutoriales.apibasico.controller;

import org.rlnieto.tutoriales.apibasico.model.Evento;
import org.rlnieto.tutoriales.apibasico.model.EventoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/evento")
public class EventoController {

    EventoRepository eventoRepository;

    /**
     * Constructor
     * @param eventoRepository
     */
    public EventoController(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    @GetMapping("/eventos")
    ResponseEntity allEvents(){
        List<Evento> eventos = this.eventoRepository.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(eventos);
    }


    /**
     * Búsqueda de un evento por clave
     * @param id
     * @return
     */
    @GetMapping("/eventos/{id}")
    ResponseEntity eventoById(@PathVariable Long id){
        Evento evento = this.eventoRepository.findById(id);

        // Si el evento no existe devolvemos un 404
        if(null == evento){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(evento);
    }

    /**
     * Alta de un evento
     * @param evento
     * @return
     */
    @PostMapping("/eventos")
    ResponseEntity altaEvento(@RequestBody Evento evento){

        // TODO: ¿añadir validaciones sobre el objeto evento antes de insertarlo?
        this.eventoRepository.altaEvento(evento);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(evento);
    }

    /**
     * Borrado de un evento por clave
     * @param id
     * @return
     */
    @DeleteMapping("/eventos/{id}")
    ResponseEntity bajaEvento(@PathVariable Long id){
        Optional<Evento> evento = this.eventoRepository.bajaEvento(id);

        if(evento.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(evento.get());
    }



/*    @GetMapping("/{id}")
    ResponseEntity<Optional<Evento>> findAllEventos(@PathVariable Long id){
        HttpStatus status = HttpStatus.OK;

        Optional<Evento> evento =  this.eventoService.datosEvento(id);
        if(evento.isEmpty()) status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<Optional<Evento>>(evento, status);
    }


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
*/
}
