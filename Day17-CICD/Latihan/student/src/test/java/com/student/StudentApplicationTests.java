package com.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.ulisesbocchio.jasyptspringboot.configuration.EnableEncryptablePropertiesConfiguration;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(EnableEncryptablePropertiesConfiguration.class)
class StudentApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCreateStudent() {

		Student student = new Student();

		student.setStudentName("Fajar Satriatna");
		student.setGender('M');
		student.setWeight(68.0);
		student.setHeight(165.0);
		student.setPhone("085704769156");
		student.setAddress("Jl. Tambak No.5 Jakarta");

		Student res = studentRepository.save(student);

		assertNotNull(res);
	}

	@Test
	public void testGetStudent() {

		Student res = studentRepository.findByStudentName("Fajar Satriatna");

		assertEquals("Fajar Satriatna", res.getStudentName().trim());
	}

	@Test
	public void testGetStudents() {

		List<Student> res = studentRepository.findAll();

		assertThat(res).size().isGreaterThan(0);
	}

	@Test
	public void testUpdateStudent() {

		Student student = studentRepository.findByStudentName("Fajar Satriatna");

		student.setStudentName("Jessica Mila");
		student.setGender('F');
		student.setWeight(40.0);
		student.setHeight(155.0);
		student.setPhone("085704769151");
		student.setAddress("Jl. Tambak No.15 Jakarta");

		Student res = studentRepository.save(student);

		assertEquals("Jessica Mila", res.getStudentName().trim());
	}

	@Test
	public void testDeleteStudent() {

		Student student = studentRepository.findByStudentName("Fajar Satriatna");

		studentRepository.delete(student);

		assertNull(studentRepository.findByStudentName("Fajar Satriatna"));
	}

}
