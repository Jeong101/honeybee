package com.portfolio.honeybee.domain.post;

import java.io.*;
import java.net.URISyntaxException;
import java.util.List;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

//none
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
        AWSCredentials awsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        amazonS3 = new AmazonS3Client(awsCredentials);
    }

    public void uploadVideos(String savedName, String absolutePath) throws IllegalStateException, IOException {

        if (amazonS3 != null) {
            try {

                File video = new File(absolutePath + savedName);
                System.out.println(absolutePath + savedName);
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

    // 버킷에 있는 오브젝트리스트
    public List<S3ObjectSummary> showList() {
        System.out.format("Objects in S3 bucket %s:\n", BUCKET_NAME);
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("ap-northeast-2").build();
        ListObjectsV2Result result = s3.listObjectsV2(BUCKET_NAME);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        for (S3ObjectSummary os : objects) {
            System.out.println("* " + os.getKey());
        }
        return objects;
    }

}