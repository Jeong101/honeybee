package com.portfolio.honeybee.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE email= :email", nativeQuery = true)
    User mfindByEmail(String email);
}
