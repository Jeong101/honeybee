package com.portfolio.honeybee.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

    @Query(value = "SELECT * FROM user WHERE email= :email", nativeQuery = true)
    Guest mfindByEmail(String email);

    @Query(value = "SELECT id FROM user WHERE email= :email", nativeQuery = true)
    int mfindIdByEmail(String email);
}
