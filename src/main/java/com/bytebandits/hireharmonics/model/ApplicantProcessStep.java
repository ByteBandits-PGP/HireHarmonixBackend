package com.bytebandits.hireharmonics.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "applicant_process_step")
public class ApplicantProcessStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @OneToOne(optional = false)
    @JoinColumn(name = "process_step_id")
    private ProcessStep processStep;

    @Column(name = "taken_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime takenDate;

    private String status;
    private String remark;

    @Column(name = "done_by")
    private String doneBy;

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public ProcessStep getProcessStep() {
        return processStep;
    }

    public void setProcessStep(ProcessStep processStep) {
        this.processStep = processStep;
    }

    public LocalDateTime getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(LocalDateTime takenDate) {
        this.takenDate = takenDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }
}
