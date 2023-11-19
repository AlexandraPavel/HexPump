package com.innovation.hexpump.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="user_hexpump")
public class UserHexpump {
    @Id
    @Column
    private String id;

    @Column
    private String username;

    @Column
    private String nume;

    @Column
    private String prenume;

    @Column
    private String parola;

}
