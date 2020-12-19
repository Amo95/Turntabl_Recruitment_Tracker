package com.turntablexe.turntabl.io.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "Student_Id",referencedColumnName = "id")
    private Student student;

    public Course() {
    }

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;

    }

    public void assignStudent(Student student){
        this.student = student;
        this.student.addCourse(this);
    }

}
