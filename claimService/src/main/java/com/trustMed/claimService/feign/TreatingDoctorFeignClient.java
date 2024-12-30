package com.trustMed.claimService.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "DoctorQuestionnaireService", url = "http://localhost:8020")
@FeignClient(name = "DoctorQuestionnaireService")
public interface TreatingDoctorFeignClient {
	
	@PostMapping("/treating/dr/questionnaire/create")
	ResponseEntity<?> createTreatingDoctor(@RequestBody Map<String, String> payload);

}
