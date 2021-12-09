package com.portfolio.honeybee.web;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class VideoController {

    @PostMapping("/upload")
    public String uploadVideo(MultipartFile video, String title) {
        S3uploader s3uploader = new S3uploader();

        try {
            File file = new File(video.getOriginalFilename());
            video.transferTo(file);
            s3uploader.uploadVideos(file, title);
        } catch (Exception exception) {
            System.out.println("=======Exception===========");
            System.out.println(exception.getMessage());
            return "redirect:/";
        }

        return "redirect:/";
    }
}
