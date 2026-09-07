package com.ecommerce.api;

import com.ecommerce.api.model.Category;
import com.ecommerce.api.model.Role;
import com.ecommerce.api.model.User;
import com.ecommerce.api.repository.CategoryRepository;
import com.ecommerce.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EntityScan(basePackages = "com.ecommerce.api")
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(CategoryRepository categoryRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (categoryRepository.count() == 0) {
				categoryRepository.save(Category.builder()
						.name("Electronics")
						.description("Gadgets and devices")
						.build());

				categoryRepository.save(Category.builder()
						.name("Books")
						.description("Physical and electronic books")
						.build());

				System.out.println(">>> Initial categories inserted successfully! <<<");
			}

			if (userRepository.count() == 0) {
				userRepository.save(User.builder()
						.fullName("Admin Global")
						.email("admin@ecommerce.com")
						.password(passwordEncoder.encode("admin123"))
						.role(Role.ROLE_ADMIN)
						.build());

				System.out.println(">>> Admin user created: admin@ecommerce.com / admin123 <<<");
			}
		};
	}
}