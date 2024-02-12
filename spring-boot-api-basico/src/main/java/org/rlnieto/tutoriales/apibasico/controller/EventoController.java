package org.rlnieto.tutoriales.apibasico.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evento")
public class EventoController {

    /**
     * Ejemplo de uso de GET con datos enviados en el body como json
     * Devuelve el texto enviado en el body
     *
     * @param mensaje
     * @return
    @GetMapping("/echo")
    */
    ResponseEntity<String> echoBody(@RequestBody String mensaje){



        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mensaje);
    }


    /**
     * Ejemplo de uso de GET con datos en el path
     * Devuelve el texto enviado en el path
     *
     * @param mensaje
     * @return
     */
     @GetMapping("/echo/{mensaje}")
     ResponseEntity<String> echoPath(@PathVariable String mensaje){
         return new ResponseEntity<String>(mensaje, HttpStatus.OK);
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
