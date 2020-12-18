package com.turntablexe.turntabl.io.service;


//import com.turntablexe.turntabl.io.model.ApplicantData;
import com.turntablexe.turntabl.io.model.Register;
//import com.turntablexe.turntabl.io.repository.ApplicantDataRepository;
import com.turntablexe.turntabl.io.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceHandler {

    @Autowired
    RegisterRepository registerRepository;

//    @Autowired
//    ApplicantDataRepository applicantDataRepository;

    public String registerUser(Register register){
        try {
            registerRepository.save(register);
        }catch (Exception ex){
            return "User already exist";
        }
    return "User created successfull";
    }

    public Register loginUser(Register register){
        Register register1 = new Register();
          registerRepository.findAll().stream().forEach(a->{
              Boolean bcrypt = BCrypt.checkpw(register.getPassword(),a.getPassword());
            if(a.getEmail().equals(register.getEmail()) && bcrypt ) {
                register1.setId(a.getId());
                register1.setEmail(a.getEmail());
                register1.setPassword(a.getPassword());
            }
        });

          return register1;
    }


//    public HttpStatus addApplicationForm(ApplicantData applicantData){
//        applicantDataRepository.save(applicantData);
//        return HttpStatus.valueOf(200);
//    }
//
//    public List<ApplicantData> getAllApplicants(){
//        return applicantDataRepository.findAll();
//    }
}
