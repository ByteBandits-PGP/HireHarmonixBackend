package com.bytebandits.hireharmonics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "work_experience")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "workplace")
    private String workplace;
    @Column(name = "yearsOfExperience")
    private String yearsOfExperience;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
