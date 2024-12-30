package com.trustmed.DoctorQuestionnaireService.repositort;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trustmed.DoctorQuestionnaireService.model.FamilyDoctorQuestionnaire;

public interface FamilyDoctorRepository extends JpaRepository<FamilyDoctorQuestionnaire, Integer> {

}
