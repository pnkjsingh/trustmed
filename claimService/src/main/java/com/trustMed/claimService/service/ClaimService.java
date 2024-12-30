package com.trustMed.claimService.service;

import java.util.List;
import java.util.Optional;

import com.trustMed.claimService.bean.Claim;

public interface ClaimService {
	List<Claim> findAll();
	
	Claim  save(Claim claim);
	
	Optional<Claim> findByClaimNumber(String claimNumber);
	
	void deleteById(String id);
	
}
