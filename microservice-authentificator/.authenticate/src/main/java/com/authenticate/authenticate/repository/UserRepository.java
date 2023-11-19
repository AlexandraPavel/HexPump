package com.authenticate.authenticate.repository;

import com.authenticate.authenticate.entity.UserAuthe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAuthe, String> {

    UserAuthe findByUsername(String username);
}
