package com.trustmed.DoctorQuestionnaireService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustmed.DoctorQuestionnaireService.model.TreatingDoctor;
import com.trustmed.DoctorQuestionnaireService.repositort.TreatingDoctorRepository;
import com.trustmed.DoctorQuestionnaireService.exception.NotFoundException;
import com.trustmed.DoctorQuestionnaireService.exception.BadRequestException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TreatingDoctorServiceImpl implements TreatingDoctorService {

	@Autowired
	TreatingDoctorRepository doctorRepository;
	
	public TreatingDoctor createTreatingDoctorRecord(TreatingDoctor treatingDoctor){
		
		return doctorRepository.save(treatingDoctor);
	}
	
	@Override
	public Optional<TreatingDoctor> getTreatingDoctorRecordById(int id) {
		if(id<0) {
			throw new BadRequestException("Check Id ");
		}
		Optional<TreatingDoctor> result= doctorRepository.findById(id);
		if(result.isEmpty()) {
			throw new NotFoundException("Record not Found with given id: "+id);
		}
		return result;
	}

	@Override
	public Optional<TreatingDoctor> UpdateTreatingDoctorRecord(int id, TreatingDoctor treatingDoctor) {
		Optional<TreatingDoctor> result= doctorRepository.findById(id);
		if(result.isPresent()) {
			return result.map(doctor->{
				doctor.setAdmissionDate(treatingDoctor.getAdmissionDate());
				doctor.setArthritis(treatingDoctor.isArthritis());
				doctor.setArthritisSince(treatingDoctor.getArthritisSince());
				doctor.setArthritisTreatment(treatingDoctor.getArthritisTreatment());
				doctor.setCancer(treatingDoctor.isArthritis());
				doctor.setCancerSince(treatingDoctor.getCancerSince());
				doctor.setCancerTreatment(treatingDoctor.getCancerTreatment());
				doctor.setCaseType(treatingDoctor.getCaseType());
				doctor.setCkd(treatingDoctor.isCkd());
				doctor.setCkdSince(treatingDoctor.getCkdSince());
				doctor.setCkdTreatment(treatingDoctor.getCkdTreatment());
				doctor.setDiabetesMellitus(treatingDoctor.isDiabetesMellitus());
				doctor.setDiabetesSince(treatingDoctor.getDiabetesSince());
				doctor.setDiabetesTreatment(treatingDoctor.getDiabetesTreatment());
				doctor.setDischargeDate(treatingDoctor.getDischargeDate());
				doctor.setDoctorName(treatingDoctor.getDoctorName());
				doctor.setHbpSince(treatingDoctor.getHbpSince());
				doctor.setHbpTreatment(treatingDoctor.getHbpTreatment());
				doctor.setHeartDisease(treatingDoctor.isHeartDisease());
				doctor.setHeartDiseaseSince(treatingDoctor.getHeartDiseaseSince());
				doctor.setHeartDiseaseTreatment(treatingDoctor.getHeartDiseaseTreatment());
				doctor.setHighBloodPressure(treatingDoctor.isHighBloodPressure());
				doctor.setHospitalBillDiscount(treatingDoctor.getHospitalBillDiscount());
				doctor.setNeurologicalIllness(treatingDoctor.isNeurologicalIllness());
				doctor.setNeurologicalIllnessSince(treatingDoctor.getNeurologicalIllnessSince());
				doctor.setNeurologicalIllnessTreatment(treatingDoctor.getNeurologicalIllnessTreatment());
				doctor.setOtherdisease(treatingDoctor.isOtherdisease());
				doctor.setOtherdiseasesince(treatingDoctor.getOtherdiseasesince());
				doctor.setOtherdiseasetreatment(treatingDoctor.getOtherdiseasetreatment());
				doctor.setPaymentMode(treatingDoctor.getPaymentMode());
				doctor.setQuestionnaireDate(treatingDoctor.getQuestionnaireDate());
				doctor.setRespiratoryIllness(treatingDoctor.isRespiratoryIllness());
				doctor.setRiSince(treatingDoctor.getRiSince());
				doctor.setRiTreatment(treatingDoctor.getRiTreatment());
				doctor.setRoomRentPerDay(treatingDoctor.getRoomRentPerDay());
				doctor.setRoomType(treatingDoctor.getRoomType());
				doctor.setThyroidIllness(treatingDoctor.isThyroidIllness());
				doctor.setThyroidIllnessSince(treatingDoctor.getThyroidIllnessSince());
				doctor.setThyroidIllnessTreatment(treatingDoctor.getThyroidIllnessTreatment());
				doctor.setTotalHospitalBill(treatingDoctor.getTotalHospitalBill());
				
				return doctorRepository.save(doctor);
				
			});
		}
		else {
			throw new NotFoundException("Record not found with Id: "+id);
		}
	}

	@Override
	public List<TreatingDoctor> getAllTreatingDoctorRecords() {
		 List<TreatingDoctor> result=doctorRepository.findAll();
		 if(result.isEmpty()) {
			 throw new NotFoundException(" Record not present");
		 }
		 return result;
	}

}