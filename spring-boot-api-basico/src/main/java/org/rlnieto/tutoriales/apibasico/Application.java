package org.rlnieto.tutoriales.apibasico;

import org.rlnieto.tutoriales.apibasico.util.EventosLoader;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	// Definimos un bean que devuelve una instancia de ApplicationRunner. Al inicializar el contexto de la
	// aplicación en main se creará este bean y al devolver una instancia de ApplicationRunner, el código
	// del método se ejecutará inmediatamente
	@Bean
	public ApplicationRunner configure(EventosLoader eventosLoader, ConfigurableApplicationContext context){
		return env ->
		{
			eventosLoader.randomEventos();
			System.out.println("ApplicationRunner creado...");

			// Si queremos salir de la aplicación:
			//SpringApplication.exit(context);
		};
	}
}
