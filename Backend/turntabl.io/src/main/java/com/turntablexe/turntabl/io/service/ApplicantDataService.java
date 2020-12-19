package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.ApplicantDatamodel;
import com.turntablexe.turntabl.io.repository.ApplicationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantDataService {
    @Autowired
    ApplicationDataRepository applicationDataRepository;

    public ApplicantDatamodel saveApplicantData (ApplicantDatamodel applicantDatamodel){
        return  applicationDataRepository.save(applicantDatamodel);
    }
}
