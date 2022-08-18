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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@Api("REST API Documentation for Student Project")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@SneakyThrows(Exception.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieving data"),
			@ApiResponse(code = 201, message = "Successfully creating data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "There are errors which come from codes or data") })
	@ApiOperation(value = "An API for creating student data", produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createStudent(@RequestBody CreateStudentDto dto) {

		log.info("POST http://localhost:8080/api/v1/student is called");
		return studentService.createStudent(dto);
	}

	@SneakyThrows(Exception.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieving data"),
			@ApiResponse(code = 201, message = "Successfully creating data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "There are errors which come from codes or data") })
	@ApiOperation(value = "An API for getting student data", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/student/{studentName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getStudent(@PathVariable(name = "studentName") String studentName) {

		log.info("GET http://localhost:8080/api/v1/student/{} is called", studentName);
		return studentService.getStudent(studentName);
	}

	@SneakyThrows(Exception.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieving data"),
			@ApiResponse(code = 201, message = "Successfully creating data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "There are errors which come from codes or data") })
	@ApiOperation(value = "An API for getting all students data", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getStudents() {

		log.info("GET http://localhost:8080/api/v1/students is called");
		return studentService.getStudents();
	}

	@SneakyThrows(Exception.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieving data"),
			@ApiResponse(code = 201, message = "Successfully creating data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "There are errors which come from codes or data") })
	@ApiOperation(value = "An API for updating student data", produces = MediaType.APPLICATION_JSON_VALUE)
	@PutMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateStudent(@RequestBody UpdateStudentDto dto) {

		log.info("PUT http://localhost:8080/api/v1/student is called...");
		return studentService.updateStudent(dto);
	}

	@SneakyThrows(Exception.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieving data"),
			@ApiResponse(code = 201, message = "Successfully creating data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "There are errors which come from codes or data") })
	@ApiOperation(value = "An API for deleting student data", produces = MediaType.APPLICATION_JSON_VALUE)
	@DeleteMapping(path = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteStudent(@PathVariable(name = "id") Long id) {

		log.info("DELETE http://localhost:8080/api/v1/student/{} is called", id);

		return studentService.deleteStudent(id);
	}
}
