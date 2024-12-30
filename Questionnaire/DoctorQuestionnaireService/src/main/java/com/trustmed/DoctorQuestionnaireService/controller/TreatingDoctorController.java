package com.trustmed.DoctorQuestionnaireService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trustmed.DoctorQuestionnaireService.exception.NotFoundException;
import com.trustmed.DoctorQuestionnaireService.model.TreatingDoctor;
import com.trustmed.DoctorQuestionnaireService.service.TreatingDoctorService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("treating/dr/questionnaire")
public class TreatingDoctorController {
	
	@Autowired
	TreatingDoctorService doctorService;
	
	@PostMapping("/create")
	ResponseEntity<?> createTreatingDoctor(@RequestBody TreatingDoctor treatingDoctor){
//		Optional<TreatingDoctor> result= doctorService.createTreatingDoctorRecord(treatingDoctor);
		try {
			TreatingDoctor result =  doctorService.createTreatingDoctorRecord(treatingDoctor);
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating treating doctor questionnaire: " + e.getMessage());
		}
	}
	
	@GetMapping("/allRecords")
	public ResponseEntity<List<TreatingDoctor>> getAllTreatingDoctorRecords(){
		
		return ResponseEntity.ok(doctorService.getAllTreatingDoctorRecords());
		
	}
	
	@PutMapping("/get/{id}")
	public ResponseEntity<Optional<TreatingDoctor>> getTreatingDoctorById(@PathVariable int id){
		Optional<TreatingDoctor> result=doctorService.getTreatingDoctorRecordById(id);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<TreatingDoctor> updateTreatingDoctor(@PathVariable int id, @RequestBody TreatingDoctor treatingDoctor){
		Optional<TreatingDoctor> result= doctorService.UpdateTreatingDoctorRecord(id, treatingDoctor);
				
		return result.map(ResponseEntity::ok).orElseThrow(()->new NotFoundException("Record Not Found"));
		
	}

}
