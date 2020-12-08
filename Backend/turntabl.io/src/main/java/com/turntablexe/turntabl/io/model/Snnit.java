package com.turntablexe.turntabl.io.model;

import javax.persistence.*;

@Entity
public class Snnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "snnit_status")
    private boolean snnit_status;

    @Column(name = "snnit_number")
    private int snnit_number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ApplicantData applicantData;

    public Snnit() {
    }


    public Snnit(int id, boolean snnit_status, int snnit_number) {
        this.id = id;
        this.snnit_status = snnit_status;
        this.snnit_number = snnit_number;
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
