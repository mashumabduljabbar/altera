package com.teacher.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacher.dto.TeacherDto;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {

	@Autowired
	private RabbitTemplate amqpTemplate;

	@PostMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> sendMessage(@RequestBody TeacherDto dto) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> response = new HashMap<String, Object>();

		amqpTemplate.convertAndSend("teacher_exchange", "teacher_key", dto);

		response.put("code", HttpStatus.OK.value());
		response.put("message", "data is being proceed");

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);

	}
}
