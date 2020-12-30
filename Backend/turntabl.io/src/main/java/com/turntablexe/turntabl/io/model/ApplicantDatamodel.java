package com.turntablexe.turntabl.io.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@Entity
@Table(name="applicantdata")
public class ApplicantDatamodel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String email;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "zip_code")
    private String zip_code;

    @Column(name = "getPhone_number")
    private String phone_number;

    @Column(name = "whatsapp_number")
    private String whatsApp_number;

    @Column(name = "nss_status")
    private boolean nss_status;

    @Column(name = "nss_number")
    private String nss_number;

    @Column(name = "ssnit_number")
    private String ssnit_number;

    @Column(name = "referral")
    private String referral;


    @Column(name = "dob")
    private String dob;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;
    @Column(name = "gender")
    private String gender;

    @Column(name = "university")
    private String university;

    @Column(name = "year_of_graduation")
    private String year_of_graduation;


    @Column(name = "cvFilename")
    private String cvFilename;

    @Column(name = "cvFileType")
    private String cvFiletype;


    @Column(name = "cv")
    private byte[] cv;

    @Column(name="file_directory", length=100)
    private String CvDirectory;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "register_id", referencedColumnName = "id")
    private Register register;


    public ApplicantDatamodel() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }


    public String getYear_of_graduation() {
        return year_of_graduation;
    }

    public void setYear_of_graduation(String year_of_graduation) {
        this.year_of_graduation = year_of_graduation;
    }


    public String getCvFiletype() {
        return cvFiletype;
    }

    public void setCvFiletype(String cv) {
        this.cvFiletype = cv;
    }


    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }


    public String getCvFilename() {
        return String.format("%s,%s-CV", this.first_name, this.last_name);
    }

    public void setCvFilename(String filename) {
        this.cvFilename = filename;
    }


    public String getCvDirectory() {
        return CvDirectory;
    }

    public void setCvDirectory(String fileDirectory) {
        this.CvDirectory = fileDirectory;
    }

    @Column(name = "cvFilePath", length = 500)
    public Path getFilePath() {
        if (cvFilename == null || cvFilename == null) {
            return null;
        }
        return Paths.get(CvDirectory, cvFilename);
    }


    public String getZip_code() {
        return zip_code;
    }


    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }


    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


    public String getWhatsApp_number() {
        return whatsApp_number;
    }

    public void setWhatsApp_number(String whatsApp_number) {
        this.whatsApp_number = whatsApp_number;
    }


    public boolean isNss_status() {
        return nss_status;
    }


    public void setNss_status(boolean nss_status) {
        this.nss_status = nss_status;
    }


    public String getNss_number() {
        return nss_number;
    }

    public void setNss_number(String nss_number) {
        this.nss_number = nss_number;
    }


    public String getSsnit_number() {
        return ssnit_number;
    }

    public void setSsnit_number(String ssnit_number) {
        this.ssnit_number = ssnit_number;
    }


    public String getReferral() {
        return referral;
    }


    public void setReferral(String referral) {
        this.referral = referral;
    }


    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void assignRegister(Register register){
        this.register = register;
        this.register.setApplicantDatamodel(this);
    }
}