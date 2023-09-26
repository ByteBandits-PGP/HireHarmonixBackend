package com.bytebandits.hireharmonics.service;

import com.bytebandits.hireharmonics.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {

    private UserService userService;
    private ApplicantRepository applicantRepository;

    public ApplicantService(UserService userService, ApplicantRepository applicantRepository) {
        this.userService = userService;
        this.applicantRepository = applicantRepository;
    }


}
