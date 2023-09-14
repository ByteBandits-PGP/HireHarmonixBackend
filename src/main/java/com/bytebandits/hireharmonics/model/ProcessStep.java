package com.bytebandits.hireharmonics.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

public class ProcessStep {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    private int stepOrder;

    @ManyToOne(optional = false)
    @JoinColumn(name = "process_id")
    private InterviewProcess interviewProcess;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStepOrder() {
        return stepOrder;
    }

    public void setStepOrder(int stepOrder) {
        this.stepOrder = stepOrder;
    }

    public InterviewProcess getInterviewProcess() {
        return interviewProcess;
    }

    public void setInterviewProcess(InterviewProcess interviewProcess) {
        this.interviewProcess = interviewProcess;
    }

}
