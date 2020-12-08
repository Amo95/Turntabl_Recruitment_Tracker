package com.turntablexe.turntabl.io.controller;

import com.turntablexe.turntabl.io.model.Register;
import com.turntablexe.turntabl.io.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/turntablexe/users")
public class RegisterController {
    @Autowired
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    //get all available users
    @GetMapping("/allusers")
    public Iterable<Register> getAllUsers() {
        return registerService.getAllUsers();
    }

    //register a user
    @PostMapping("/register")
    public Register registerUsers(@RequestBody Register register) throws Exception {
        return registerService.registerUsers(new Register(register.getEmail(), register.getPassword()));

    }

    // delete a user
    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteUser(@PathVariable Integer id) {
        return registerService.deleteusers(id);
    }

    //user login
    @PostMapping("/login")
    public Register loginUsers(@RequestBody Register register) throws Exception {
        return registerService.loginUsers(register);
    }
}
