package com.authenticate.authenticate.dtos;

import lombok.Data;

@Data
public class BioDTO {
    private String face;
    private String fingerprint;
    private String signature;
}
