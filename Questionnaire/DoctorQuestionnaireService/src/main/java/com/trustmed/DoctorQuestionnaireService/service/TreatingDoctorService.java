package com.trustmed.DoctorQuestionnaireService.service;

import java.util.List;
import java.util.Optional;

import com.trustmed.DoctorQuestionnaireService.model.TreatingDoctor;

public interface TreatingDoctorService {

	public TreatingDoctor createTreatingDoctorRecord(TreatingDoctor treatingDoctor);

	public Optional<TreatingDoctor> getTreatingDoctorRecordById(int id);

	public Optional<TreatingDoctor> UpdateTreatingDoctorRecord(int id, TreatingDoctor doctor);

	public List<TreatingDoctor> getAllTreatingDoctorRecords();
}
