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

    // 0:게스트 1:회원 2:관리자
    @Column(columnDefinition = "tinyint(1)")
    private int member = 0; // 멤버 등급

}
