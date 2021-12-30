package com.portfolio.honeybee.domain.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "select * from post", nativeQuery = true)
    ArrayList<Post> postList();

    @Query(value = "select * from post where user_id = :id", nativeQuery = true)
    List<Post> userUpload(@Param("id") int id);

    @Query(value = "delete * from post where user_id = :id", nativeQuery = true)
    List<Post> deleteUserUpload(@Param("id") int id);
}
