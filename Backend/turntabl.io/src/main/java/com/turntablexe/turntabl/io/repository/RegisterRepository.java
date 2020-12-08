package com.turntablexe.turntabl.io.repository;

import com.turntablexe.turntabl.io.model.Register;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RegisterRepository extends CrudRepository<Register, Integer> {
    Iterable<Register> findByid(Integer id);
    Optional<Register> findByEmail(String email);
}
