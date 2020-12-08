package com.turntablexe.turntabl.io.controller;


import com.turntablexe.turntabl.io.exception.ResourceNotFoundException;
import com.turntablexe.turntabl.io.model.ApplicantData;
import com.turntablexe.turntabl.io.repository.ApplicationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/turntablexe/")
public class Controller {
    @Autowired
    private ApplicationDataRepository applicationDataRepository;

    @GetMapping("/applicants")
    public List<ApplicantData> getAllApplicant() {
        return applicationDataRepository.findAll();
    }

    @GetMapping("/applicants/{id}")
    public ResponseEntity<ApplicantData> getApplicantById(@PathVariable(value = "id") Long applicantId)
            throws ResourceNotFoundException {
        ApplicantData applicantData = applicationDataRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicants not found for this id :: " + applicantId));
        return ResponseEntity.ok().body(applicantData);
    }

    @PostMapping("/applicants")
    public ApplicantData createApplicant(@Valid @RequestBody ApplicantData applicant) {
        return applicationDataRepository.save(applicant);
    }

    @PutMapping("/applicants/{id}")
    public ResponseEntity<ApplicantData> updateApplicant(@PathVariable(value = "id") Long applicantId,
                                                   @Valid @RequestBody ApplicantData applicantDetails) throws ResourceNotFoundException {
        ApplicantData applicantData = applicationDataRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));

        applicantData.setEmail((applicantDetails.getEmail()));
        applicantData.setLast_name(applicantDetails.getLast_name());
        applicantData.setFirst_name(applicantDetails.getFirst_name());
        final ApplicantData updatedApplicant = applicationDataRepository.save(applicantData);
        return ResponseEntity.ok(updatedApplicant);
    }

    @DeleteMapping("/applicants/{id}")
    public Map<String, Boolean> deleteApplicants(@PathVariable(value = "id") Long applicantId)
            throws ResourceNotFoundException {
        ApplicantData applicant = applicationDataRepository.findById(applicantId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));

        applicationDataRepository.delete(applicant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
