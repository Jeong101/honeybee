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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Configuration
@ConfigurationProperties(prefix = "aws")
public class S3uploader {

    private String BUCKET_NAME = "";
    private String ACCESS_KEY = "";
    private String SECRET_KEY = "";
    private AmazonS3 amazonS3;
    private String videoURL;

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
                // File file = video.transferTo(file);
                // videoURL = "https://honeybee5sound.s3.ap-northeast-2.amazonaws.com/" + title
                // + ".mp4";

                PutObjectRequest putObjectRequest = new PutObjectRequest(
                        BUCKET_NAME /* + "/sub_dir_name" sub directory */, title + ".mp4", video);
                putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead); // file permission
                amazonS3.putObject(putObjectRequest); // upload file
                Thread th = new Thread();
                // UploadVideo uv = new UploadVideo();
                // uv.testMethod(videoURL);
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