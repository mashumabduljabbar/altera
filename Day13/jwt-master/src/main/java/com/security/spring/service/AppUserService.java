package com.security.spring.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.spring.domain.AppUser;
import com.security.spring.domain.Role;
import com.security.spring.repo.AppUserRepository;
import com.security.spring.repo.RoleRepository;

import lombok.SneakyThrows;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackOn = { SQLException.class, Exception.class })
@Slf4j
public class AppUserService implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@SneakyThrows(UsernameNotFoundException.class)
	public UserDetails loadUserByUsername(String username) {

		val appUser = appUserRepository.findByUsername(username);

		if (Optional.ofNullable(appUser).isPresent()) {

			log.info("user {} is available in the database", username);

			Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

			appUser.getRoles().forEach(role -> {

				authorities.add(new SimpleGrantedAuthority(role.getName()));
			});

			return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(),
					authorities);

		} else {

			log.info("user {} is not available in the database", username);
			throw new UsernameNotFoundException("user " + username + " is not available in the database");
		}
	}

	@SneakyThrows(Exception.class)
	public AppUser saveUser(AppUser appUser) {

		log.info("saving new user {} to the database", appUser.getName());

		appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

		return appUserRepository.save(appUser);
	}

	@SneakyThrows(Exception.class)
	public Role saveRole(Role role) {

		log.info("saving new role {} to the database", role.getName());

		return roleRepository.save(role);
	}

	@SneakyThrows(Exception.class)
	public void addRoleToUser(String username, String roleName) {

		log.info("adding role {} to user {}", roleName, username);

		val appUser = appUserRepository.findByUsername(username);
		val role = roleRepository.findByName(roleName);

		appUser.getRoles().add(role);
	}

	@SneakyThrows(Exception.class)
	public AppUser getUser(String username) {

		log.info("getting user{} from the database", username);

		return appUserRepository.findByUsername(username);
	}

	@SneakyThrows(Exception.class)
	public List<AppUser> getUsers() {

		log.info("getting all users from the database");

		return appUserRepository.findAll();
	}

}
