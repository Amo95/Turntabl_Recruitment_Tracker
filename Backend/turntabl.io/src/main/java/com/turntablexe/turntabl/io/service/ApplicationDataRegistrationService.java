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
    public ApplicationDataRegistrationService(ApplicationDataRepository applicationDataRepository ) {
        this.applicationDataRepository = applicationDataRepository;

    }
    public ApplicationDataRepository registerApplicants(Register register) {
        return applicationDataRepository.save(register);
    }
}
