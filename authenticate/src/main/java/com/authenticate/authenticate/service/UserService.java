package com.authenticate.authenticate.service;

import com.authenticate.authenticate.dtos.RequestLoginDTO;
import com.authenticate.authenticate.dtos.UserDTO;
import com.authenticate.authenticate.entity.SiteKeep;
import com.authenticate.authenticate.entity.UserAuthe;
import com.authenticate.authenticate.mapper.UserMapper;
import com.authenticate.authenticate.repository.UserRepository;
import com.sun.istack.NotNull;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    @NonNull
    UserRepository userRepository;

    @NonNull
    BioService bioService;

    @NonNull
    SiteService siteService;

    @Autowired
    RestTemplate restTemplate;

    public Boolean validateUserAuthe(final UserDTO userDTO) {
//        UserAuthe userAuthe = userRepository.findByUsername(userDTO.getUsername());
//        UserAuthe userAuthe = null;
//        System.out.println(userAuthe);
        return true;
    }

    public Boolean addUser(final UserDTO userDTO) {
        UserAuthe userAuthe = userRepository.save(UserMapper.mapUserDTOToUserAuthe(userDTO));
        System.out.println(userAuthe);
        if (userAuthe != null)
            return true;
        else
            return false;
    }

    public List<UserAuthe> findAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<String> redirectFromService(String userID) {
        // Assuming your Spring Boot app is running on localhost:8080
        String redirectUrl = "http://localhost:8080/login-validate"; // Redirect URL

        // Create a POST request to the /login-validate endpoint with userID in the body
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(redirectUrl, userID, String.class);

        // Process the response
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            // Successful redirection, handle the response
            String responseBody = responseEntity.getBody();
            return ResponseEntity.ok("Redirect successful. Response: " + responseBody);
        } else {
            // Redirect failed, handle accordingly
            return ResponseEntity.badRequest().body("Redirect failed. Status code: " + responseEntity.getStatusCodeValue());
        }
    }

    public Boolean validateUserBio(@RequestBody RequestLoginDTO requestDTO){
        System.out.println(requestDTO);
        String siteID = requestDTO.getSite();
        String bioType = requestDTO.getBioType();

        Boolean valdationFlag = false;

        String userIdFound = null;

        System.out.println(bioType);
        if (Objects.equals(bioType, "face" )) {
            userIdFound = bioService.matchFaceWithUser(requestDTO.getBio());
        }
        if (userIdFound != null) {
            siteService.addSite(new SiteKeep(userIdFound, requestDTO.getSite()));
            valdationFlag = true;
        }
        System.out.println("userIdfound" + userIdFound);
        return valdationFlag;
    }

}
