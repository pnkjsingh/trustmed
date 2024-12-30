//package com.trustMed.claimService.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.trustMed.claimService.bean.TreatingDrQuestionnaire;
//import com.trustMed.claimService.repository.TreatingDrRepository;
//import com.trustMed.claimService.service.TreatingDrService;
//
//@Service
//public class TreatingDrServiceImpl implements TreatingDrService {
//	
//	private TreatingDrRepository drQuestionnaireRepository;
//	
//	@Autowired
//	public TreatingDrServiceImpl(TreatingDrRepository thedrQuestionnaireRepository) {
//		
//		drQuestionnaireRepository = thedrQuestionnaireRepository;
//	}
//
//	@Override
//	public List<TreatingDrQuestionnaire> findAll() {
//		return drQuestionnaireRepository.findAll();
//	}
//
//	@Override
//	public TreatingDrQuestionnaire save(TreatingDrQuestionnaire drQuestionnaire) {
//		
//		return drQuestionnaireRepository.save(drQuestionnaire);
//	}
//
//	@Override
//	public TreatingDrQuestionnaire findById(int id) {
//		Optional<TreatingDrQuestionnaire> result=drQuestionnaireRepository.findById(id);
//		TreatingDrQuestionnaire drQuestionnaire=null;
//		if(result.isPresent()) {
//			drQuestionnaire=result.get();
//		}
//		else {
//			throw new RuntimeException("Did not found given Doctor Questionnaire");
//		}
//		return drQuestionnaire;
//	}
//
//	@Override
//	public void deleteById(int id) {
//		Optional<TreatingDrQuestionnaire> result=drQuestionnaireRepository.findById(id);
//		if(result.isPresent()) {
//			drQuestionnaireRepository.deleteById(id);
//		}
//		else {
//			throw new RuntimeException("Did not found given Doctor Questionnaire");
//		}
//	}
//}