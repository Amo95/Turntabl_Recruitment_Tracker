package com.turntablexe.turntabl.io.model;


import javax.persistence.*;

@Entity
@Table(name="applicantdata",schema = "applicant")
public class ApplicantData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "first_name")
    private String first_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "dob")
    private String dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "university")
    private String university;

    @Column(name = "year_of_graduation")
    private String year_of_graduation;

    @Column(name = "cv")
    private String cv;

    @Column(name ="street_address_line1" )
    private String street_address_line1;

    @Column(name ="street_address_line2" )
    private String street_address_line2;

    @Column(name ="city" )
    private String city;

    @Column(name ="region" )
    private String region;

    @Column(name ="zip_code" )
    private String zip_code;

    @Column(name ="ssnit_status" )
    private boolean snnit_status;

    @Column(name ="snnit_number" )
    private String snnit_number;

    @Column(name ="service_status" )
    private boolean service_status;

    @Column(name ="nss_number" )
    private String nss_number;

    @Column(name ="phone_number" )
    private int phone_number;

    @Column(name ="whatSapp_number" )
    private int whatSapp_number;

    @Column(name ="referral_fullname" )
    private String referral_fullname;

    @OneToOne(targetEntity = Register.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "  id", referencedColumnName = "id")
    private Register register;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getStreet_address_line1() {
        return street_address_line1;
    }

    public void setStreet_address_line1(String street_address_line1) {
        this.street_address_line1 = street_address_line1;
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

    public boolean isSnnit_status() {
        return snnit_status;
    }

    public void setSnnit_status(boolean snnit_status) {
        this.snnit_status = snnit_status;
    }

    public String getSnnit_number() {
        return snnit_number;
    }

    public void setSnnit_number(String snnit_number) {
        this.snnit_number = snnit_number;
    }

    public boolean isService_status() {
        return service_status;
    }

    public void setService_status(boolean service_status) {
        this.service_status = service_status;
    }

    public String getNss_number() {
        return nss_number;
    }

    public void setNss_number(String nss_number) {
        this.nss_number = nss_number;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getWhatSapp_number() {
        return whatSapp_number;
    }

    public void setWhatSapp_number(int whatSapp_number) {
        this.whatSapp_number = whatSapp_number;
    }

    public String getReferral_fullname() {
        return referral_fullname;
    }

    public void setReferral_fullname(String referral_fullname) {
        this.referral_fullname = referral_fullname;
    }
}
