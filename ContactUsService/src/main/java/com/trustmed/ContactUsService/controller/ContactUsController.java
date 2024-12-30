package com.trustmed.ContactUsService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trustmed.ContactUsService.entity.ContactUs;
import com.trustmed.ContactUsService.services.ContactUsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/contact")
public class ContactUsController {
	
	@Autowired
	private ContactUsService contactUsService;
	
	@PostMapping("/save")
	public ResponseEntity<ContactUs> saveContactUs(@RequestBody ContactUs contact){
		return ResponseEntity.status(HttpStatus.CREATED).body(contactUsService.saveUser(contact));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ContactUs>> getAllContact(){
		List<ContactUs> result=contactUsService.getAllContactRecords();
		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<ContactUs>> getById(@PathVariable String id){
		Optional<ContactUs> result=contactUsService.getContacteDetailsById(id);
		if(result.isPresent()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		Optional<ContactUs> result=contactUsService.getContacteDetailsById(id);
		if(result.isPresent()) {
			contactUsService.deleteContact(id);
			return ResponseEntity.ok("Deleted Contact:"+id);
		}
		return ResponseEntity.ofNullable("No contact details found of given Contact id:"+id);
		
	}	
}