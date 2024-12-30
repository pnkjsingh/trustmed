package com.trustmed.DoctorQuestionnaireService.service;

import java.util.List;
import java.util.Optional;

import com.trustmed.DoctorQuestionnaireService.model.InsuredQuestionnaire;

public interface InsuredQuestionnaireService {


	public Optional<InsuredQuestionnaire> getInsuredById(int id);

	public List<InsuredQuestionnaire> getAllInsuredRecords();

	public Optional<InsuredQuestionnaire> updateInsuredRecord(int id, InsuredQuestionnaire insuredQuestionnaire);

}
