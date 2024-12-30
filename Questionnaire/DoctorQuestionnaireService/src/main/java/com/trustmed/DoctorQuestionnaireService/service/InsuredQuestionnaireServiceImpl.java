package com.trustmed.DoctorQuestionnaireService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustmed.DoctorQuestionnaireService.exception.NotFoundException;
import com.trustmed.DoctorQuestionnaireService.exception.BadRequestException;
import com.trustmed.DoctorQuestionnaireService.model.InsuredQuestionnaire;
import com.trustmed.DoctorQuestionnaireService.repositort.InsuredQuestionnaireRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuredQuestionnaireServiceImpl implements InsuredQuestionnaireService {
	
	@Autowired
	private InsuredQuestionnaireRepository insuredQuestionnaireRepository;

	@Override
	public Optional<InsuredQuestionnaire> getInsuredById(int id) {
		if(id<0) {
			throw new BadRequestException("Check id");
		}

		Optional<InsuredQuestionnaire> result= insuredQuestionnaireRepository.findById(id);
		
		if(result.isEmpty()) {
			throw new NotFoundException("No Record available for Id: "+id);
		}
		return result;
	}

	@Override
	public Optional<InsuredQuestionnaire> updateInsuredRecord(int id,
		InsuredQuestionnaire insuredQuestionnaire) {
		
		Optional<InsuredQuestionnaire> result=insuredQuestionnaireRepository.findById(id);
		if(result.isPresent()) {
			return result.map(insured->{
				
				insured.setAdmissionDateTime(insuredQuestionnaire.getAdmissionDateTime());
				insured.setAlcoholSmokingTobacco(insuredQuestionnaire.getAlcoholSmokingTobacco());
				
				insured.setAnyHeartDisease(insuredQuestionnaire.getAnyHeartDisease());
				insured.setHeartDiseaseDuration(insuredQuestionnaire.getHeartDiseaseDuration());
				insured.setHeartDiseaseDrugName(insuredQuestionnaire.getHeartDiseaseDrugName());
				
				insured.setAnyLiverDisease(insuredQuestionnaire.getAnyLiverDisease());
				insured.setLiverDiseaseDuration(insuredQuestionnaire.getLiverDiseaseDuration());
				insured.setLiverDiseaseDrugName(insuredQuestionnaire.getLiverDiseaseDrugName());
				
				insured.setAnyMajorDisease(insuredQuestionnaire.getAnyMajorDisease());
				insured.setDiseaseDuration(insuredQuestionnaire.getDiseaseDuration());
				insured.setDiseaseDrugName(insuredQuestionnaire.getDiseaseDrugName());
				
				insured.setArthritis(insuredQuestionnaire.getArthritis());
				insured.setArthritisDuration(insuredQuestionnaire.getArthritisDuration());
				insured.setArthritisDrugName(insuredQuestionnaire.getArthritisDrugName());
	
				insured.setCancer(insuredQuestionnaire.getCancer());
				insured.setCancerDuration(insuredQuestionnaire.getCancerDuration());
				insured.setCancerDrugName(insuredQuestionnaire.getCancerDrugName());

				insured.setChiefComplained(insuredQuestionnaire.getChiefComplained());
				insured.setComplaintsDuration(insuredQuestionnaire.getComplaintsDuration());
				insured.setDescription(insuredQuestionnaire.getDescription());
				insured.setDiabetesMellitus(insuredQuestionnaire.getDiabetesMellitus());
				insured.setDiabetesMellitusDuration(insuredQuestionnaire.getDiabetesMellitusDuration());
				insured.setDiabetesMellitusDrugName(insuredQuestionnaire.getDiabetesMellitusDrugName());
				insured.setDiagnosisAsPerDoctor(insuredQuestionnaire.getDiagnosisAsPerDoctor());
				
				insured.setDischargeDateTime(insuredQuestionnaire.getDischargeDateTime());
				insured.setEstimatedHospitalBill(insuredQuestionnaire.getEstimatedHospitalBill());				
				
				insured.setHighBloodPressure(insuredQuestionnaire.getHighBloodPressure());
				insured.setHbpDuration(insuredQuestionnaire.getHbpDuration());
				insured.setHbpDrugName(insuredQuestionnaire.getHbpDrugName());
				
				insured.setHospitalName(insuredQuestionnaire.getHospitalName());
				insured.setIdentityProof(insuredQuestionnaire.getIdentityProof());
				insured.setJobDetails(insuredQuestionnaire.getJobDetails());
				
				insured.setKidneyDisease(insuredQuestionnaire.getKidneyDisease());
				insured.setKidneyDiseaseDuration(insuredQuestionnaire.getKidneyDiseaseDuration());
				insured.setKidneyDrugName(insuredQuestionnaire.getKidneyDrugName());
				
				insured.setNeurologicalDisease(insuredQuestionnaire.getNeurologicalDisease());
				insured.setNeurologicalDiseaseDuration(insuredQuestionnaire.getNeurologicalDiseaseDuration());
				insured.setNeurologicalDiseaseDrugName(insuredQuestionnaire.getNeurologicalDiseaseDrugName());
				
				insured.setRespiratoryIllness(insuredQuestionnaire.getRespiratoryIllness());
				insured.setRespiratoryIllnessDuration(insuredQuestionnaire.getRespiratoryIllnessDuration());
				insured.setRespiratoryIllnessDrugName(insuredQuestionnaire.getRespiratoryIllnessDrugName());
				
				insured.setQuestionnaireDate(insuredQuestionnaire.getQuestionnaireDate());
				insured.setRoomRentPerDay(insuredQuestionnaire.getRoomRentPerDay());
				insured.setRoomType(insuredQuestionnaire.getRoomType());
				insured.setTestsBeforeOrDuringHospitalization(insuredQuestionnaire.getTestsBeforeOrDuringHospitalization());
				
				return insuredQuestionnaireRepository.save(insured);
			});
		}
		return insuredQuestionnaireRepository.findById(id);
	}

	@Override
	public List<InsuredQuestionnaire> getAllInsuredRecords() {
		List<InsuredQuestionnaire> result= insuredQuestionnaireRepository.findAll();
		if(result.isEmpty()) {
			throw new NotFoundException("No record found for Insured Questionnaire");
		}

		return result;
	}

}
