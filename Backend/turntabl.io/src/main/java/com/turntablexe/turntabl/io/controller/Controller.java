package com.turntablexe.turntabl.io.controller;


//import com.turntablexe.turntabl.io.model.ApplicantData;
import com.turntablexe.turntabl.io.model.Register;
//import com.turntablexe.turntabl.io.repository.ApplicantDataRepository;
import com.turntablexe.turntabl.io.repository.RegisterRepository;
import com.turntablexe.turntabl.io.service.ServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3006"})
@RestController
@RequestMapping("/api/turntablexe")
public class Controller {

    @Autowired
    ServiceHandler serviceHandler;



//    @PostMapping("/applicantdata")
//    public HttpStatus handleApplicantData(@RequestBody ApplicantData applicantData){
//        return  serviceHandler.addApplicationForm(applicantData);
//    }
//
//    @GetMapping("/applicantdata")
//    public List<ApplicantData> getAllApplicants(){
//        return serviceHandler.getAllApplicants();
//    }

    @PostMapping("/register")
    public String registerUser(@RequestBody Register register){
            String psswd = BCrypt.hashpw(register.getPassword(),BCrypt.gensalt());
            register.setPassword(psswd);
            return  serviceHandler.registerUser(register);
    }

    @PostMapping("/login")
    public Register loginUser(@RequestBody Register register){
            return serviceHandler.loginUser(register);
    }


}
