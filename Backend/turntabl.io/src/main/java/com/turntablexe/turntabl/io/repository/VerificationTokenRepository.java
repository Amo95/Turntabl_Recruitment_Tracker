package com.turntablexe.turntabl.io.repository;

import com.turntablexe.turntabl.io.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Integer> {
    Optional<VerificationToken> findByVerificationToken(String verificationToken);
    VerificationToken getByVerificationToken(String verificationToken);




}
