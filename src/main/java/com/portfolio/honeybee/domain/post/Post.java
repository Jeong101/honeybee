package com.portfolio.honeybee.domain.post;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.portfolio.honeybee.domain.user.User;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // PK

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user; // FK

    @Column(nullable = false)
    private String videotitle;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp uploaddate;

    private String videonum;

}
