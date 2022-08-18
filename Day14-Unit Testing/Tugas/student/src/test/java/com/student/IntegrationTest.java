package com.student;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.dto.StudentDto.CreateStudentDto;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = StudentApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
@Slf4j
public class IntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Value("${spring.security.user.name}")
	private String username;

	@Value("${spring.security.user.password}")
	private String password;

	@Test
	public void testCreateStudent() throws Exception {

		CreateStudentDto dto = new CreateStudentDto();

		dto.setStudentName("Fajar Satriatna");
		dto.setGender('M');
		dto.setWeight(68.0);
		dto.setHeight(165.0);
		dto.setPhone("085704769156");
		dto.setAddress("Jl. Tambak No.5 Jakarta");

		MvcResult result = mvc
				.perform(post("/api/v1/student").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(dto))
						.with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password)))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.code", is(201))).andReturn();

		log.info("Create Student Header: " + result.getResponse().getHeaderNames());
		log.info("Create Student Body: " + result.getResponse().getContentAsString());
		log.info("Create Student Status: " + result.getResponse().getStatus());
	}
}
