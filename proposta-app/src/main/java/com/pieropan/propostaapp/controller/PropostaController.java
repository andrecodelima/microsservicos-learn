package com.pieropan.propostaapp.controller;

import com.pieropan.propostaapp.dto.PropostaRequestDto;
import com.pieropan.propostaapp.dto.PropostaResponseDto;
import com.pieropan.propostaapp.service.PropostaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Indicacao de que essa classe representa um 'EndPoint' Rest
@RequestMapping ("/proposta")// Mapeando o recurso/URL do Endpoint
//Quando receber uma requisição 'localhost/propost' 'ele vai cair' aqui nessa classe
public class PropostaController {

    private PropostaService propostaService;

    public ResponseEntity<PropostaResponseDto>criarProposta(@RequestBody PropostaRequestDto propostaRequestDto){

        // Recebe os dados do frontEnd, dados que virão na requisição.
        // RequestBody
        // Objeto vai conter todas as informacoes que estão no corpo da rquisição

        /*
        * @RequestBody PropostaRequestDto propostaRequestDto
        * Receberemos os campos dessa requisição que estão na classe 'PropostaRequestDto'.
        *
        * */
        PropostaResponseDto propostaResponseDto = propostaService.criarProposta(propostaRequestDto);
        return ResponseEntity.ok(propostaResponseDto);
    }
}
