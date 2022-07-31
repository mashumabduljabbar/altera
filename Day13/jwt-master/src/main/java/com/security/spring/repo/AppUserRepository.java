package com.security.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.spring.domain.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	public AppUser findByUsername(String username);
}
