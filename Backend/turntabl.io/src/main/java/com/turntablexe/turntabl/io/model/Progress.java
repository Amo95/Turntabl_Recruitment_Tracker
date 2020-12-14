package com.turntablexe.turntabl.io.model;


import javax.persistence.*;


public class Progress {
    private int id;


    private ApplicantData applicantData;

    private Stages stage_id;

    public Progress() {
    }

    public Progress(int id, ApplicantData applicantData, Stages stage_id) {
        this.id = id;
        this.applicantData = applicantData;
        this.stage_id = stage_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ApplicantData getApplicantData() {
        return applicantData;
    }

    public void setApplicantData(ApplicantData applicantData) {
        this.applicantData = applicantData;
    }

    public Stages getStage_id() {
        return stage_id;
    }

    public void setStage_id(Stages stage_id) {
        this.stage_id = stage_id;
    }
}
