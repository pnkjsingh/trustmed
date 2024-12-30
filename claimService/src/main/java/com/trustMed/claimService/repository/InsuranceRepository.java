package com.trustMed.claimService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trustMed.claimService.bean.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

}
