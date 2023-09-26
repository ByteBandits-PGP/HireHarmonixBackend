package com.bytebandits.hireharmonics.model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "applicants")
public class Applicant {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "skills")
    private String skills;
    @Column(name = "cv_link")
    private String cvLink;
    @Column(name = "location")
    private String location;
    @Column(name = "bootcamp")
    private String bootcamp;

    @Column(name = "work_experience")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<WorkExperience> workExperiences = new HashSet<>();

    @Column(name = "education")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Education> educations = new HashSet<>();
    @Column(name = "projects")
    private Set<Projects> projects = new HashSet<>();
    @Column(name = "language")
    private String language;
    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "applicant")
    private Set<ApplicantProcessStep> applicantProcessSteps = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCvLink() {
        return cvLink;
    }

    public void setCvLink(String cvLink) {
        this.cvLink = cvLink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ApplicantProcessStep> getApplicantProcessSteps() {
        return applicantProcessSteps;
    }

    public void setApplicantProcessSteps(Set<ApplicantProcessStep> applicantProcessSteps) {
        this.applicantProcessSteps = applicantProcessSteps;
    }
}
