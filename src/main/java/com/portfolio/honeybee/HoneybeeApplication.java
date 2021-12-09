package com.portfolio.honeybee;

import com.portfolio.honeybee.domain.post.S3uploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HoneybeeApplication {

	public static void main(String[] args) {
		S3uploader test = new S3uploader();
		test.uploadVideos();
		SpringApplication.run(HoneybeeApplication.class, args);
	}

}
