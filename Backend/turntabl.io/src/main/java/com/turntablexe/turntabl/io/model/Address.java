package com.turntablexe.turntabl.io.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String street_address;

    private String street_address_line2;

    private String city;

    private String region;

    private String zip_code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ApplicantData applicantData;

    public Address() {
    }

    public Address(int id, String street_address, String street_address_line2, String city, String region, String zip_code, ApplicantData applicantData) {
        Id = id;
        this.street_address = street_address;
        this.street_address_line2 = street_address_line2;
        this.city = city;
        this.region = region;
        this.zip_code = zip_code;
        this.applicantData = applicantData;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getStreet_address_line2() {
        return street_address_line2;
    }

    public void setStreet_address_line2(String street_address_line2) {
        this.street_address_line2 = street_address_line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public ApplicantData getApplicantData() {
        return applicantData;
    }

    public void setApplicantData(ApplicantData applicantData) {
        this.applicantData = applicantData;
    }
}
