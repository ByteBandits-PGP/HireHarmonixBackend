package com.bytebandits.hireharmonics.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class UploadCVService {

    private final String bucketName;
    private final S3Client s3Client;
    public UploadCVService(S3Client s3Client, @Value("${s3.bucket.name}") String bucketName) {
        this.s3Client= s3Client;
        this.bucketName= bucketName;
    }

    public void uploadCV(byte[] cvBytes) {
        String folderName = "CV/";
        String key = folderName + System.currentTimeMillis()+".pdf";
        PutObjectRequest requst = PutObjectRequest.builder().bucket(bucketName).key(key).build();
        s3Client.putObject(requst, RequestBody.fromBytes(cvBytes));
        System.out.println("Service uploadCV called");
    }
}
