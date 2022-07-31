package com.security.spring.api;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.spring.domain.AppUser;
import com.security.spring.domain.Role;
import com.security.spring.service.AppUserService;

import lombok.SneakyThrows;

@RestController
@RequestMapping("/api")
public class UserResource {

	@Autowired
	private AppUserService appUserService;

	@SneakyThrows(Exception.class)
	@PostMapping("/user/save")
	public ResponseEntity<Object> saveUser(@RequestBody AppUser appUser) {

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());

		return ResponseEntity.created(uri).body(appUserService.saveUser(appUser));
	}

	@SneakyThrows(Exception.class)
	@PostMapping("/role/save")
	public ResponseEntity<Object> saveRole(@RequestBody Role role) {

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

		return ResponseEntity.created(uri).body(appUserService.saveRole(role));
	}

	@SneakyThrows(Exception.class)
	@PostMapping("/role/addroletouser")
	public ResponseEntity<Object> addRoleToUser(@RequestParam(required = true) String username,
			@RequestParam(required = true) String roleName) {

		appUserService.addRoleToUser(username, roleName);

		return ResponseEntity.ok().build();
	}

	@SneakyThrows(Exception.class)
	@GetMapping("/user/{username}")
	public ResponseEntity<Object> getUser(@PathVariable(name = "username") String username) {

		return ResponseEntity.ok().body(appUserService.getUser(username));
	}

	@SneakyThrows(Exception.class)
	@GetMapping("/users")
	public ResponseEntity<Object> getUsers() {

		return ResponseEntity.ok().body(appUserService.getUsers());
	}

	@SneakyThrows(Exception.class)
	@GetMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) {

		String authorizationHeader = request.getHeader("Authorization");

		if (Optional.ofNullable(authorizationHeader).isPresent() && authorizationHeader.startsWith("Bearer ")) {

			try {

				String refreshToken = authorizationHeader.substring("Bearer ".length());

				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

				JWTVerifier verifier = JWT.require(algorithm).build();

				DecodedJWT decodedJWT = verifier.verify(refreshToken);

				String username = decodedJWT.getSubject();

				AppUser user = appUserService.getUser(username);

				String accessToken = JWT.create().withSubject(user.getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
						.withIssuer(request.getRequestURL().toString())
						.withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
						.sign(algorithm);

				Map<String, Object> token = new HashMap<String, Object>();

				response.setContentType(MediaType.APPLICATION_JSON_VALUE);

				token.put("accessToken", accessToken);
				token.put("refreshToken", refreshToken);

				new ObjectMapper().writeValue(response.getOutputStream(), token);

			} catch (Exception e) {

				Map<String, Object> error = new HashMap<String, Object>();

				response.setHeader("error", e.getMessage());
				response.setStatus(HttpStatus.FORBIDDEN.value());
				response.setContentType(MediaType.APPLICATION_JSON_VALUE);

				error.put("error", e.getMessage());
				error.put("status", HttpStatus.FORBIDDEN.value());

				new ObjectMapper().writeValue(response.getOutputStream(), error);
			}

		} else {

			throw new RuntimeException("Refresh token is missing");

		}
	}
}
