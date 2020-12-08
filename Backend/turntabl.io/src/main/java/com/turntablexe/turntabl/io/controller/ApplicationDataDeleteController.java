package com.turntablexe.turntabl.io.controller;

import com.turntablexe.turntabl.io.model.ApplicantData;
import com.turntablexe.turntabl.io.service.ApplicationDataDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/turntablexe/applicants")
public class ApplicationDataDeleteController {

    @Autowired
    private final ApplicationDataDeleteService applicationDataDeleteService;

    public ApplicationDataDeleteController(ApplicationDataDeleteService applicationDataDeleteService) {
        this.applicationDataDeleteService = applicationDataDeleteService;
    }

    // delete an applicant
    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteUser(@PathVariable Integer id){
        return applicationDataDeleteService.deleteApplicant(id);
    }
}
