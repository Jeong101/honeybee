package com.portfolio.honeybee.domain.user;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user WHERE email= :email", nativeQuery = true)
    User mfindByEmail(@Param("email") String email);

    @Query(value = "SELECT id FROM user WHERE email= :email", nativeQuery = true)
    int mfindIdByEmail(@Param("email") String email);

    @Query(value = "select * from user where member!=2", nativeQuery = true)
    ArrayList<User> userList();
}
