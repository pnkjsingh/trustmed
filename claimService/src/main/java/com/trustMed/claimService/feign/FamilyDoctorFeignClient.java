package com.trustMed.claimService.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "familyDoctorQuestionnaire", url = "http://localhost:8021")
@FeignClient(name = "familyDoctorQuestionnaire")
public interface FamilyDoctorFeignClient {

    @PostMapping("/family/doctor/questionnaire/create")
    ResponseEntity<?> createFamilyDoctorQuestionnaire(@RequestBody Map<String, String> payload);
    
}