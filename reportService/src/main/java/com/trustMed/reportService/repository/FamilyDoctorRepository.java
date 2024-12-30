package com.trustMed.reportService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trustMed.reportService.entity.FamilyDoctorQuestionnaire;

@Repository
public interface FamilyDoctorRepository extends JpaRepository<FamilyDoctorQuestionnaire, Integer> {

}
