package com.trustMed.reportService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trustMed.reportService.entity.InsuredQuestionnaire;

@Repository
public interface InsuredQuestionnaireRepository extends JpaRepository<InsuredQuestionnaire, Integer> {

}
