package com.portfolio.honeybee.domain.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RoadRunner implements ApplicationRunner {
    private static Logger logger = LoggerFactory.getLogger(RoadRunner.class);

    private final AwsKey ak;

    public RoadRunner(AwsKey ak) {
        this.ak = ak;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        S3uploader s3 = new S3uploader(ak.getBucket(), ak.getAccessKey(), ak.getSecretKey());
    }

}
