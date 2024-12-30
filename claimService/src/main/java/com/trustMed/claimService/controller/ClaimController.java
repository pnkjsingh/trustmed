package com.trustMed.claimService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustMed.claimService.bean.Claim;
import com.trustMed.claimService.bean.Insurance;
import com.trustMed.claimService.dto.InsuranceClaimDTO;
import com.trustMed.claimService.service.ClaimService;
import com.trustMed.claimService.service.InsuranceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/claims")
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	@Autowired
	private InsuranceService insuranceService;
	
	@PostMapping("/create")
	public ResponseEntity<?> addInsuranceClaim(@Valid @RequestBody InsuranceClaimDTO insuranceClaimDTO) {
		try {
			// Validation for non-empty fields
			if (insuranceClaimDTO.getPolicyNumber().isEmpty() || insuranceClaimDTO.getInsuredName().isEmpty() ||
				insuranceClaimDTO.getInsuranceCompany().isEmpty() || insuranceClaimDTO.getClaimNumber().isEmpty() ||
				insuranceClaimDTO.getClaimAmount() <= 0 || insuranceClaimDTO.getPremiumAmount() < 0 ||
				insuranceClaimDTO.getInsuranceType().equals("false") || insuranceClaimDTO.getInsuranceType().isEmpty()) {
					return new ResponseEntity<>("Check, some non-empty field is empty!", HttpStatus.BAD_REQUEST);
				}
			
			// Check if claim date is before policy date
			if (insuranceClaimDTO.getClaimDate().before(insuranceClaimDTO.getPolicyDate())) {
				return new ResponseEntity<>("Claim date can't be before Policy Date!", HttpStatus.BAD_REQUEST);
			}

			// Check for existing claim number
			Optional<Claim> existingClaim = claimService.findByClaimNumber(insuranceClaimDTO.getClaimNumber());
			if (existingClaim.isPresent()) {
				return new ResponseEntity<>("Claim with this claim number is already attached to another insurance.", HttpStatus.CONFLICT);
			}

			// Create and populate Insurance and Claim entities
			Insurance insurance = new Insurance();
			insurance.setPolicyNumber(insuranceClaimDTO.getPolicyNumber());
			insurance.setInsuranceType(insuranceClaimDTO.getInsuranceType());
			insurance.setInsuredName(insuranceClaimDTO.getInsuredName());
			insurance.setInsuranceCompany(insuranceClaimDTO.getInsuranceCompany());
			insurance.setPremiumAmount(insuranceClaimDTO.getPremiumAmount());
			insurance.setPolicyDate(insuranceClaimDTO.getPolicyDate());
			
			Claim claim = new Claim();
			claim.setClaimNumber(insuranceClaimDTO.getClaimNumber());
			claim.setClaimAmount(insuranceClaimDTO.getClaimAmount());
			claim.setClaimDate(insuranceClaimDTO.getClaimDate());
			claim.setAssignedTo(insuranceClaimDTO.getAssignedTo());
			claim.setInsurance(insurance);
			

            // Save entities
            insuranceService.createInsurance(insurance);
            claimService.save(claim);
            
            return new ResponseEntity<>("Insurance Claim added successfully!", HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	// GET API to fetch all claims
	@GetMapping("/getall")
	public ResponseEntity<List<Claim>> getAllClaims() {
		List<Claim> claims = claimService.findAll();
		
		if (claims.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(claims);
	}
	
	//Get API by Claim number
	@GetMapping("/get/{claimNumber}")
	public ResponseEntity<?> getByClaimNumber(@PathVariable String claimNumber){
		Optional<Claim> claim=claimService.findByClaimNumber(claimNumber);
		if(claim.isEmpty()) {
//			throw new NotFoundException("Claim Details not found with given claimNumber: "+claimNumber);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Claim with claim number " + claimNumber + " not found.");
		}
		return ResponseEntity.ok(claim);
	}
	//Delete claim by Claim number
	@DeleteMapping("/delete/{claimNumber}")
	public ResponseEntity<String> deleteByClaimNumber(@PathVariable String claimNumber){
//		Optional<Claim> claim=claimService.findByClaimNumber(claimNumber);
		
//		if(claim==null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Claim with claim number " + claimNumber + " not found.");
//		}
		claimService.deleteById(claimNumber);
		return ResponseEntity.ok("Claim Details with claim number \""+claimNumber+"\" deleted successfully.");
	}
}