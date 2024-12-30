package com.trustMed.reportService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.trustMed.reportService.entity.TreatingDoctor;

@Service
public interface TreatingDoctorRepository extends JpaRepository<TreatingDoctor, Integer> {

}