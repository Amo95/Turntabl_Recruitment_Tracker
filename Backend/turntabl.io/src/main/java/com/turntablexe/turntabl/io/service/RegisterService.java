package com.turntablexe.turntabl.io.service;
import com.turntablexe.turntabl.io.model.Register;
import com.turntablexe.turntabl.io.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final PasswordEncoder passwordEncoder;



    @Autowired
    public RegisterService(RegisterRepository registerRepository, PasswordEncoder passwordEncoder ) {
        this.registerRepository = registerRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Iterable<Register> getAllUsers() {
        return registerRepository.findAll();
    }

    public Register registerUsers(Register register) {
        System.out.println(register.toString());
        if (registerRepository.findByEmail(register.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User already exist with email");
        }
        Register createdUser = registerRepository.save(hashPassword(register));
        return createdUser;
    }

    private Register hashPassword(Register register) {
        //encode password
        register.setPassword(passwordEncoder.encode(register.getPassword()));
        return register;
    }

    public Register loginUsers(Register register) {

        Optional<Register> foundUser = registerRepository.findByEmail(register.getEmail());

        if (foundUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
        }

        // compare password
        if (!passwordEncoder.matches(register.getPassword(), foundUser.get().getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect credentials");
        }

        return foundUser.get();
    }


    public boolean deleteusers (Integer  id){
        Iterable<Register> existingUser=registerRepository.findByid(id);
        if(existingUser!=null){
            registerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
