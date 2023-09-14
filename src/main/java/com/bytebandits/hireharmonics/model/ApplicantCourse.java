package com.bytebandits.hireharmonics.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "applicant_courses")
public class ApplicantCourse {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "applied_data")
    private LocalDateTime appliedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "remarks")
    private String remarks;

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDateTime appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
