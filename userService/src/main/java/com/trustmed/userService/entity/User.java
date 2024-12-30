package com.trustmed.userService.entity;

import com.trustmed.userService.enums.Active;
import com.trustmed.userService.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@Column(unique = true, nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	@Column(unique = true, nullable = false, updatable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Enumerated(EnumType.STRING)
	private Active active;
	
}