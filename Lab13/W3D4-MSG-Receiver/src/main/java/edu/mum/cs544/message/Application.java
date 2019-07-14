package edu.mum.cs544.message;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	@Bean
	public Queue hello() {
		return new Queue("hello");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
