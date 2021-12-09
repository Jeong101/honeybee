package com.portfolio.honeybee.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.portfolio.honeybee.domain.post.UploadVideo;
import com.portfolio.honeybee.domain.post.Video;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class VideoController {

    @PostMapping("/upload/{id}")
    public String uploadVideo(@PathVariable int id, Video video) {
        // String videoName = video.getOriginalFilename();
        UploadVideo uploadVideo = new UploadVideo();

        try {

            String path = "C:/Users/chox6/OneDrive/바탕 화면/climbing/test.mp4"; // 이거로 유튜브 업로드 해보기
            File file = new File(path);
            // URL videoURL = nickname.getResource().getURL();
            // File file = new File(video.getTitle() + ".mp4");
            uploadVideo.testMethod(file);
            System.out.println("제목 : " + video.getTitle());

            // System.out.println("videoName : " + videoName + "================");
            // System.out.println("videoURL : " + videoURL + "================");
            return "redirect:/";
            // } catch (IOException exception) {
            // System.out.println("videoType IOException occured");

            // return "redirect:/";
        } catch (NullPointerException exception) {
            System.out.println("NullPointer Exception occured");
            return "redirect:/";
        }

    }
}
