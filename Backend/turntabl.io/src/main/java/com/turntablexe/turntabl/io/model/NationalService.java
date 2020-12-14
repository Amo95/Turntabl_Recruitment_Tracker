package com.turntablexe.turntabl.io.model;

import javax.persistence.*;

public class NationalService {
    private int id;

    private boolean service_status;

    private int nss_number;

    private ApplicantData applicantData;

    public NationalService() {
    }

    public NationalService(int id, boolean service_status, int nss_number, ApplicantData applicantData) {
        this.id = id;
        this.service_status = service_status;
        this.nss_number = nss_number;
        this.applicantData = applicantData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isService_status() {
        return service_status;
    }

    public void setService_status(boolean service_status) {
        this.service_status = service_status;
    }

    public int getNss_number() {
        return nss_number;
    }

    public void setNss_number(int nss_number) {
        this.nss_number = nss_number;
    }

    public ApplicantData getApplicantData() {
        return applicantData;
    }

    public void setApplicantData(ApplicantData applicantData) {
        this.applicantData = applicantData;
    }
}
