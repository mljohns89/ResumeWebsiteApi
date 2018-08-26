package xyz.michaeljohnson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ResumeWebsiteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeWebsiteApiApplication.class, args);
	}
}
