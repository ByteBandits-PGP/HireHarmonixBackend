package com.bytebandits.hireharmonics.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;

@Service
public class UploadCVService {

    private final String bucketName;
    private final S3Client s3Client;
    public UploadCVService(S3Client s3Client, @Value("s3.bucket.name") String bucketName) {
        this.s3Client= s3Client;
        this.bucketName= bucketName;
    }

    public void uploadCV() {

        System.out.println("Service uploadCV called");
    }
}
