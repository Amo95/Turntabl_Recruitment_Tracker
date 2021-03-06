package com.turntablexe.turntabl.io.repository;

import com.turntablexe.turntabl.io.model.ApplicantDatamodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationDataRepository extends JpaRepository<ApplicantDatamodel, String> {

}
