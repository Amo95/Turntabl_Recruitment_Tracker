package com.turntablexe.turntabl.io.controller;

import com.turntablexe.turntabl.io.model.ApplicantData;
import com.turntablexe.turntabl.io.repository.ApplicantDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turntablexe")
public class ApplicationForm {
    @Autowired
    ApplicantDataRepository applicantDataRepository;

    @PostMapping("/applicantdata")
    public HttpStatus handleApplicantData(@RequestBody ApplicantData applicantData){
        if(HttpStatus.ACCEPTED.is2xxSuccessful()){
           applicantDataRepository.save(applicantData);

           return HttpStatus.resolve(200);
        }else{
            return HttpStatus.BAD_REQUEST;
        }

    }
}
