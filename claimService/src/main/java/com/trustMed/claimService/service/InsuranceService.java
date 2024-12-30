package com.trustMed.claimService.service;

import java.util.List;

import com.trustMed.claimService.bean.Insurance;

public interface InsuranceService {
	
	List<Insurance> getAllInsurance();
	Insurance createInsurance(Insurance insurance);
	public void deleteById(int id);
}
