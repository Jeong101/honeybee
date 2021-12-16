package com.portfolio.honeybee.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.portfolio.honeybee.domain.post.S3uploader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Service
@RequiredArgsConstructor
@Controller
public class VideoController {
    @Value("${file.absolutePath}")
    private String absolutePath;

    @Value("${cloud.aws.s3.bucket}")
    private String BUCKET_NAME;
    @Value("${cloud.aws.credentials.accessKey}")
    private String ACCESS_KEY;
    @Value("${cloud.aws.credentials.secretKey}")
    private String SECRET_KEY;

    // none
    @PostMapping("/upload")
    public String uploadVideo(@RequestParam("video") MultipartFile video, String title) {
        S3uploader s3uploader = new S3uploader(BUCKET_NAME, ACCESS_KEY, SECRET_KEY);

        try {
            String savedName = saveToTemp(video, title);
            s3uploader.uploadVideos(savedName, absolutePath);
            System.out.println(s3uploader.toString());
            System.out.println(s3uploader.toString());
            System.out.println(s3uploader.toString());
        } catch (Exception exception) {
            System.out.println("=======Exception===========");
            System.out.println(exception.getMessage());
            return "redirect:/";
        }

        return "redirect:/";
    }

    public String saveToTemp(MultipartFile video, String title) {
        String savedName = "";
        try {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
            String time = sdf.format(timestamp);

            FileOutputStream fos = new FileOutputStream(
                    absolutePath + title + "_" + time + ".mp4");
            // 파일 저장할 경로 + 파일명을 파라미터로 넣고 fileOutputStream 객체 생성하고
            InputStream is = video.getInputStream();

            // file로 부터 inputStream을 가져온다.
            savedName = title + "_" + time + ".mp4";
            int readCount = 0;
            byte[] buffer = new byte[1024 * 1024];
            // 파일을 읽을 크기 만큼의 buffer를 생성하고
            // ( 보통 1024, 2048, 4096, 8192 와 같이 배수 형식으로 버퍼의 크기를 잡는 것이 일반적이다.)

            while ((readCount = is.read(buffer)) != -1) {
                // 파일에서 가져온 fileInputStream을 설정한 크기 (1024byte) 만큼 읽고

                fos.write(buffer, 0, readCount);
                // 위에서 생성한 fileOutputStream 객체에 출력하기를 반복한다
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return savedName;
    }
}