package eu.codschool.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("eu.codschool.project.entities")
public class IotProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotProjectApplication.class);
		System.out.println("OK!");
	}

}