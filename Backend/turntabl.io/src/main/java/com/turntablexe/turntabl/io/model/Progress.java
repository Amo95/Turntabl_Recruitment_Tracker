package com.turntablexe.turntabl.io.model;


import javax.persistence.*;

@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ApplicantData applicantData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Stages stage_id;

    public Progress() {
    }

    public Progress(int id, Stages stage_id) {
        this.id = id;
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
