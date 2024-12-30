package com.trustmed.DoctorQuestionnaireService.repositort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.trustmed.DoctorQuestionnaireService.model.TreatingDoctor;

@Service
public interface TreatingDoctorRepository extends JpaRepository<TreatingDoctor, Integer> {

}