package com.turntablexe.turntabl.io.controller;

import com.turntablexe.turntabl.io.exception.ResourceNotFoundException;
import com.turntablexe.turntabl.io.model.Address;
import com.turntablexe.turntabl.io.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ApplicantAddressController {

    @Autowired
    AddressRepository addressRepository;

//    all applicants addresses are fetched
    @GetMapping("/addresses")
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }
//    One applicant address is fetched
    @GetMapping("addresses/{id}")
    public ResponseEntity<Address> getApplicantAddress(@PathVariable(value = "id") Long addressId)
            throws ResourceNotFoundException {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicants not found for this id :: " + addressId));
        return ResponseEntity.ok().body(address);
    }

//    add addresses to address book
    @PostMapping("/resources")
    public Address addAddress(@Valid @RequestBody Address address){
        return addressRepository.save(address);
    }

//    Update applicant address
    @PutMapping()
    public ResponseEntity<Address> putApplicantAddress(@PathVariable(value = "id") Long addressId,
                                       @Valid @RequestBody Address addressDetail) throws ResourceNotFoundException {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + addressId));

        address.setId(addressDetail.getId());
        address.setApplicantData(addressDetail.getApplicantData());
        address.setStreet_address(addressDetail.getStreet_address());
        address.setStreet_address_line2(addressDetail.getStreet_address_line2());
        address.setRegion(addressDetail.getRegion());
        address.setCity(addressDetail.getCity());
        address.setZip_code(addressDetail.getZip_code());
        final Address updatedAddress = addressRepository.save(address);
        return ResponseEntity.ok(updatedAddress);
    }
}
