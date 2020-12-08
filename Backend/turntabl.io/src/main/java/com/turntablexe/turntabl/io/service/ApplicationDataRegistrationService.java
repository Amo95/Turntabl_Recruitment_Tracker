package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.ApplicantData;
import com.turntablexe.turntabl.io.repository.ApplicationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
public class ApplicationDataRegistrationService {
    @Autowired
    private final ApplicationDataRepository applicationDataRepository;

    @Autowired
    public ApplicationDataRegistrationService(ApplicationDataRepository applicationDataRepository) {
        this.applicationDataRepository = applicationDataRepository;

    }

    public ApplicantData registerApplicants(ApplicantData applicantData) {
        System.out.println(applicantData.toString());
        if (applicationDataRepository.findByEmail(applicantData.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User already exist with email");
        }
        ApplicantData createdApplicant = applicationDataRepository.save(applicantData);
        return createdApplicant;
    }
}