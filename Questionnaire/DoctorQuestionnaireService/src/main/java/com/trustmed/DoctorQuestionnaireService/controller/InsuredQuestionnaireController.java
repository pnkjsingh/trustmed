package com.trustmed.DoctorQuestionnaireService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trustmed.DoctorQuestionnaireService.exception.NotFoundException;
import com.trustmed.DoctorQuestionnaireService.model.InsuredQuestionnaire;
import com.trustmed.DoctorQuestionnaireService.service.InsuredQuestionnaireService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("insured/questionnaire")
public class InsuredQuestionnaireController {
	
	@Autowired
	InsuredQuestionnaireService insuredQuestionnaireService;
	
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