package com.turntablexe.turntabl.io.repository;

import com.turntablexe.turntabl.io.model.ApplicantData;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<ApplicantData,Integer> {
}
