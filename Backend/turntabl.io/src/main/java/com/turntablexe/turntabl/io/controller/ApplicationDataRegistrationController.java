package com.turntablexe.turntabl.io.controller;


import com.turntablexe.turntabl.io.model.ApplicantData;
import com.turntablexe.turntabl.io.service.ApplicationDataRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/applicants")
public class ApplicationDataRegistrationController {
    @Autowired
    private final ApplicationDataRegistrationService applicationDataRegistrationService;

    public ApplicationDataRegistrationController(ApplicationDataRegistrationService applicationDataRegistrationService) {
        this.applicationDataRegistrationService = applicationDataRegistrationService;
    }

    //register an applicant
    @PostMapping("/register")
    public ApplicantData registerApplicant(@RequestBody ApplicantData applicantData) throws Exception {
        return applicationDataRegistrationService.registerApplicants(new ApplicantData(applicantData.getId(),applicantData.getEmail(),applicantData.getFirst_name(), applicantData.getMiddle_name(),applicantData.getLast_name(), applicantData.getNickname(),applicantData.getDob(),applicantData.getGender(),applicantData.getUniversity(),applicantData.getYear_of_graduation(),applicantData.getCv()));
    }

}
