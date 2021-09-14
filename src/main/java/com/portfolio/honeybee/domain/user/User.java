package com.portfolio.honeybee.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.portfolio.honeybee.domain.club.Club;

import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // PK

    private String email; // email
    private String name; // 이름

    @ManyToOne
    @JoinColumn(name = "clubId")
    private Club club; // FK
}
