package com.authenticate.authenticate.service;

import com.authenticate.authenticate.dtos.UserDTO;
import com.authenticate.authenticate.entity.SiteKeep;
import com.authenticate.authenticate.entity.UserAuthe;
import com.authenticate.authenticate.repository.SiteRepository;
import com.authenticate.authenticate.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SiteService {
    @NonNull
    SiteRepository siteRepository;

    public Boolean addSite(final SiteKeep siteKeep) {
        SiteKeep site = siteRepository.save(siteKeep);
        if (site != null)
            return true;
        else
            return false;
    }

    public List<SiteKeep> findAllSites() {
        return siteRepository.findAll();
    }

}
