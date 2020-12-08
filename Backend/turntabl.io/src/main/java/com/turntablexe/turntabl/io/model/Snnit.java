package com.turntablexe.turntabl.io.model;

import javax.persistence.*;

@Entity
public class Snnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean snnit_status;

    private int snnit_number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ApplicantData applicantData;

    public Snnit() {
    }


    public Snnit(int id, boolean snnit_status, int snnit_number, ApplicantData applicantData) {
        this.id = id;
        this.snnit_status = snnit_status;
        this.snnit_number = snnit_number;
        this.applicantData = applicantData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSnnit_status() {
        return snnit_status;
    }

    public void setSnnit_status(boolean snnit_status) {
        this.snnit_status = snnit_status;
    }

    public int getSnnit_number() {
        return snnit_number;
    }

    public void setSnnit_number(int snnit_number) {
        this.snnit_number = snnit_number;
    }

    public ApplicantData getApplicantData() {
        return applicantData;
    }

    public void setApplicantData(ApplicantData applicantData) {
        this.applicantData = applicantData;
    }
}
