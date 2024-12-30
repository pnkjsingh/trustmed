package com.trustMed.claimService.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustMed.claimService.bean.Insurance;
import com.trustMed.claimService.repository.InsuranceRepository;
import com.trustMed.claimService.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService{
	
	@Autowired
	private InsuranceRepository insuranceRepository; 

	@Override
	public List<Insurance> getAllInsurance() {
		return insuranceRepository.findAll();
	}

	@Override
	public Insurance createInsurance(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}
	
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Optional<Insurance> result=insuranceRepository.findById(id);
		if(result.isPresent()) {
			insuranceRepository.deleteById(id);
		}else {
			throw new RuntimeException("Did not found given Insurance id: "+id);
		}
	}

}
