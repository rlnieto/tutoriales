package org.rlnieto.tutoriales.apibasico.model;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.sql.Array;
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
public class FakeEventoRepository {
    HashMap<Integer, Evento> eventos = new HashMap<Integer, Evento>(10);

    /**
     * Constructor
     * Cargamos un hash con datos aleatorios y haremos las consultas sobre él
     */
    public FakeEventoRepository(){
        this.eventos = this.eventosRandom();
    }


    /**
     * Búsqueda por clave
     * @param id
     * @return
     */
    public Evento findById(int id){
        return this.eventos.get(id);
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
     * Método privada para cargar el hashmap utilizado en las operaciones del fake repository
     *
     * @return
     */
    private HashMap<Integer, Evento> eventosRandom() {

        Faker faker = new Faker(new Locale("es"));
        HashMap<Integer, Evento> eventos = new HashMap<Integer, Evento>(10);

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
            eventos.put(i, evento);
        }
        return eventos;
    }
}
