package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class StudentDto {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CreateStudentDto {

		private String studentName;
		private Character gender;
		private Double height;
		private Double weight;
		private String phone;
		private String address;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class UpdateStudentDto {

		private Long id;
		private String studentName;
		private Character gender;
		private Double height;
		private Double weight;
		private String phone;
		private String address;
	}
}
