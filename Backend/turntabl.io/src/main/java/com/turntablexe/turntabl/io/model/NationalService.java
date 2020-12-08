package com.turntablexe.turntabl.io.model;

import javax.persistence.*;

@Entity
public class NationalService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "service_status")
    private boolean service_status;

    @Column(name = "nss_number")
    private int nss_number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ApplicantData applicantData;

    public NationalService() {
    }

    public NationalService(int id, boolean service_status, int nss_number) {
        this.id = id;
        this.service_status = service_status;
        this.nss_number = nss_number;
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
