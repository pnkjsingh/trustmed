package com.trustmed.DoctorQuestionnaireService.service;

import java.util.List;
import java.util.Optional;

import com.trustmed.DoctorQuestionnaireService.model.FamilyDoctorQuestionnaire;

public interface FamilyDoctorQuestionnaireService {
	
	public Optional<FamilyDoctorQuestionnaire> getFamilyDoctorRecordById(int id);

	public Optional<FamilyDoctorQuestionnaire> updateFamilyDoctorRecord(int id, FamilyDoctorQuestionnaire familyDoctor);

	public List<FamilyDoctorQuestionnaire> getAllFamilyDoctorRecord();

}
