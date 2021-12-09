package com.portfolio.honeybee.domain.post;

import java.io.*;
import java.util.Optional;
import java.io.File;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.RequiredArgsConstructor;

public class S3uploader {
    private static final String BUCKET_NAME = "honeybee5sound";
    private static final String ACCESS_KEY = "AKIA3JQWYBM7BGXU52GT";
    private static final String SECRET_KEY = "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";
    private AmazonS3 amazonS3;

    public S3uploader() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        amazonS3 = new AmazonS3Client(awsCredentials);
    }

    public void uploadVideos(File video, String title) {
        File file = video;
        if (amazonS3 != null) {
            try {
                PutObjectRequest putObjectRequest = new PutObjectRequest(
                        BUCKET_NAME /* + "/sub_dir_name" sub directory */, title + ".mp4", file);
                putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead); // file permission
                amazonS3.putObject(putObjectRequest); // upload file

            } catch (AmazonServiceException ase) {
                ase.printStackTrace();
            } finally {
                amazonS3 = null;
            }

        }

    }
}