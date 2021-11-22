package com.portfolio.honeybee.web;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.net.URL;

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
    public String uploadVideo(@PathVariable int id, MultipartFile video) {
        // String videoName = video.getOriginalFilename();

        try {
            URL videoURL = video.getResource().getURL();
            System.out.println("multipartFile : " + video + "================");
            // System.out.println("videoName : " + videoName + "================");
            System.out.println("videoURL : " + videoURL + "================");
        } catch (IOException exception) {
            System.out.println("videoType IOException occured");
        } catch (NullPointerException exception) {
            System.out.println("NullPointer Exception occured");
            return "redirect:/";
        }

        return "redirect:/";
    }
}
