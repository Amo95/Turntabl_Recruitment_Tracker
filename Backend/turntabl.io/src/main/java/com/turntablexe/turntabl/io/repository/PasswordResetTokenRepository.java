package com.turntablexe.turntabl.io.repository;

import com.turntablexe.turntabl.io.model.PasswordResetToken;
import com.turntablexe.turntabl.io.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
    PasswordResetToken findByToken(String token);
    PasswordResetToken findPasswordResetTokenByRegister(Register register);
}
