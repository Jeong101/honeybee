package com.portfolio.honeybee.domain.club;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.portfolio.honeybee.domain.user.User;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String clubName; // 동호회 명
    @Column(nullable = false)
    private int userID;

}
