package com.portfolio.honeybee.domain.club;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.portfolio.honeybee.domain.user.User;

import lombok.Data;

@Entity
@Data
public class Waiting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Club club;
}
