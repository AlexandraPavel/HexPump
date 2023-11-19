package com.authenticate.authenticate.service;

import com.authenticate.authenticate.dtos.UserDTO;
import com.authenticate.authenticate.entity.UserAuthe;
import com.authenticate.authenticate.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    @NonNull
    UserRepository userRepository;

    public void validateUserAuthe(final UserDTO userDTO) {
        UserAuthe userAuthe = userRepository.findByUsername(userDTO.getUsername());
        System.out.println(userAuthe);
    }
}
