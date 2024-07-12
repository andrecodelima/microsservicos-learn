package com.pieropan.propostaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pieropan.propostaapp.dto.PropostaRequestDto;
import com.pieropan.propostaapp.dto.PropostaResponseDto;
import com.pieropan.propostaapp.service.PropostaService;

@RestController
@RequestMapping ("/proposta")
public class PropostaController {

	@Autowired
    private PropostaService propostaService;

	// INSERT
    @PostMapping
    public ResponseEntity<PropostaResponseDto>criar(@RequestBody PropostaRequestDto requestDto){
        PropostaResponseDto response = propostaService.criar(requestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
        			.path("./{id}")
        			.buildAndExpand(response.getId())
        			.toUri())
        			.body(response);
        
    }
    
    //SELECT ALL
    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> obterProposta(){
    	
    	return ResponseEntity.ok(propostaService.obterProposta());
    	// Responde 'Ok' - status code: 200 e passa no corpo o json mapeado.
    	 
    }
    
    
}
