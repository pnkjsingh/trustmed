package com.trustmed.DoctorQuestionnaireService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "treating_doctors_questionnaire")
public class TreatingDoctor {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "claim_number")
    private String claimNumber;

	@Column(name="high_blood_pressure")
	boolean highBloodPressure;
	@Column(name="hbp_since")
	String hbpSince;
	@Column(name="hbp_rx")
	String hbpTreatment;
	
	@Column(name="diabetes_mellitus")
	boolean diabetesMellitus;
	@Column(name="dm_since")
	String diabetesSince;
	@Column(name="dn_rx")
	String diabetesTreatment;
	
	@Column(name="chronic_heart_disease")
	boolean heartDisease;
	@Column(name="chronic_heart_disease_since")
	String heartDiseaseSince;
	@Column(name="chronic_heart_disease_rx")
	String heartDiseaseTreatment;
	
	@Column(name="respiratory_illness")
	boolean respiratoryIllness;
	@Column(name="respiratory_illness_since")
	String riSince;
	@Column(name="respiratory_illness_rx")
	String riTreatment;
	
	@Column(name="thyroid_illness")
	boolean thyroidIllness;
	@Column(name="thyroid_illness_Since")
	String thyroidIllnessSince;
	@Column(name="thyroid_illness_treatment")
	String thyroidIllnessTreatment;
	
	@Column(name="neurological_illness")
	boolean neurologicalIllness;
	@Column(name="neurological_illness_since")
	String neurologicalIllnessSince;
	@Column(name="neurological_illness_treatment")
	String neurologicalIllnessTreatment;
	
	@Column(name="cancer")
	boolean cancer;
	@Column(name="cancer_since")
	String cancerSince;
	@Column(name="cancer_treatment")
	String cancerTreatment;
	
	@Column(name="ckd")
	boolean ckd;
	@Column(name="ckd_since")
	String ckdSince;
	@Column(name="ckd_treatment")
	String ckdTreatment;
	
	@Column(name="arthritis")
	boolean arthritis;
	@Column(name="arthritis_since")
	String arthritisSince;
	@Column(name="arthritis_treatment")
	String arthritisTreatment;
	
	@Column(name="other_disease")
	boolean otherdisease;
	@Column(name="other_disease_since")
	String otherdiseasesince;
	@Column(name="other_disease_treatment")
	String otherdiseasetreatment;
	
	@Column(name="date_time_of_admission")
//	@NotBlank(message = "Admission Date-Time is required")
	String admissionDate;
	@Column(name="date_time_of_discharge")
//	@NotBlank(message = "Discharge Date-Time is required")
	String dischargeDate;
	
	@Column(name="room_rent_per_day")
//	@NotBlank(message = "Room Rent is required")
	int roomRentPerDay;
//	@NotBlank(message = "Type of room is required")
	@Column(name="type_of_room")
	String roomType;
	
	@Column(name="payment_mode")
//	@NotBlank(message = "Payment Mode is required")
	String paymentMode;
	@Column(name="any_discount_on_hospital_bill")
//	@NotBlank(message = "discount field is required")
	int HospitalBillDiscount;
	@Column(name="total_hospital_bill")
//	@NotBlank(message = "Total Hospital Bill is required")
	int totalHospitalBill;
	
	@Column(name="Doctor_Name")
//	@NotBlank(message = "Doctor Name is required")
	String doctorName;
	@Column(name="questionnaire_date_time")
//	@NotBlank(message = "Questionnaire Date is required")
	String questionnaireDate;
	@Column(name="case_type")
	String caseType;

}