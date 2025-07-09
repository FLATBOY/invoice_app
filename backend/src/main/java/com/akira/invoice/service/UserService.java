package com.akira.invoice.service;

import com.akira.invoice.entity.User;
import con.akira.invoice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.securiy.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
		@Autowired private UserRepository userRepo;
		@Autowired private PasswordEncoder passwordEncoder;

		public User register(String username, String password) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(passwordEncoder.encode(password));
				return userRepo.save(user);
		}

		@Override
		public UserDetails loadUserByUsername (String username) {
				User user = userRepo.findByUsername(username)
						.orElseThrow(() -> new UsernameNotFoundException("User not found"));
				return org.springframework.security.core.userdetails.User
						.withUsername(user.getUsername())
						.password(User.getPassword())
						.roles("USER")
						.build();
		}
}
