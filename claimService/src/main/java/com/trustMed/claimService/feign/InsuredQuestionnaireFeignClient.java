package com.trustMed.claimService.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "insured-questionnaire-service", url = "http://localhost:8019")
@FeignClient(name = "insuredServices")
public interface InsuredQuestionnaireFeignClient {

    @PostMapping("/insured/questionnaire/create")
    ResponseEntity<?> createInsuredQuestionnaire(@RequestBody Map<String, String> payload);
}
