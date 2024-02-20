package org.rlnieto.tutoriales.apibasico.model;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Repositorio fake, se crea un hashmap con datos aleatorios y los métodos
 * para consultarlo
 *
 */
@Service
public class EventoRepository {
    HashMap<Long, Evento> eventos = new HashMap<Long, Evento>(10);

    /**
     * Constructor
     * Cargamos un hash con datos aleatorios y haremos las consultas sobre él
     */
    public EventoRepository(){
        this.eventos = this.eventosRandom();
    }


    /**
     * Búsqueda por clave
     * @param id
     * @return
     */
    public Optional<Evento> findById(Long id){
        Optional<Evento>evento = Optional.ofNullable(this.eventos.get(id));
        return evento;
    }

    /**
     * Devuelve todos los eventos del hashmap
     * @return
     */
    public List<Evento> findAll(){
        List<Evento> listaEventos = new ArrayList<Evento>(this.eventos.size());
        listaEventos.addAll(this.eventos.values());

        return listaEventos;
    }

    /**
     * Añade un evento en el hashmap
     * @param evento
     */
    public void altaEvento(Evento evento){
        this.eventos.put(evento.getId(), evento);
    }

    /**
     * Elimina un evento del hashmap
     * @param id
     * @return
     */
    public Optional<Evento> bajaEvento(Long id){
        Evento evento = this.eventos.remove(id);
        return Optional.ofNullable(evento);
    }


    /**
     * Método privada para cargar el hashmap utilizado en las operaciones del repository
     *
     * @return
     */
    private HashMap<Long, Evento> eventosRandom() {

        Faker faker = new Faker(new Locale("es"));
        HashMap<Long, Evento> eventos = new HashMap<Long, Evento>(10);

        for (int i = 0; i < 10; i++) {
            Evento evento = new Evento();
            evento.setId(Long.valueOf(i));

            // Generamos fecha y hora aleatorios
            Date dateTime  = faker.date().future(
                    (int) (faker.random().nextDouble() * 10 + 1),
                    TimeUnit.DAYS);

            LocalDate fecha = LocalDateTime.ofInstant(dateTime.toInstant(),
                    ZoneId.of("UTC")).toLocalDate();

            LocalTime hora = LocalDateTime.ofInstant(dateTime.toInstant(),
                    ZoneId.of("UTC")).toLocalTime();

            // Cargamos los datos en el DTO
            evento.setFecha(fecha);
            evento.setHora(hora);
            evento.setTipo("Charla");
            //evento.setMotivo(faker.food().dish());
            evento.setMotivo(faker.company().bs());
            //evento.setMotivo(faker.friends().location());
            eventos.put(Long.valueOf(i), evento);
        }
        return eventos;
    }
}
