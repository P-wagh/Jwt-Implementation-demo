package com.jwtexample.jwtdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jwtexample.jwtdemo.model.Role;
import com.jwtexample.jwtdemo.model.User;
import com.jwtexample.jwtdemo.repository.UserRepository;

@SpringBootApplication
public class JwtdemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JwtdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Finding user in databse whose having role "ADMIN"
		User adminaccount = userRepository.findByRole(Role.ADMIN);

		if (adminaccount == null) {
			User user = new User();

			user.setEmail("admin@gmail.com");
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			user.setRole(Role.ADMIN);

			userRepository.save(user);			
		}
	}

}
