package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDto.CreateStudentDto;
import com.student.dto.StudentDto.UpdateStudentDto;
import com.student.service.StudentService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentService;

	@SneakyThrows(Exception.class)
	@PostMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createStudent(@RequestBody CreateStudentDto dto) {

		log.info("POST http://localhost:8080/api/v1/student is called...");

		return studentService.createStudent(dto);
	}

	@SneakyThrows(Exception.class)
	@GetMapping(path = "/student/{studentName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getStudent(@PathVariable(name = "studentName") String studentName) {

		log.info("GET http://localhost:8080/api/v1/student/{} is called...", studentName);

		return studentService.getStudent(studentName);
	}

	@SneakyThrows(Exception.class)
	@GetMapping(path = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getStudents() {

		log.info("GET http://localhost:8080/api/v1/students is called...");

		return studentService.getStudents();
	}

	@SneakyThrows(Exception.class)
	@PutMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateStudent(@RequestBody UpdateStudentDto dto) {

		log.info("PUT http://localhost:8080/api/v1/student is called...");

		return studentService.updateStudent(dto);
	}

	@SneakyThrows(Exception.class)
	@DeleteMapping(path = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteStudent(@PathVariable(name = "id") Long id) {

		log.info("DELETE http://localhost:8080/api/v1/student/{} is called...", id);

		return studentService.deleteStudent(id);
	}
}
