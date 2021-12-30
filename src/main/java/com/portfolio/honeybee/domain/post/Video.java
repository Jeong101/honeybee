package com.portfolio.honeybee.domain.post;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class Video {
    private String videoID;
    private String nickname;

    public Video(String videoID, String nickname) {
        this.videoID = videoID;
        this.nickname = nickname;
    }

    public Video() {

    }
}
