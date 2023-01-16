package it.univpm.TicketMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import controller.Controller;

/** Avvia l'applicazione
 * 
 * @author Domenico Ciavarella
 * @author Daniele Cota
 *
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = Controller.class)
public class TicketMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketMasterApplication.class, args);
	}

}
