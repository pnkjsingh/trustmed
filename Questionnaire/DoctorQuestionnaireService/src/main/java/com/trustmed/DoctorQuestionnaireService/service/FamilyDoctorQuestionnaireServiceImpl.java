package com.trustmed.DoctorQuestionnaireService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustmed.DoctorQuestionnaireService.exception.BadRequestException;
import com.trustmed.DoctorQuestionnaireService.exception.NotFoundException;
import com.trustmed.DoctorQuestionnaireService.model.FamilyDoctorQuestionnaire;
import com.trustmed.DoctorQuestionnaireService.repositort.FamilyDoctorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FamilyDoctorQuestionnaireServiceImpl implements FamilyDoctorQuestionnaireService {

	@Autowired
	private FamilyDoctorRepository familydoctorRepository;
	
	@Override
	public Optional<FamilyDoctorQuestionnaire> getFamilyDoctorRecordById(int id) {

		if(id<0) {
			throw new BadRequestException("Check id");
		}
		Optional<FamilyDoctorQuestionnaire> result=familydoctorRepository.findById(id);
		if(result.isEmpty()) {
			throw new NotFoundException("No Record Found for Id: "+id);
		}
		return result;
	}

	@Override
	public Optional<FamilyDoctorQuestionnaire> updateFamilyDoctorRecord(int id,
			FamilyDoctorQuestionnaire familyDoctor) {
		
		Optional<FamilyDoctorQuestionnaire> result=familydoctorRepository.findById(id);
		if(result.isPresent()) {
			return result.map(familyDoctorques->{
				familyDoctorques.setDiabetesMellitus(familyDoctor.isDiabetesMellitus());
				familyDoctorques.setDiabetesRx(familyDoctor.getDiabetesRx());
				familyDoctorques.setDiabetesSince(familyDoctor.getDiabetesSince());
				
				familyDoctorques.setDoctorName(familyDoctor.getDoctorName());
				
				familyDoctorques.setHeartDisease(familyDoctor.isHeartDisease());
				familyDoctorques.setHeartDiseaseRx(familyDoctor.getHeartDiseaseRx());
				familyDoctorques.setHeartDiseaseSince(familyDoctor.getHeartDiseaseSince());
				
				familyDoctorques.setHighBloodPressure(familyDoctor.isHighBloodPressure());
				familyDoctorques.setHighBloodPressureRx(familyDoctor.getHighBloodPressureRx());
				familyDoctorques.setHighBloodPressureSince(familyDoctor.getHighBloodPressureSince());
				
				familyDoctorques.setRespiratoryIllness(familyDoctor.isRespiratoryIllness());
				familyDoctorques.setRespiratoryIllnessSince(familyDoctor.getRespiratoryIllnessRx());
				familyDoctorques.setRespiratoryIllnessRx(familyDoctor.getRespiratoryIllnessSince());
				
				familyDoctorques.setQuestionnaireueDate(familyDoctor.getQuestionnaireueDate());
				
				return familydoctorRepository.save(familyDoctorques);
			});
		}
		return familydoctorRepository.findById(id);
	}

	@Override
	public List<FamilyDoctorQuestionnaire> getAllFamilyDoctorRecord() {
		
		List<FamilyDoctorQuestionnaire> list= familydoctorRepository.findAll();
		if(list.isEmpty())
			throw new NotFoundException("No record present for Family Doctor Doctor");
		return list; 
	}

}
