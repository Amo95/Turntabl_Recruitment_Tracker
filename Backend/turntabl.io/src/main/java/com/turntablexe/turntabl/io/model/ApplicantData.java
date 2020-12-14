package com.turntablexe.turntabl.io.model;


import javax.persistence.*;

@Entity
@Table(name = "applicantdata")
public class ApplicantData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Register register;


    public ApplicantData() {
    }

    public ApplicantData(int id, String first_name, String middle_name, String last_name, String nickname, String dob, String gender, String university, String year_of_graduation, String cv) {
        this.id = id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.dob = dob;
        this.gender = gender;
        this.university = university;
        this.year_of_graduation = year_of_graduation;
        this.cv = cv;
    }

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

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
}
