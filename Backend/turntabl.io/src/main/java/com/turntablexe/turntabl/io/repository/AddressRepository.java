package com.turntablexe.turntabl.io.repository;

import com.turntablexe.turntabl.io.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
