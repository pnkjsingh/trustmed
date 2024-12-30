package com.trustMed.claimService.bean;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Insurance")
public class Insurance {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id")
    private int insuranceId;

	@Column(name = "policy_number")
	private String policyNumber;

	@Column(name = "insurance_type")
	private String insuranceType;
    
	@NotNull
	@Column(name = "insured_name")
	private String insuredName;

	@NotNull
	@Column(name = "insurance_company")
	private String insuranceCompany;

	@NotNull
	@Column(name = "premium_amount")
	private double premiumAmount;

	@NotNull
	@Column(name="policy-date")
	private Date policyDate;

	// Define the one-to-many relationship with Claim
	@OneToMany(mappedBy = "insurance", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Claim> claims;

	public int getInsuranceId() {
		return insuranceId;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public String getInsuredName() {
		return insuredName;
	}
	
	public String getInsuranceType() {
		return insuranceType;
	}
	
	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public Date getPolicyDate() {
		return policyDate;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany=insuranceCompany;
	}
	
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public void setPolicyDate(Date policyDate) {
		this.policyDate = policyDate;
	}
	
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public Insurance() {
		super();
	}

	public Insurance(int insuranceId, String policyNumber, String insuranceType, String insuredName,
			String insuranceCompany, double premiumAmount, Date policyDate, List<Claim> claims) {
		super();
		this.insuranceId = insuranceId;
		this.policyNumber = policyNumber;
		this.insuranceType = insuranceType;
		this.insuredName = insuredName;
		this.insuranceCompany = insuranceCompany;
		this.premiumAmount = premiumAmount;
		this.policyDate = policyDate;
		this.claims = claims;
	}

	public Insurance(String policyNumber2, String insuranceType2, String insuredName2, String insuranceCompany2,
			double premiumAmount2, Date policyDate2) {
		super();
		this.policyNumber = policyNumber2;
		this.insuranceType = insuranceType2;
		this.insuredName = insuredName2;
		this.insuranceCompany = insuranceCompany2;
		this.premiumAmount = premiumAmount2;
		this.policyDate = policyDate2;		
	}

	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", policyNumber=" + policyNumber + ", insuranceType="
				+ insuranceType + ", insuredName=" + insuredName + ", insuranceCompany=" + insuranceCompany
				+ ", premiumAmount=" + premiumAmount + ", policyDate=" + policyDate + ", claims=" + claims + "]";
	}


}