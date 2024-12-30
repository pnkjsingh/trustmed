package com.trustMed.claimService.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustMed.claimService.bean.Claim;
import com.trustMed.claimService.exception.NotFoundException;
import com.trustMed.claimService.feign.FamilyDoctorFeignClient;
import com.trustMed.claimService.feign.InsuredQuestionnaireFeignClient;
import com.trustMed.claimService.feign.TreatingDoctorFeignClient;
import com.trustMed.claimService.repository.ClaimRepository;
import com.trustMed.claimService.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	private ClaimRepository claimRepository;

	@Autowired
	public ClaimServiceImpl(ClaimRepository theClaimRepository) {
		claimRepository=theClaimRepository;
	}
	
	@Autowired
    private InsuredQuestionnaireFeignClient insuredQuestionnaireFeignClient;

    @Autowired
    private FamilyDoctorFeignClient familyDoctorFeignClient;
	
    @Autowired
    private TreatingDoctorFeignClient treatingDoctorFeignClient;

	@Override
	public Claim save(Claim claim) {
//		return claimRepository.save(claim);
		Claim savedClaim = claimRepository.save(claim);

		// Prepare the payload for InsuredQuestionnaireServices and FamilyDoctorQuestionnaireServices
		Map<String, String> payload = new HashMap<>();
		payload.put("claimNumber", savedClaim.getClaimNumber());

		// Call FamilyDoctorQuestionnaireServices
		try {
			familyDoctorFeignClient.createFamilyDoctorQuestionnaire(payload);
			System.out.println("Successfully called FamilyDoctorQuestionnaireService for claim: " + savedClaim.getClaimNumber());
		} catch (Exception e) {
			System.err.println("Error calling FamilyDoctorQuestionnaireService: " + e.getMessage());
		}
		// Call TreatingDoctorQuestionnaireServices
		try {
			treatingDoctorFeignClient.createTreatingDoctor(payload);
			System.out.println("Successfully called Treating DoctorQuestionnaireService for claim: " + savedClaim.getClaimNumber());
		} catch (Exception e) {
			System.err.println("Error calling TreatingDoctorQuestionnaireService: " + e.getMessage());
		}
		
		// Call InsuredQuestionnaireServices		
		try {
			insuredQuestionnaireFeignClient.createInsuredQuestionnaire(payload);
			System.out.println("Successfully called InsuredQuestionnaireService for claim: " + savedClaim.getClaimNumber());
		} catch (Exception e) {
		    System.err.println("Error calling InsuredQuestionnaireService: " + e.getMessage());
		}
		
		return savedClaim;
	}

	@Override
	public Optional<Claim> findByClaimNumber(String claimNumber) {
		Optional<Claim> result=claimRepository.findById(claimNumber);
//		if(result.isEmpty()) {
//			throw new NotFoundException("Claim Details not found with given claimNumber: "+claimNumber);
//		}
		return result;
	}

    @Override
	public List<Claim> findAll() {
		
		return claimRepository.findAll();
	}

	@Override
	public void deleteById(String claimNumber) {
		// TODO Auto-generated method stub
		Optional<Claim> result=claimRepository.findById(claimNumber);
		if(result.isPresent()) {
			claimRepository.deleteById(claimNumber);
		}else {
			throw new NotFoundException("Did not found given claimNumber: "+claimNumber);
		}
	}
}