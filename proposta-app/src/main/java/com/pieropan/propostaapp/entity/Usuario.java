package com.pieropan.propostaapp.entity;

import jakarta.persistence.*;
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

}
