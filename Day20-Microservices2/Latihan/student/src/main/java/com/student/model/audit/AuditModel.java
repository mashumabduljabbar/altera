package com.student.model.audit;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditModel<T> {

	@CreatedDate
	@Column(name = "CREATED_DATE", nullable = false, updatable = false)
	protected LocalDateTime createdDate;

	@LastModifiedDate
	@Column(name = "LASTMODIFIED_DATE", nullable = false)
	protected LocalDateTime lastModifiedDate;

}