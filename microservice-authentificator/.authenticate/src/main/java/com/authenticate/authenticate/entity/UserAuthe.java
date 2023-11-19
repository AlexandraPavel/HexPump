package com.authenticate.authenticate.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="user_hexpump")
public class UserAuthe {
    @Id
    @Column
    private String id;

    @Column
    private String username;

    @Column
    private String face;

    @Column
    private String fingerprint;

    @Column
    private String signature;

}
