package com.trustmed.DoctorQuestionnaireService.repositort;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trustmed.DoctorQuestionnaireService.model.InsuredQuestionnaire;

public interface InsuredQuestionnaireRepository extends JpaRepository<InsuredQuestionnaire, Integer> {

}
