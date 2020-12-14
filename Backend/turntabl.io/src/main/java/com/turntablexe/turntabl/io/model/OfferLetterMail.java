package com.turntablexe.turntabl.io.model;

public class OfferLetterMail {
    private int id;
    private  String first_name;
    private String email;
    private String subject;
    private  String starting_date;
    private String salary;
    private  String first_salary_date;
    private  String first_salary_period;
    private String next_salary_date;
    private String next_salary_period;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(String starting_date) {
        this.starting_date = starting_date;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getFirst_salary_date() {
        return first_salary_date;
    }

    public void setFirst_salary_date(String first_salary_date) {
        this.first_salary_date = first_salary_date;
    }

    public String getFirst_salary_period() {
        return first_salary_period;
    }

    public void setFirst_salary_period(String first_salary_period) {
        this.first_salary_period = first_salary_period;
    }

    public String getNext_salary_date() {
        return next_salary_date;
    }

    public void setNext_salary_date(String next_salary_date) {
        this.next_salary_date = next_salary_date;
    }

    public String getNext_salary_period() {
        return next_salary_period;
    }

    public void setNext_salary_period(String next_salary_period) {
        this.next_salary_period = next_salary_period;
    }
}
