package com.mashumabduljabbar.jwt.controller;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping(path="/v2/auth", produces="application/json")
@CrossOrigin(origins="*")
public class UserController {
	@Value("${jwt.secret}")
	private String secret;
	
	@GetMapping("/info")
	public ResponseEntity<?> getInfo(@RequestHeader("Authorization") String bearerToken) throws Exception {
		String bearer = bearerToken.replace("Bearer ", "");
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(bearer).getBody();
		HashMap<String,String> respon=new HashMap<String,String>();
		respon.put("phone", claims.get("sub", String.class));
		return ResponseEntity.ok(respon);
	}
}