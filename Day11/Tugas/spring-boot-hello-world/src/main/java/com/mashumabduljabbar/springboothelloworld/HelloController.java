package com.mashumabduljabbar.springboothelloworld;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/v1/{messages}")
	public String gethello(@PathVariable(value="messages") String param) {
		return "Method : GET - "+param;
	}  
	@PostMapping("/v1/{messages}")
	public String posthello(@PathVariable(value="messages") String param) {
		return "Method : POST - "+param;
	}  
	@DeleteMapping("/v1/{messages}")
	public String deletehello(@PathVariable(value="messages") String param) {
		return "Method : DELETE - "+param;
	}  
	
}