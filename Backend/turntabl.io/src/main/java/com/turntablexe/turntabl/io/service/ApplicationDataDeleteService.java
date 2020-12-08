package com.turntablexe.turntabl.io.service;

import com.turntablexe.turntabl.io.model.ApplicantData;
import com.turntablexe.turntabl.io.repository.ApplicationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
    public class ApplicationDataDeleteService {

    private final ApplicationDataRepository applicationDataRepository;
    @Autowired
    public ApplicationDataDeleteService(ApplicationDataRepository applicationDataRepository) {
        this.applicationDataRepository = applicationDataRepository;
    }


    public boolean deleteApplicant(Integer id) {
        Iterable<ApplicantData> existingApplication = applicationDataRepository.findByid(id);
        if (existingApplication != null) {
            applicationDataRepository.deleteById(id);
            return true;
        }
        return false;
    }
        }







