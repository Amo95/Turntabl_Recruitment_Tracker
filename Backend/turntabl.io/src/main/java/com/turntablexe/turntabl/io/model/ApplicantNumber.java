package com.turntablexe.turntabl.io.model;

import javax.persistence.*;

public class ApplicantNumber {
    private int id;

    private int phone_number;

    private int whatsapp_number;

    private ApplicantData applicantData;

    public ApplicantNumber() {
    }

    public ApplicantNumber(int id, int phone_number, int whatsapp_number, ApplicantData applicantData) {
        this.id = id;
        this.phone_number = phone_number;
        this.whatsapp_number = whatsapp_number;
        this.applicantData = applicantData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getWhatsapp_number() {
        return whatsapp_number;
    }

    public void setWhatsapp_number(int whatsapp_number) {
        this.whatsapp_number = whatsapp_number;
    }

    public ApplicantData getApplicantData() {
        return applicantData;
    }

    public void setApplicantData(ApplicantData applicantData) {
        this.applicantData = applicantData;
    }
}
