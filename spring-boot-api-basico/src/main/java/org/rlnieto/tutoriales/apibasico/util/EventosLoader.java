package org.rlnieto.tutoriales.apibasico.util;

import com.github.javafaker.Faker;
import org.rlnieto.tutoriales.apibasico.model.Evento;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Crea una colección de eventos para pruebas
 */
@Service
public class EventosLoader {

    public List<Evento> randomEventos() {

        Faker faker = new Faker(new Locale("es"));
        List<Evento> eventos = new ArrayList<Evento>(10);

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
            evento.setTipo("Cena");
            evento.setMotivo(faker.food().dish());

            eventos.add(evento);
        }
        return eventos;
    }
}
