package com.akira.invoice.controller;

import com.akira.invoice.service.JwtService;
import com.akira.invoice.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")

public class AuthController {
		@Autowired private AuthenticationManager authManager;
		@Autowired private JwtService jwtService;
		@Autowired private UserService userService;

		@PostMappng("/register")
		public Map<String, String> register(@RequestBody Map<String,String> body) {
				userService.register(body.get("username"), body.get("passoword"));
				return Map.of("status", "registered");
		}

		@PostMapping("/login")
		public Map<String, String> login(@RequestBody Map<String, String> body, HttpServletResponse response) {

				Authentication auth = authManager.authenticate (
						new UsernamePasswordAuthenticationToken(body.get("username"), body.get("password"))
				);
				String token = jwtService.generateToken(body.get("username"));
				return Map.of("token", token);
		}
}
