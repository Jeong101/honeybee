package com.portfolio.honeybee.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.portfolio.honeybee.domain.post.S3uploader;
import com.portfolio.honeybee.domain.post.UploadVideo;
import com.portfolio.honeybee.domain.post.Video;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class VideoController {

    @PostMapping("/upload")
    public String uploadVideo(@RequestParam("video") MultipartFile video, String title) {
        S3uploader s3uploader = new S3uploader();

        try {
            FileOutputStream fos = new FileOutputStream(
                    "c:/portfolio/honeybee/src/main/resources/static/temp/" + video.getOriginalFilename());
            // 파일 저장할 경로 + 파일명을 파라미터로 넣고 fileOutputStream 객체 생성하고
            InputStream is = video.getInputStream();

            // file로 부터 inputStream을 가져온다.

            int readCount = 0;
            byte[] buffer = new byte[1024 * 1024];
            // 파일을 읽을 크기 만큼의 buffer를 생성하고
            // ( 보통 1024, 2048, 4096, 8192 와 같이 배수 형식으로 버퍼의 크기를 잡는 것이 일반적이다.)

            while ((readCount = is.read(buffer)) != -1) {
                // 파일에서 가져온 fileInputStream을 설정한 크기 (1024byte) 만큼 읽고

                fos.write(buffer, 0, readCount);
                // 위에서 생성한 fileOutputStream 객체에 출력하기를 반복한다
            }

            // File file = s3uploader.convtoFile(video);

            // s3uploader.uploadVideos(file, title);
        } catch (Exception exception) {
            System.out.println("=======Exception===========");
            System.out.println(exception.getMessage());
            return "redirect:/";
        }

        return "redirect:/";
    }
}
