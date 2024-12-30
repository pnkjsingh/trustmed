package com.trustMed.claimService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trustMed.claimService.bean.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, String> {

}
