package com.authenticate.authenticate.repository;

import com.authenticate.authenticate.entity.UserAuthe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserAuthe, String> {

    UserAuthe findByFace(String face);
//    List<UserAuthe> findAll();
}
