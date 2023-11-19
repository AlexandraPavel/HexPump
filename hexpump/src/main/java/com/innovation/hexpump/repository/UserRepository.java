package com.innovation.hexpump.repository;

import com.innovation.hexpump.entity.UserHexpump;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserHexpump, String> {

    UserHexpump findByUsername(String username);
}
