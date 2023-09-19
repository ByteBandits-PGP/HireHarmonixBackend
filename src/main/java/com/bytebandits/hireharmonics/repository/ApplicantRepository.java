package com.bytebandits.hireharmonics.repository;

import com.bytebandits.hireharmonics.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicantRepository extends JpaRepository<Applicant, UUID> {
}
