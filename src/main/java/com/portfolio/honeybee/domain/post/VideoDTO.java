package com.portfolio.honeybee.domain.post;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VideoDTO {
    // @NonNull
    private String videoID;
    // @NonNull
    private String nickname;

}
