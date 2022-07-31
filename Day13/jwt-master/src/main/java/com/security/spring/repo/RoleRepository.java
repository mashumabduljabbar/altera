package com.security.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.spring.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByName(String name);
}
