package com.trustMed.insuredServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trustMed.insuredServices.entity.InsuredQuestionnaire;

@Repository
public interface InsuredQuestionnaireRepository extends JpaRepository<InsuredQuestionnaire, Integer> {

}
