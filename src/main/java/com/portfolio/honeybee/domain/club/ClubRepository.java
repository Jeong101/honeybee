package com.portfolio.honeybee.domain.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClubRepository extends JpaRepository<Club, Integer> {
    @Query(value = "SELECT * FROM club WHERE club_name= :clubName", nativeQuery = true)
    Club mfindByclubName(String clubName);
}
