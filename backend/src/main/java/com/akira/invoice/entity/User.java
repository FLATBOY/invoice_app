package com.akira.invoice.entity;
import lombok.Data;
import jakarta.persistence.*;


@Entity
public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(unique = true)
		private String username;
		private String password;

		//Contructors
		public User(){}
		public User(String username, String password) {
				this.username = username;
				this.password = password;
		}

		//Getters & Setters
		public Long getId() {return id;}

		public String getUsername() {return username;}
		public void setUsername(String username) {this.username = username;}

		public String getPassword() {return password;}
		public void setPassword(String password) {this.password = password;}		
}
