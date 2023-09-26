package com.bytebandits.hireharmonics.controller;

import com.bytebandits.hireharmonics.service.UploadCVService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;


@RestController
@RequestMapping("/api/upload")
public class UploadPdfController {

    private final S3Client s3Client;
    private final UploadCVService uploadCVService;

    public UploadPdfController(S3Client s3Client, UploadCVService uploadCVService) {
        this.s3Client = s3Client;
        this.uploadCVService = uploadCVService;
    }

    @PostMapping("/cv")
    public ResponseEntity<String> uploadCV(@RequestBody MultipartFile cv) throws Exception{
        uploadCVService.uploadCV(cv.getBytes());
        return ResponseEntity.ok("Upload success");
    }

}
