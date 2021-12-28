package com.portfolio.honeybee.domain.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "select * from post", nativeQuery = true)
    ArrayList<Post> postList();

    @Query(value = "select * from post where userid = :id", nativeQuery = true)
    List<Post> userUpload(int id);
}
