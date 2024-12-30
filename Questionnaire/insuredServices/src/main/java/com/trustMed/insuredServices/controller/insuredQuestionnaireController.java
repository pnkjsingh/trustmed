package com.trustMed.insuredServices.controller;

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

import com.trustMed.insuredServices.entity.InsuredQuestionnaire;
import com.trustMed.insuredServices.exception.NotFoundException;
import com.trustMed.insuredServices.service.InsuredQuestionnaireService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("insured/questionnaire")
public class insuredQuestionnaireController {
	
	@Autowired
	private InsuredQuestionnaireService insuredQuestionnaireService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createinsuredQuestionnaire(@RequestBody InsuredQuestionnaire insuredQuestionnaire) {
		try {
			InsuredQuestionnaire savedQuestionnaire = insuredQuestionnaireService.createInsuredQuestionnaire(insuredQuestionnaire);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestionnaire);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating insured questionnaire: " + e.getMessage());
		}
	}

	@GetMapping("/allRecords")
	public ResponseEntity<List<InsuredQuestionnaire>> getAllInsuredRecords(){
		
		return ResponseEntity.ok(insuredQuestionnaireService.getAllInsuredRecords());
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<InsuredQuestionnaire>> getinsuredQuestionnaireById(@PathVariable int id){
		Optional<InsuredQuestionnaire> result=insuredQuestionnaireService.getInsuredById(id);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<InsuredQuestionnaire> updateinsuredQuestionnaire(@PathVariable int id, @RequestBody InsuredQuestionnaire insuredQuestionnaire){
		Optional<InsuredQuestionnaire> result= insuredQuestionnaireService.updateInsuredRecord(id, insuredQuestionnaire);
				
		return result.map(ResponseEntity::ok).orElseThrow(()->new NotFoundException("Record Not Found"));
		
	}

}