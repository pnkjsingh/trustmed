package com.trustMed.familyDoctorQuestionnaire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustMed.familyDoctorQuestionnaire.entity.FamilyDoctorQuestionnaire;
import com.trustMed.familyDoctorQuestionnaire.exception.BadRequestException;
import com.trustMed.familyDoctorQuestionnaire.repository.FamilyDoctorRepository;

@Service
public class FamilyDoctorServicesImpl implements FamilyDoctorServices {

	private FamilyDoctorRepository familyDoctorRepository;
	
	@Autowired
	public FamilyDoctorServicesImpl(FamilyDoctorRepository theFamilyDoctorRepository) {
		familyDoctorRepository=theFamilyDoctorRepository;
	}
	
	@Override
	public FamilyDoctorQuestionnaire createFDoctorQuestionnaire(FamilyDoctorQuestionnaire doctorQuestionnaiore) {
		return familyDoctorRepository.save(doctorQuestionnaiore);
	}

	@Override
	public Optional<FamilyDoctorQuestionnaire> getRecordById(int id) {
		if(id<0) {
			throw new BadRequestException("Check id");
		}

		Optional<FamilyDoctorQuestionnaire> result= familyDoctorRepository.findById(id);
		
		if(result.isEmpty()) {
			throw new RuntimeException("No Record available for given doctor_Questionnaire Id: "+id);
		}
		return result;
	}

	@Override
	public Optional<FamilyDoctorQuestionnaire> updateFDoctorRecord(int id,	FamilyDoctorQuestionnaire doctorQuestionnaire) {
		
		Optional<FamilyDoctorQuestionnaire> result=	familyDoctorRepository.findById(id);
		if(result.isPresent()) {
			return result.map(familyDoctor->{
				familyDoctor.setId(doctorQuestionnaire.getId());
				familyDoctor.setClaimNumber(doctorQuestionnaire.getClaimNumber());
				familyDoctor.setDiabetesMellitus(doctorQuestionnaire.isDiabetesMellitus());
				familyDoctor.setDiabetesRx(doctorQuestionnaire.getDiabetesRx());
				familyDoctor.setDiabetesSince(doctorQuestionnaire.getDiabetesSince());
				familyDoctor.setDoctorName(doctorQuestionnaire.getDoctorName());
				familyDoctor.setHighBloodPressure(doctorQuestionnaire.isHighBloodPressure());
				familyDoctor.setHbpRx(doctorQuestionnaire.getHbpRx());
				familyDoctor.setHbpSince(doctorQuestionnaire.getHbpSince());
				familyDoctor.setHeartDisease(doctorQuestionnaire.isHeartDisease());
				familyDoctor.setQueDate(doctorQuestionnaire.getQueDate());
				familyDoctor.setRespiratoryIllness(doctorQuestionnaire.isRespiratoryIllness());
				familyDoctor.setRiRx(doctorQuestionnaire.getRiRx());
				familyDoctor.setRiSince(doctorQuestionnaire.getRiSince());
				return familyDoctorRepository.save(familyDoctor);
			});
		}
		return familyDoctorRepository.findById(id);
	}
	
	@Override
	public List<FamilyDoctorQuestionnaire> getAllRecords() {
		return familyDoctorRepository.findAll();
	}
	
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Optional<FamilyDoctorQuestionnaire> result=familyDoctorRepository.findById(id);
		if(result.isPresent()) {
			familyDoctorRepository.deleteById(id);
		}
		else {
			//Not found doctor Questionnaire detail of given doctor number
			throw new RuntimeException("did not found Family doctor Questionnaire id"+id);
			
		}
	}

}