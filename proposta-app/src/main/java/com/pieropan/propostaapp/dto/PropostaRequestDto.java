package com.pieropan.propostaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropostaRequestDto {

    private String nome;

    private String sobrenome;

    private String telefome;

    private String cpf;

    private Double renda;

    private Double valorSolicitado;

    private int prazoPagamento;

}
