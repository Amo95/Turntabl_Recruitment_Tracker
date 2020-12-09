package com.turntablexe.turntabl.io.controller;


import com.turntablexe.turntabl.io.model.Register;
import com.turntablexe.turntabl.io.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/turntablexe")
public class UserRegistrationController {
    @Autowired
    Repository repository;

    @PostMapping("/register")
    public HttpStatus registerUser(@RequestBody Register register){
        if(HttpStatus.ACCEPTED.is2xxSuccessful()){
            String psswd = BCrypt.hashpw(register.getPassword(),BCrypt.gensalt());
            register.setPassword(psswd);
            repository.save(register);
            return HttpStatus.resolve(200);
        }
        else
        {
            return HttpStatus.BAD_REQUEST;
        }

    }
    
}
