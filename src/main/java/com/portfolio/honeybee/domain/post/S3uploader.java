package com.portfolio.honeybee.domain.post;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Optional;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.portfolio.honeybee.HoneybeeApplication;
import com.portfolio.honeybee.web.VideoController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Service
@RequiredArgsConstructor
public class S3uploader {

    private String BUCKET_NAME;
    private String ACCESS_KEY;
    private String SECRET_KEY;
    private AmazonS3 amazonS3;

    public S3uploader(String BUCKET_NAME, String ACCESS_KEY, String SECRET_KEY) {
        this.BUCKET_NAME = BUCKET_NAME;
        this.ACCESS_KEY = ACCESS_KEY;
        this.SECRET_KEY = SECRET_KEY;
    }

    public S3uploader() {

        AWSCredentials awsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        amazonS3 = new AmazonS3Client(awsCredentials);
    }

    public void uploadVideos(File video, String title) throws IllegalStateException, IOException {
        if (amazonS3 != null) {
            try {

                File video = new File(absolutePath + savedName);

                PutObjectRequest putObjectRequest = new PutObjectRequest(
                        BUCKET_NAME /* + "/sub_dir_name" sub directory */, savedName, video);
                putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead); // file permission
                amazonS3.putObject(putObjectRequest); // upload file

            } catch (AmazonServiceException ase) {
                ase.printStackTrace();
            } finally {
                amazonS3 = null;
            }

        }

    }

    public File convtoFile(MultipartFile mFile) throws IllegalStateException,
            IOException, URISyntaxException {

        File file = new File("");

        mFile.transferTo(file);

        return file;
    }

}