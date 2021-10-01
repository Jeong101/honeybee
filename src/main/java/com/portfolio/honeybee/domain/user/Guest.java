package com.portfolio.honeybee.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // PK

    private String email; // email
    private String name; // 이름

    @Column(nullable = false, columnDefinition = "boolean default 1")
    private boolean member; // 멤버 등급
}
