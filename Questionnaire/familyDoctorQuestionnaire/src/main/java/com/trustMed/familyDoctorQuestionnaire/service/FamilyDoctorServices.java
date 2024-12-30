package com.trustMed.familyDoctorQuestionnaire.service;

import java.util.List;
import java.util.Optional;

import com.trustMed.familyDoctorQuestionnaire.entity.FamilyDoctorQuestionnaire;

public interface FamilyDoctorServices {
	
	public List<FamilyDoctorQuestionnaire> getAllRecords();
	
	public FamilyDoctorQuestionnaire createFDoctorQuestionnaire(FamilyDoctorQuestionnaire doctorQuestionnaire);
	
	public Optional<FamilyDoctorQuestionnaire> updateFDoctorRecord(int id, FamilyDoctorQuestionnaire doctorQuestionnaire);
	
	public Optional<FamilyDoctorQuestionnaire> getRecordById(int id);
	
	public void deleteById(int id);	

}
