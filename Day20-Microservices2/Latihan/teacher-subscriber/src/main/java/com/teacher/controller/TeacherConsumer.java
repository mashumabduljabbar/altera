package com.teacher.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.teacher.dto.TeacherDto;

@Component
public class TeacherConsumer {

	@RabbitListener(queues = "teacher_queue")
	public void listener(TeacherDto dto) {
		System.out.println(dto);
	}
}
