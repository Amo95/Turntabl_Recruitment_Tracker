package com.turntablexe.turntabl.io.repository;

import com.turntablexe.turntabl.io.model.ApplicantData;
import com.turntablexe.turntabl.io.model.Register;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Register,Integer> {
}
