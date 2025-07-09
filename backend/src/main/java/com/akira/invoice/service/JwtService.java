package com.akira.invoice.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;


@Service
public class JwtService {
		private static final long EXPIRATION_MS = 86400000; // 1 day
		private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS265);

		public String generateToken(String username) {
				return Jwts.builder()
						.setSubject(username)
						.setIssueAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
						.signWith(Key)
						.compact();
		}

		public String extractUsername (String token) {
				return Jwts.parserBuilder().setSigningKey(key).build()
						.parseClaimsJws(token)
						.getBody()
						.getSubject();
		}

		public boolean validateToken(String token) {
				try {
						Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
						return true;
				} catch (JwtException e) {
						return false;
				}
		}
		
}
