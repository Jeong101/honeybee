package com.portfolio.honeybee.domain.post;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data

public class Video {

    private String email;
    private String username;
    private String title;

}
