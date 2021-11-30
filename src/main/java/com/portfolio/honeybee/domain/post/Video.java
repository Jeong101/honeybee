package com.portfolio.honeybee.domain.post;

import java.io.File;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Video {
    private String email;
    private String username;
    private String title;
    private MultipartFile video;

}
