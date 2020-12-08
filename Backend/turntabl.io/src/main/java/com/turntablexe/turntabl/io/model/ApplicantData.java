package com.turntablexe.turntabl.io.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name= "ApplicationData")
public class ApplicantData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String email;

    private String first_name;

    private String middle_name;

    private String last_name;

    private String nickname;

    private String dob;

    private String gender;

    private String university;

    private String year_of_graduation;

    private String cv;


    public ApplicantData() {
    }

    public ApplicantData(int id, String email, String first_name, String middle_name, String last_name, String nickname, String dob, String gender, String university, String year_of_graduation, String cv) {
        this.id = id;
        this.email = email;
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

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicantData)) return false;
        ApplicantData that = (ApplicantData) o;
        return getId() == that.getId() &&
                getEmail().equals(that.getEmail()) &&
                getFirst_name().equals(that.getFirst_name()) &&
                getMiddle_name().equals(that.getMiddle_name()) &&
                getLast_name().equals(that.getLast_name()) &&
                getNickname().equals(that.getNickname()) &&
                getDob().equals(that.getDob()) &&
                getGender().equals(that.getGender()) &&
                getUniversity().equals(that.getUniversity()) &&
                getYear_of_graduation().equals(that.getYear_of_graduation()) &&
                getCv().equals(that.getCv());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getFirst_name(), getMiddle_name(), getLast_name(), getNickname(), getDob(), getGender(), getUniversity(), getYear_of_graduation(), getCv());
    }

    @Override
    public String toString() {
        return "ApplicantData{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", university='" + university + '\'' +
                ", year_of_graduation='" + year_of_graduation + '\'' +
                ", cv='" + cv + '\'' +
                '}';
    }
}
