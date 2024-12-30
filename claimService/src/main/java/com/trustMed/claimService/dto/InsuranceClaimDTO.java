package com.trustMed.claimService.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsuranceClaimDTO {
	
	private String policyNumber;
	
	private String claimNumber;
	
	private String insuranceType;
	
	private String insuredName;
	
	private String insuranceCompany;
	
	private double premiumAmount;
	
	private double claimAmount;
	
	private Date claimDate;

	private Date policyDate;
	
	private String assignedTo;

}