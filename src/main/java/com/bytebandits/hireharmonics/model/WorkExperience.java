package com.bytebandits.hireharmonics.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "work_experience")
public class WorkExperience {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "title")
    private String title;
    @Column(name = "workplace")
    private String workplace;
    @Column(name = "yearsOfExperience")
    private String yearsOfExperience;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
