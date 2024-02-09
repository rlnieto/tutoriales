package org.rlnieto.tutoriales.apibasico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ImportResource({"classpath*:resources.xml"})
public class Application {
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ApplicationRunner configure(
			ConfigurableApplicationContext context){

		return env -> {
			String dbUrl = this.env.getProperty("spring.datasource.url");
			System.out.println(dbUrl);

			AbstractApplicationContext ctx
					= new ClassPathXmlApplicationContext(new String []{"classpath*:resources.xml"});

			//SpringApplication.exit(context);
		};

	}

}
