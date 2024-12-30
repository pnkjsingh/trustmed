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
import com.trustmed.DoctorQuestionnaireService.model.FamilyDoctorQuestionnaire;
import com.trustmed.DoctorQuestionnaireService.service.FamilyDoctorQuestionnaireService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("family/doctor/questionnaire")
public class FamilyDoctorQuestionnaireController {
	
	@Autowired
	FamilyDoctorQuestionnaireService familyDoctorService;
	
	@GetMapping("/allRecords")
	public ResponseEntity<List<FamilyDoctorQuestionnaire>> getAllFamilyDoctorRecords(){
		
		return ResponseEntity.ok(familyDoctorService.getAllFamilyDoctorRecord());
		
	}
	
	@PutMapping("/get/{id}")
	public ResponseEntity<Optional<FamilyDoctorQuestionnaire>> getAllFamilyDoctorRecord(@PathVariable int id){
		Optional<FamilyDoctorQuestionnaire> result=familyDoctorService.getFamilyDoctorRecordById(id);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<FamilyDoctorQuestionnaire> updatefamilyDoctor(@PathVariable int id, 
																	@RequestBody FamilyDoctorQuestionnaire familyDoctorQuestionnaire){
		Optional<FamilyDoctorQuestionnaire> result= familyDoctorService.updateFamilyDoctorRecord(id, familyDoctorQuestionnaire);

		return result.map(ResponseEntity::ok).orElseThrow(()->new NotFoundException("Record Not Found"));		
	}

}