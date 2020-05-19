package br.com.hourjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class HourjobApplication {

	public static void main(String[] args) {
		SpringApplication.run(HourjobApplication.class, args);
	}

}
