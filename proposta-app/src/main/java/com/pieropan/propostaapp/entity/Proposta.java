package com.pieropan.propostaapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorSolicitado;

    private int prazoPagamento;

    private Boolean aprovada;

    private boolean integrada;

    private Double observacao;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
