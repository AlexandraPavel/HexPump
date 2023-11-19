package com.authenticate.authenticate.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private String userID;
    private String face;
    private String fingerprint;
    private String signature;
}
