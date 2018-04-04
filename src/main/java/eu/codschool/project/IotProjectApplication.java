package eu.codschool.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import eu.codschool.project.entities.DeviceType;
import eu.codschool.project.entities.Room;
import eu.codschool.project.entities.User;
import eu.codschool.project.repositories.DeviceTypeRepository;
import eu.codschool.project.repositories.RoomRepository;
import eu.codschool.project.repositories.UserRepository;


@SpringBootApplication
@EntityScan("eu.codschool.project.entities")
public class IotProjectApplication {
	private static final Logger log = LoggerFactory.getLogger(IotProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(IotProjectApplication.class);
		System.out.println("OK!");
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
//			repository.save(new DeviceType("Coffee Maker"));
//			repository.save(new DeviceType("SmartFridge"));
//			repository.save(new DeviceType("Lock"));
//			//repository.save(new Room("Living Room"));
//			//repository.save(new Room("Kitchen"));
//			//repository.save(new Room("Back Yard"));
//			//repository.save(new Room("Bedroom"));
//			// fetch all rooms
			log.info("Device Types found with findAll():");
			log.info("-------------------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

		};
	}

}