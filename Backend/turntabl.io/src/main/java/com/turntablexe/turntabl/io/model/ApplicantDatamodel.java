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

    private String first_name;

    private String middle_name;

    private String last_name;

    private String nickname;

    private LocalDate dob;

    private String gender;

    private String university;

    private String year_of_graduation;

    private String cvFilename;

    private String cvFiletype;

    private byte[] cv;

    private String CvDirectory;

    public ApplicantDatamodel() {
    }

    public ApplicantDatamodel(String id, String email, String first_name, String middle_name, String last_name, String nickname, LocalDate dob, String gender, String university,
                              String year_of_graduation, String cvFiletype, String cvFilename,
                              String CvDirectory) {
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
        this.cvFiletype = cvFiletype;
        this.cvFilename = cvFilename;
        this.CvDirectory = CvDirectory;
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

    @Column(name = "first_name")
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Column(name = "middle_name")
    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    @Column(name = "last_name")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Column(name = "dob")
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "university")
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Column(name = "year_of_graduation")
    public String getYear_of_graduation() {
        return year_of_graduation;
    }

    public void setYear_of_graduation(String year_of_graduation) {
        this.year_of_graduation = year_of_graduation;
    }

    @Column(name = "cvFileType")
    public String getCvFiletype() {
        return cvFiletype;
    }

    public void setCvFiletype(String cv) {
        this.cvFiletype = cv;
    }

    @Column(name = "cv")
    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    @Column(name = "cvFilename")
    public String getCvFilename() {
        return cvFilename;
    }

    public void setCvFilename(String filename) {
        this.cvFilename = filename;
    }

    @Column(name="file_directory", length=100)
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

//    @Override
//    public String toString() {
//        return "ApplicantData{" +
//                "id=" + id +
//                ", email='" + email + '\'' +
//                ", first_name='" + first_name + '\'' +
//                ", middle_name='" + middle_name + '\'' +
//                ", last_name='" + last_name + '\'' +
//                ", nickname='" + nickname + '\'' +
//                ", dob=" + dob +
//                ", gender='" + gender + '\'' +
//                ", university='" + university + '\'' +
//                ", year_of_graduation='" + year_of_graduation + '\'' +
//                ", cvFilename='" + cvFilename + '\'' +
//                ", cvFiletype='" + cvFiletype + '\'' +
//                ", cv=" + Arrays.toString(cv) +
//                '}';
//    }
}