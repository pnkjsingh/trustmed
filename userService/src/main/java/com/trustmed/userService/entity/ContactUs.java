package com.trustmed.userService.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Contact_Us")
public class ContactUs {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String subject;
	
	@Column
	private String message;
	
	@Column
	private String mob;
	
	@Column
	private String address;
	
	@Column(updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
}