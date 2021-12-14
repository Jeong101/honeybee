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
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

public class S3uploader {
    @Value("${cloud.aws.s3.bucket}")
    private static String BUCKET_NAME;
    @Value("${cloud.aws.credentials.accessKey}")
    private static String ACCESS_KEY;
    @Value("${cloud.aws.credentials.secretKey}")
    private static String SECRET_KEY;
    private AmazonS3 amazonS3;
    private String videoURL;

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