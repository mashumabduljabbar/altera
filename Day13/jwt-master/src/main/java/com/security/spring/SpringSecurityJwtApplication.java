package com.security.spring;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.spring.domain.AppUser;
import com.security.spring.domain.Role;
import com.security.spring.service.AppUserService;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run(AppUserService appUserService) {
//
//		return args -> {
//
//			appUserService.saveUser(new AppUser(null, "Fajar Satriatna", "fajar123", "fajar123", new ArrayList<>()));
//			appUserService.saveUser(new AppUser(null, "James Arthur", "james123", "james123", new ArrayList<>()));
//			appUserService.saveUser(new AppUser(null, "Harry Styles", "harry123", "harry123", new ArrayList<>()));
//			appUserService.saveUser(new AppUser(null, "Dua Lipa", "dualipa123", "dualipa123", new ArrayList<>()));
//
//			appUserService.saveRole(new Role(null, "ROLE_USER"));
//			appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
//			appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
//			appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//			appUserService.addRoleToUser("fajar123", "ROLE_USER");
//			appUserService.addRoleToUser("james123", "ROLE_MANAGER");
//			appUserService.addRoleToUser("harry123", "ROLE_ADMIN");
//			appUserService.addRoleToUser("dualipa123", "ROLE_SUPER_ADMIN");
//		};
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
