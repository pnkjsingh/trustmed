package com.trustMed.insuredServices.service;

import java.util.List;
import java.util.Optional;

import com.trustMed.insuredServices.entity.InsuredQuestionnaire;

public interface InsuredQuestionnaireService {
	
	InsuredQuestionnaire createInsuredQuestionnaire(InsuredQuestionnaire insuredQuestionnaire);
	
	public Optional<InsuredQuestionnaire> getInsuredById(int id);

	public List<InsuredQuestionnaire> getAllInsuredRecords();

	public Optional<InsuredQuestionnaire> updateInsuredRecord(int id, InsuredQuestionnaire insuredQuestionnaire);
	
	void deleteById(int id);

}