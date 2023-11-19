package com.authenticate.authenticate.mapper;

import com.authenticate.authenticate.dtos.UserDTO;
import com.authenticate.authenticate.entity.UserAuthe;

public class UserMapper {

    public static UserDTO mapUserAutheToUserDTO(UserAuthe userAuthe) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(userAuthe.getId());
        userDTO.setFace(userAuthe.getFace());
        userDTO.setFingerprint(userAuthe.getFingerprint());
        userDTO.setSignature(userAuthe.getSignature());
        return userDTO;
    }
    public static UserAuthe mapUserDTOToUserAuthe(UserDTO userDTO) {
        UserAuthe userAuthe = new UserAuthe();
        userAuthe.setId(userDTO.getUserID());
        userAuthe.setFace(userDTO.getFace());
        userAuthe.setFingerprint(userDTO.getFingerprint());
        userAuthe.setSignature(userDTO.getSignature());
        return userAuthe;
    }

}
