package com.trustMed.reportService.entity;

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
@Table(name = "insured_questionnaire",	schema = "quizdb")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
	
public class InsuredQuestionnaire {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "claim_number")
    private String claimNumber;

    @Column(name = "hospital_name")
	private String hospitalName;
	
	@Column(name = "chief_complained_at_time_of_admission")
	private String chiefComplained;
	@Column(name = "exact_duration_of_complaints")
	private String complaintsDuration;
	
	@Column(name = "diagnosis_as_per_doctor")
	private String diagnosisAsPerDoctor;
	@Column(name = "tests_undergone_before/during_hospitalization")
	private String testsBeforeOrDuringHospitalization;
	
	@Column(name = "date_time_of_admission")
	private String admissionDateTime;
	@Column(name = "date_time_of_discharge")
	private String dischargeDateTime;
	
	@Column(name = "room_rent_per_day")
	private Float roomRentPerDay;
	@Column(name = "type_of_room")
	private String roomType;
	
	@Column(name = "identity_proof")
	private String identityProof;
	@Column(name = "estimated_hospital_bill")
	private Float estimatedHospitalBill;

	@Column(name = "high_blood_pressure")
	private Boolean highBloodPressure;
	@Column(name = "hbp_drug_name")
	private String hbpDrugName;
	@Column(name = "hbp_duration")
	private String hbpDuration;

	@Column(name = "diabetes_mellitus")
	private Boolean diabetesMellitus;
	@Column(name = "dm_drug_name")
	private String diabetesMellitusDrugName;
	@Column(name = "dm_duration")
	private String diabetesMellitusDuration;

	@Column(name = "any_heart_disease")
	private Boolean anyHeartDisease;
	@Column(name = "hd_drug_name")
	private String heartDiseaseDrugName;
	@Column(name = "hd_duration")
	private String heartDiseaseDuration;

	@Column(name = "any_liver_disease")
	private Boolean anyLiverDisease;
	@Column(name = "liver_disease_drug_name")
	private String liverDiseaseDrugName;
	@Column(name = "liver_disease_duration")
	private String liverDiseaseDuration;

	@Column(name = "any_kidney_disease")
	private Boolean kidneyDisease;
	@Column(name = "kidney_drug_name")
	private String kidneyDrugName;
	@Column(name = "kd_duration")
	private String kidneyDiseaseDuration;

	@Column(name = "neurological_disease")
	private Boolean neurologicalDisease;
	@Column(name = "neurological_disease_drug_name")
	private String neurologicalDiseaseDrugName;
	@Column(name = "neurological_disease_duration")
	private String neurologicalDiseaseDuration;

	@Column(name = "cancer")
	private Boolean cancer;
	@Column(name = "cancer_drug_name")
	private String cancerDrugName;
	@Column(name = "cancer_duration")
	private String cancerDuration;

	@Column(name = "respiratory_illness")
	private Boolean respiratoryIllness;
	@Column(name = "respiratory_illness_drug_name")
	private String respiratoryIllnessDrugName;
	@Column(name = "respiratory_illness_duration")
	private String respiratoryIllnessDuration;

	@Column(name = "arthritis")
	private Boolean arthritis;
	@Column(name = "arthritis_drug_name")
	private String arthritisDrugName;
	@Column(name = "arthritis_duration")
	private String arthritisDuration;

	@Column(name = "any_major_disease")
	private Boolean anyMajorDisease;
	@Column(name = "disease_drug_name")
	private String diseaseDrugName;
	@Column(name = "disease_duration")
	private String diseaseDuration;

	@Column(name = "job_details")
	private String jobDetails;
	@Column(name = "alcohol_smoking_tobacco")
	private String alcoholSmokingTobacco;
	@Column(name = "description")
	private String description;

	@Column(name = "questionnaire_date")
	private String questionnaireDate;
	

}