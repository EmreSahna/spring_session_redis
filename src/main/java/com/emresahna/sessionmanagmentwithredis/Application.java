package com.emresahna.sessionmanagmentwithredis;

import com.emresahna.sessionmanagmentwithredis.entity.User;
import com.emresahna.sessionmanagmentwithredis.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private final UserRepository userRepository;

	public Application(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			userRepository.save(new User(1L,"emre", "123"));
			userRepository.save(new User(2L,"ahmet", "123"));
		};
	}
}
