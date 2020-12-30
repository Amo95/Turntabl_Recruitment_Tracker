package com.turntablexe.turntabl.io.repository;



import com.turntablexe.turntabl.io.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RegistrationRepository extends JpaRepository<Register, Integer> {
    Optional<Register> findByEmail(String email);
    Register getByEmail(String email);
}
