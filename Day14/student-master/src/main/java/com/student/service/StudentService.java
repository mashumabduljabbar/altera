package com.student.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.dto.StudentDto.CreateStudentDto;
import com.student.dto.StudentDto.UpdateStudentDto;
import com.student.model.Student;
import com.student.repository.StudentRepository;

import lombok.SneakyThrows;
import lombok.val;

@Service
@Transactional(rollbackOn = Exception.class)
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@SneakyThrows(Exception.class)
	public ResponseEntity<Object> createStudent(CreateStudentDto dto) {

		Map<String, Object> res = new HashMap<String, Object>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Student student = new Student();

		student.setStudentName(dto.getStudentName().trim());
		student.setGender(dto.getGender());
		student.setWeight(dto.getWeight());
		student.setHeight(dto.getHeight());
		student.setPhone(dto.getPhone().trim());
		student.setAddress(dto.getAddress().trim());

		studentRepository.save(student);

		res.put("code", HttpStatus.CREATED.value());
		res.put("message", "success");
		res.put("data", student);

		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
	}

	@SneakyThrows(Exception.class)
	public ResponseEntity<Object> getStudent(String studentName) {

		Map<String, Object> res = new HashMap<String, Object>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		val std = studentRepository.findByStudentName(studentName);

		if (Optional.ofNullable(std).isPresent()) {
			res.put("message", "success");
			res.put("data", std);
		} else {
			res.put("message", "failed");
			res.put("data", null);
		}

		res.put("code", HttpStatus.OK.value());

		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
	}

	@SneakyThrows(Exception.class)
	public ResponseEntity<Object> getStudents() {

		Map<String, Object> res = new HashMap<String, Object>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		val std = studentRepository.findAll();

		res.put("code", HttpStatus.OK.value());
		res.put("message", "success");
		res.put("data", std);

		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
	}

	@SneakyThrows(Exception.class)
	public ResponseEntity<Object> updateStudent(UpdateStudentDto dto) {

		Map<String, Object> res = new HashMap<String, Object>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		val student = studentRepository.findById(dto.getId()).orElse(null);

		if (Optional.ofNullable(student).isPresent()) {

			student.setStudentName(dto.getStudentName().trim());
			student.setGender(dto.getGender());
			student.setWeight(dto.getWeight());
			student.setHeight(dto.getHeight());
			student.setPhone(dto.getPhone().trim());
			student.setAddress(dto.getAddress().trim());

			studentRepository.save(student);

			res.put("message", "success");
			res.put("data", student);

		} else {
			res.put("message", "failed");
			res.put("data", null);
		}

		res.put("code", HttpStatus.OK.value());

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
	}

	@SneakyThrows(Exception.class)
	public ResponseEntity<Object> deleteStudent(Long id) {

		Map<String, Object> res = new HashMap<String, Object>();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		val student = studentRepository.findById(id).orElse(null);

		if (Optional.ofNullable(student).isPresent()) {

			studentRepository.deleteById(id);

			res.put("message", "success");
			res.put("data", student);

		} else {
			res.put("message", "failed");
			res.put("data", null);
		}

		res.put("code", HttpStatus.OK.value());

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
	}
}