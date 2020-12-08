package com.turntablexe.turntabl.io.repository;

import com.turntablexe.turntabl.io.model.ApplicantData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ApplicationDataRepository extends CrudRepository<ApplicantData, Integer > {
     Iterable<ApplicantData> findByid(Integer id);
    Optional<ApplicantData> findByEmail(String email);

}
