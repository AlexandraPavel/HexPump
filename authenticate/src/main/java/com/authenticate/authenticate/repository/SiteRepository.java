package com.authenticate.authenticate.repository;

import com.authenticate.authenticate.entity.SiteKeep;
import com.authenticate.authenticate.entity.UserAuthe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiteRepository extends JpaRepository<SiteKeep, String> {

//    SiteKeep findBySiteId(String username);
    List<SiteKeep> findAll();
}
