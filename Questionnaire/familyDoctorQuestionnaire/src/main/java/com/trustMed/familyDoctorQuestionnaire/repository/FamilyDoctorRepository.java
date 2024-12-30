package com.trustMed.familyDoctorQuestionnaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trustMed.familyDoctorQuestionnaire.entity.FamilyDoctorQuestionnaire;

@Repository
public interface FamilyDoctorRepository extends JpaRepository<FamilyDoctorQuestionnaire, Integer> {

}
