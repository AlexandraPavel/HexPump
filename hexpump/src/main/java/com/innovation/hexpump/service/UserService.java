package com.innovation.hexpump.service;

import com.innovation.hexpump.dtos.UserDTO;
import com.innovation.hexpump.entity.UserHexpump;
import com.innovation.hexpump.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    @NonNull
    UserRepository userRepository;

    public void validateUserHexpump(final UserDTO userDTO) {
        UserHexpump UserHexpump = userRepository.findByUsername(userDTO.getUsername());
        System.out.println(UserHexpump);
    }
}
