package com.trustMed.familyDoctorQuestionnaire.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="family_doctor")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamilyDoctorQuestionnaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	int id;

	@Column(name = "claim_number")
    private String claimNumber;
	
	@Column(name="High_Blood_pressure")
	boolean highBloodPressure;
	@Column(name="HBP_Since")
	String hbpSince;
	@Column(name="HBP_Rx")
	String hbpRx;
	
	@Column(name="Diabetes Mellitus")
	boolean diabetesMellitus;
	@Column(name="DM_Since")
	String diabetesSince;
	@Column(name="DM_Rx")
	String diabetesRx;
	
	@Column(name="Any_Respiratory_illness")
	boolean respiratoryIllness;
	@Column(name="RI_Since")
	String riSince;
	@Column(name="Ri_Rx")
	String riRx;
	
	@Column(name="chronic heart disease/thyroid illness")
	boolean heartDisease;
	@Column(name="chronic_heart_disease_since")
	String heartDiseaseSince;
	@Column(name="chronic_heart_disease_rx")
	String heartDiseaseRx;
	
	@Column(name="Questionnaire_Date")
	String queDate;
	
	@Column(name="Doctor_Name")
	String doctorName;
	
}