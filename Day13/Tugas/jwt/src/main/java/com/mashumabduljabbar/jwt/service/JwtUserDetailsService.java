package com.mashumabduljabbar.jwt.service;

import com.mashumabduljabbar.jwt.model.UserDao;
import com.mashumabduljabbar.jwt.model.UserDto;
import com.mashumabduljabbar.jwt.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
		UserDao user = userDao.findByPhone(phone);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + phone);
		}
		return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(),
				new ArrayList<>());
	}

	public UserDao save(UserDto user) {
		UserDao newUser = new UserDao();
		newUser.setPhone(user.getPhone());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}
}