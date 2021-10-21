package com.portfolio.honeybee.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String username; // 사용자이름
    @Column(nullable = false)
    private String email;

    private String nickname;

    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean member; // 멤버 등급

}
