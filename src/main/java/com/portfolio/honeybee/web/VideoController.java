package com.portfolio.honeybee.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.net.URL;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import com.portfolio.honeybee.domain.post.UploadVideo;
import com.portfolio.honeybee.domain.post.Video;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Builder.Default;

@RequiredArgsConstructor
@Controller
public class VideoController {

    @PostMapping("/upload")
    public String uploadVideo(@RequestParam("video") MultipartFile video) {
        // String videoName = video.getOriginalFilename();
        UploadVideo uploadVideo = new UploadVideo();
        System.out.println("str : " + video);
        try {
<<<<<<< HEAD

            // String path = "C:/Users/chox6/OneDrive/바탕 화면/climbing/test.mp4"; // 이거로 유튜브
            // 업로드 해보기
            File file = new File(path);
            // URL videoURL = nickname.getResource().getURL();
            // File file = new File(video.getTitle() + ".mp4");
            uploadVideo.testMethod(file);
            System.out.println("제목 : " + video.getTitle());

            // System.out.println("videoName : " + videoName + "================");
            // System.out.println("videoURL : " + videoURL + "================");
=======
            File convFile = multipartToFile(video);
            String path = "C:/Users/chox6/OneDrive/바탕 화면/climbing/test.mp4"; // 이거로 유튜브 업로드 해보기

            uploadVideo.testMethod(convFile);

>>>>>>> 679b5e244abca26e8bd1c4b60fc99e5f9ed01b18
            return "redirect:/";
        } catch (IOException exception) {
            System.out.println("videoType IOException occured");

            return "redirect:/";
        } catch (NullPointerException exception) {
            // System.out.println("제목 : " + video.getName());
            System.out.println("NullPointer Exception occured");
            return "redirect:/";
        }

    }

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File convFile = new File(multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }
}
