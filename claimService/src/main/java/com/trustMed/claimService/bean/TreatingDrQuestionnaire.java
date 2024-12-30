//package com.trustMed.claimService.bean;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
//
//@Entity
//@Table(name = "treating_doctors_questionnaire")
//public class TreatingDrQuestionnaire {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int id;
//	
//    @OneToOne
//    @JoinColumn(name = "claim", referencedColumnName = "claim_number")
//    private Claim claim;
//    
//	@Column(name="high_blood_pressure")
//	boolean highBloodPressure;
//	@Column(name="hbp_since")
//	String hbpSince;
//	@Column(name="hbp_rx")
//	String hbpTreatment;
//	
//	@Column(name="diabetes_mellitus")
//	boolean diabetesMellitus;
//	@Column(name="dm_since")
//	String diabetesSince;
//	@Column(name="dn_rx")
//	String diabetesTreatment;
//	
//	@Column(name="chronic_heart_disease")
//	boolean heartDisease;
//	@Column(name="chronic_heart_disease_since")
//	String heartDiseaseSince;
//	@Column(name="chronic_heart_disease_rx")
//	String heartDiseaseTreatment;
//	
//	@Column(name="respiratory_illness")
//	boolean respiratoryIllness;
//	@Column(name="respiratory_illness_since")
//	String riSince;
//	@Column(name="respiratory_illness_rx")
//	String riTreatment;
//
//	@Column(name="thyroid_illness")
//	boolean thyroidIllness;
//	@Column(name="thyroid_illness_Since")
//	String thyroidIllnessSince;
//	@Column(name="thyroid_illness_treatment")
//	String thyroidIllnessTreatment;
//
//	@Column(name="neurological_illness")
//	boolean neurologicalIllness;
//	@Column(name="neurological_illness_since")
//	String neurologicalIllnessSince;
//	@Column(name="neurological_illness_treatment")
//	String neurologicalIllnessTreatment;
//	
//	@Column(name="cancer")
//	boolean cancer;
//	@Column(name="cancer_since")
//	String cancerSince;
//	@Column(name="cancer_treatment")
//	String cancerTreatment;
//	
//	@Column(name="ckd")
//	boolean ckd;
//	@Column(name="ckd_since")
//	String ckdSince;
//	@Column(name="ckd_treatment")
//	String ckdTreatment;
//
//	@Column(name="arthritis")
//	boolean arthritis;
//	@Column(name="arthritis_since")
//	String arthritisSince;
//	@Column(name="arthritis_treatment")
//	String arthritisTreatment;
//	
//	@Column(name="other_disease")
//	boolean otherdisease;
//	@Column(name="other_disease_since")
//	String otherdiseasesince;
//	@Column(name="other_disease_treatment")
//	String otherdiseasetreatment;
//	
//	@Column(name="date_time_of_admission")
////	@NotBlank(message = "Admission Date-Time is required")
//	String admissionDate;
//	@Column(name="date_time_of_discharge")
////	@NotBlank(message = "Discharge Date-Time is required")
//	String dischargeDate;
//
//	@Column(name="room_rent_per_day")
////	@NotBlank(message = "Room Rent is required")
//	int roomRentPerDay;
////	@NotBlank(message = "Type of room is required")
//	@Column(name="type_of_room")
//	String roomType;
//
//	@Column(name="payment_mode")
////	@NotBlank(message = "Payment Mode is required")
//	String paymentMode;
//	@Column(name="any_discount_on_hospital_bill")
////	@NotBlank(message = "discount field is required")
//	int HospitalBillDiscount;
//	@Column(name="total_hospital_bill")
////	@NotBlank(message = "Total Hospital Bill is required")
//	int totalHospitalBill;
//
//	@Column(name="Doctor_Name")
////	@NotBlank(message = "Doctor Name is required")
//	String doctorName;
//	@Column(name="questionnaire_date_time")
////	@NotBlank(message = "Questionnaire Date is required")
//	String questionnaireDate;
//	@Column(name="case_type")
//	String caseType;
//	public int getId() {
//		return id;
//	}
//	public Claim getClaim() {
//		return claim;
//	}
//	public boolean getHighBloodPressure() {
//		return highBloodPressure;
//	}
//	public String getHbpSince() {
//		return hbpSince;
//	}
//	public String getHbpTreatment() {
//		return hbpTreatment;
//	}
//	public boolean getDiabetesMellitus() {
//		return diabetesMellitus;
//	}
//	public String getDiabetesSince() {
//		return diabetesSince;
//	}
//	public String getDiabetesTreatment() {
//		return diabetesTreatment;
//	}
//	public boolean getHeartDisease() {
//		return heartDisease;
//	}
//	public String getHeartDiseaseSince() {
//		return heartDiseaseSince;
//	}
//	public String getHeartDiseaseTreatment() {
//		return heartDiseaseTreatment;
//	}
//	public boolean getRespiratoryIllness() {
//		return respiratoryIllness;
//	}
//	public String getRiSince() {
//		return riSince;
//	}
//	public String getRiTreatment() {
//		return riTreatment;
//	}
//	public boolean getThyroidIllness() {
//		return thyroidIllness;
//	}
//	public String getThyroidIllnessSince() {
//		return thyroidIllnessSince;
//	}
//	public String getThyroidIllnessTreatment() {
//		return thyroidIllnessTreatment;
//	}
//	public boolean getNeurologicalIllness() {
//		return neurologicalIllness;
//	}
//	public String getNeurologicalIllnessSince() {
//		return neurologicalIllnessSince;
//	}
//	public String getNeurologicalIllnessTreatment() {
//		return neurologicalIllnessTreatment;
//	}
//	public boolean getCancer() {
//		return cancer;
//	}
//	public String getCancerSince() {
//		return cancerSince;
//	}
//	public String getCancerTreatment() {
//		return cancerTreatment;
//	}
//	public boolean getCkd() {
//		return ckd;
//	}
//	public String getCkdSince() {
//		return ckdSince;
//	}
//	public String getCkdTreatment() {
//		return ckdTreatment;
//	}
//	public boolean getArthritis() {
//		return arthritis;
//	}
//	public String getArthritisSince() {
//		return arthritisSince;
//	}
//	public String getArthritisTreatment() {
//		return arthritisTreatment;
//	}
//	public boolean getOtherdisease() {
//		return otherdisease;
//	}
//	public String getOtherdiseasesince() {
//		return otherdiseasesince;
//	}
//	public String getOtherdiseasetreatment() {
//		return otherdiseasetreatment;
//	}
//	public String getAdmissionDate() {
//		return admissionDate;
//	}
//	public String getDischargeDate() {
//		return dischargeDate;
//	}
//	public int getRoomRentPerDay() {
//		return roomRentPerDay;
//	}
//	public String getRoomType() {
//		return roomType;
//	}
//	public String getPaymentMode() {
//		return paymentMode;
//	}
//	public int getHospitalBillDiscount() {
//		return HospitalBillDiscount;
//	}
//	public int getTotalHospitalBill() {
//		return totalHospitalBill;
//	}
//	public String getDoctorName() {
//		return doctorName;
//	}
//	public String getQuestionnaireDate() {
//		return questionnaireDate;
//	}
//	public String getCaseType() {
//		return caseType;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public void setClaim(Claim claim) {
//		this.claim = claim;
//	}
//	public void setHighBloodPressure(boolean highBloodPressure) {
//		this.highBloodPressure = highBloodPressure;
//	}
//	public void setHbpSince(String hbpSince) {
//		this.hbpSince = hbpSince;
//	}
//	public void setHbpTreatment(String hbpTreatment) {
//		this.hbpTreatment = hbpTreatment;
//	}
//	public void setDiabetesMellitus(boolean diabetesMellitus) {
//		this.diabetesMellitus = diabetesMellitus;
//	}
//	public void setDiabetesSince(String diabetesSince) {
//		this.diabetesSince = diabetesSince;
//	}
//	public void setDiabetesTreatment(String diabetesTreatment) {
//		this.diabetesTreatment = diabetesTreatment;
//	}
//	public void setHeartDisease(boolean heartDisease) {
//		this.heartDisease = heartDisease;
//	}
//	public void setHeartDiseaseSince(String heartDiseaseSince) {
//		this.heartDiseaseSince = heartDiseaseSince;
//	}
//	public void setHeartDiseaseTreatment(String heartDiseaseTreatment) {
//		this.heartDiseaseTreatment = heartDiseaseTreatment;
//	}
//	public void setRespiratoryIllness(boolean respiratoryIllness) {
//		this.respiratoryIllness = respiratoryIllness;
//	}
//	public void setRiSince(String riSince) {
//		this.riSince = riSince;
//	}
//	public void setRiTreatment(String riTreatment) {
//		this.riTreatment = riTreatment;
//	}
//	public void setThyroidIllness(boolean thyroidIllness) {
//		this.thyroidIllness = thyroidIllness;
//	}
//	public void setThyroidIllnessSince(String thyroidIllnessSince) {
//		this.thyroidIllnessSince = thyroidIllnessSince;
//	}
//	public void setThyroidIllnessTreatment(String thyroidIllnessTreatment) {
//		this.thyroidIllnessTreatment = thyroidIllnessTreatment;
//	}
//	public void setNeurologicalIllness(boolean neurologicalIllness) {
//		this.neurologicalIllness = neurologicalIllness;
//	}
//	public void setNeurologicalIllnessSince(String neurologicalIllnessSince) {
//		this.neurologicalIllnessSince = neurologicalIllnessSince;
//	}
//	public void setNeurologicalIllnessTreatment(String neurologicalIllnessTreatment) {
//		this.neurologicalIllnessTreatment = neurologicalIllnessTreatment;
//	}
//	public void setCancer(boolean cancer) {
//		this.cancer = cancer;
//	}
//	public void setCancerSince(String cancerSince) {
//		this.cancerSince = cancerSince;
//	}
//	public void setCancerTreatment(String cancerTreatment) {
//		this.cancerTreatment = cancerTreatment;
//	}
//	public void setCkd(boolean ckd) {
//		this.ckd = ckd;
//	}
//	public void setCkdSince(String ckdSince) {
//		this.ckdSince = ckdSince;
//	}
//	public void setCkdTreatment(String ckdTreatment) {
//		this.ckdTreatment = ckdTreatment;
//	}
//	public void setArthritis(boolean arthritis) {
//		this.arthritis = arthritis;
//	}
//	public void setArthritisSince(String arthritisSince) {
//		this.arthritisSince = arthritisSince;
//	}
//	public void setArthritisTreatment(String arthritisTreatment) {
//		this.arthritisTreatment = arthritisTreatment;
//	}
//	public void setOtherdisease(boolean otherdisease) {
//		this.otherdisease = otherdisease;
//	}
//	public void setOtherdiseasesince(String otherdiseasesince) {
//		this.otherdiseasesince = otherdiseasesince;
//	}
//	public void setOtherdiseasetreatment(String otherdiseasetreatment) {
//		this.otherdiseasetreatment = otherdiseasetreatment;
//	}
//	public void setAdmissionDate(String admissionDate) {
//		this.admissionDate = admissionDate;
//	}
//	public void setDischargeDate(String dischargeDate) {
//		this.dischargeDate = dischargeDate;
//	}
//	public void setRoomRentPerDay(int roomRentPerDay) {
//		this.roomRentPerDay = roomRentPerDay;
//	}
//	public void setRoomType(String roomType) {
//		this.roomType = roomType;
//	}
//	public void setPaymentMode(String paymentMode) {
//		this.paymentMode = paymentMode;
//	}
//	public void setHospitalBillDiscount(int hospitalBillDiscount) {
//		HospitalBillDiscount = hospitalBillDiscount;
//	}
//	public void setTotalHospitalBill(int totalHospitalBill) {
//		this.totalHospitalBill = totalHospitalBill;
//	}
//	public void setDoctorName(String doctorName) {
//		this.doctorName = doctorName;
//	}
//	public void setQuestionnaireDate(String questionnaireDate) {
//		this.questionnaireDate = questionnaireDate;
//	}
//	public void setCaseType(String caseType) {
//		this.caseType = caseType;
//	}
//	public TreatingDrQuestionnaire(int id, Claim claim,
//			boolean highBloodPressure, String hbpSince, String hbpTreatment, boolean diabetesMellitus,
//			String diabetesSince, String diabetesTreatment, boolean heartDisease, String heartDiseaseSince,
//			String heartDiseaseTreatment, boolean respiratoryIllness, String riSince, String riTreatment,
//			boolean thyroidIllness, String thyroidIllnessSince, String thyroidIllnessTreatment,
//			boolean neurologicalIllness, String neurologicalIllnessSince, String neurologicalIllnessTreatment,
//			boolean cancer, String cancerSince, String cancerTreatment, boolean ckd, String ckdSince,
//			String ckdTreatment, boolean arthritis, String arthritisSince, String arthritisTreatment,
//			boolean otherdisease, String otherdiseasesince, String otherdiseasetreatment, String admissionDate,
//			String dischargeDate, int roomRentPerDay, String roomType, String paymentMode, int hospitalBillDiscount,
//			int totalHospitalBill, @NotBlank(message = "Doctor Name is required") String doctorName,
//			@NotBlank(message = "Questionnaire Date is required") String questionnaireDate, String caseType) {
//		super();
//		this.id = id;
//		this.claim = claim;
//		this.highBloodPressure = highBloodPressure;
//		this.hbpSince = hbpSince;
//		this.hbpTreatment = hbpTreatment;
//		this.diabetesMellitus = diabetesMellitus;
//		this.diabetesSince = diabetesSince;
//		this.diabetesTreatment = diabetesTreatment;
//		this.heartDisease = heartDisease;
//		this.heartDiseaseSince = heartDiseaseSince;
//		this.heartDiseaseTreatment = heartDiseaseTreatment;
//		this.respiratoryIllness = respiratoryIllness;
//		this.riSince = riSince;
//		this.riTreatment = riTreatment;
//		this.thyroidIllness = thyroidIllness;
//		this.thyroidIllnessSince = thyroidIllnessSince;
//		this.thyroidIllnessTreatment = thyroidIllnessTreatment;
//		this.neurologicalIllness = neurologicalIllness;
//		this.neurologicalIllnessSince = neurologicalIllnessSince;
//		this.neurologicalIllnessTreatment = neurologicalIllnessTreatment;
//		this.cancer = cancer;
//		this.cancerSince = cancerSince;
//		this.cancerTreatment = cancerTreatment;
//		this.ckd = ckd;
//		this.ckdSince = ckdSince;
//		this.ckdTreatment = ckdTreatment;
//		this.arthritis = arthritis;
//		this.arthritisSince = arthritisSince;
//		this.arthritisTreatment = arthritisTreatment;
//		this.otherdisease = otherdisease;
//		this.otherdiseasesince = otherdiseasesince;
//		this.otherdiseasetreatment = otherdiseasetreatment;
//		this.admissionDate = admissionDate;
//		this.dischargeDate = dischargeDate;
//		this.roomRentPerDay = roomRentPerDay;
//		this.roomType = roomType;
//		this.paymentMode = paymentMode;
//		HospitalBillDiscount = hospitalBillDiscount;
//		this.totalHospitalBill = totalHospitalBill;
//		this.doctorName = doctorName;
//		this.questionnaireDate = questionnaireDate;
//		this.caseType = caseType;
//	}
//	
//	public TreatingDrQuestionnaire() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public TreatingDrQuestionnaire(int id, Claim claim2) {
//		// TODO Auto-generated constructor stub
//		this.id=id;
//		this.claim=claim2;
//	}
//	@Override
//	public String toString() {
//		return "TreatingDrQuestionnaire [id=" + id + ", claim=" + claim + ", highBloodPressure=" + highBloodPressure
//				+ ", hbpSince=" + hbpSince + ", hbpTreatment=" + hbpTreatment + ", diabetesMellitus=" + diabetesMellitus
//				+ ", diabetesSince=" + diabetesSince + ", diabetesTreatment=" + diabetesTreatment + ", heartDisease="
//				+ heartDisease + ", heartDiseaseSince=" + heartDiseaseSince + ", heartDiseaseTreatment="
//				+ heartDiseaseTreatment + ", respiratoryIllness=" + respiratoryIllness + ", riSince=" + riSince
//				+ ", riTreatment=" + riTreatment + ", thyroidIllness=" + thyroidIllness + ", thyroidIllnessSince="
//				+ thyroidIllnessSince + ", thyroidIllnessTreatment=" + thyroidIllnessTreatment
//				+ ", neurologicalIllness=" + neurologicalIllness + ", neurologicalIllnessSince="
//				+ neurologicalIllnessSince + ", neurologicalIllnessTreatment=" + neurologicalIllnessTreatment
//				+ ", cancer=" + cancer + ", cancerSince=" + cancerSince + ", cancerTreatment=" + cancerTreatment
//				+ ", ckd=" + ckd + ", ckdSince=" + ckdSince + ", ckdTreatment=" + ckdTreatment + ", arthritis="
//				+ arthritis + ", arthritisSince=" + arthritisSince + ", arthritisTreatment=" + arthritisTreatment
//				+ ", otherdisease=" + otherdisease + ", otherdiseasesince=" + otherdiseasesince
//				+ ", otherdiseasetreatment=" + otherdiseasetreatment + ", admissionDate=" + admissionDate
//				+ ", dischargeDate=" + dischargeDate + ", roomRentPerDay=" + roomRentPerDay + ", roomType=" + roomType
//				+ ", paymentMode=" + paymentMode + ", HospitalBillDiscount=" + HospitalBillDiscount
//				+ ", totalHospitalBill=" + totalHospitalBill + ", doctorName=" + doctorName + ", questionnaireDate="
//				+ questionnaireDate + ", caseType=" + caseType + "]";
//	}
//	
//}