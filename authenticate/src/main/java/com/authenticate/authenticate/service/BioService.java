package com.authenticate.authenticate.service;

import com.authenticate.authenticate.dtos.RequestLoginDTO;
import com.authenticate.authenticate.entity.UserAuthe;
import com.authenticate.authenticate.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BioService {
    @NonNull
    UserRepository userRepository;
    public String matchFaceWithUser(String face) {
        UserAuthe user = userRepository.findByFace(face);
//        for (int i=0; i < users.size(); i++) {
//            if (users.get(i).getFace().compareTo(face) == 0)
//                return true;
//        }
        if (user != null)
            return user.getId();
        return null;

    }
}
