package com.trustMed.familyDoctorQuestionnaire.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustMed.familyDoctorQuestionnaire.entity.FamilyDoctorQuestionnaire;
import com.trustMed.familyDoctorQuestionnaire.exception.NotFoundException;
import com.trustMed.familyDoctorQuestionnaire.service.FamilyDoctorServices;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("family/doctor/questionnaire")
public class FamilyDoctorQuestionnaireController {

	@Autowired
	private FamilyDoctorServices doctorServices;
	
	@PostMapping("/create")
	public ResponseEntity<?> createinsuredQuestionnaire(@RequestBody FamilyDoctorQuestionnaire doctorQuestionnaire) {
		try {
			FamilyDoctorQuestionnaire savedQuestionnaire = doctorServices.createFDoctorQuestionnaire(doctorQuestionnaire);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestionnaire);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating insured questionnaire: " + e.getMessage());
		}
	}

	@GetMapping("/allRecords")
	public ResponseEntity<List<FamilyDoctorQuestionnaire>> getAllInsuredRecords(){
		
		return ResponseEntity.ok(doctorServices.getAllRecords());
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<FamilyDoctorQuestionnaire>> getinsuredQuestionnaireById(@PathVariable int id){
		Optional<FamilyDoctorQuestionnaire> result=doctorServices.getRecordById(id);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<FamilyDoctorQuestionnaire> updateinsuredQuestionnaire(@PathVariable int id, @RequestBody FamilyDoctorQuestionnaire doctorQuestionnaire){
		Optional<FamilyDoctorQuestionnaire> result= doctorServices.updateFDoctorRecord(id, doctorQuestionnaire);
				
		return result.map(ResponseEntity::ok).orElseThrow(()->new NotFoundException("Record Not Found"));
		
	}

}
