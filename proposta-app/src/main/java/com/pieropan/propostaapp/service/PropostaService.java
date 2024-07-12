package com.pieropan.propostaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pieropan.propostaapp.dto.PropostaRequestDto;
import com.pieropan.propostaapp.dto.PropostaResponseDto;
import com.pieropan.propostaapp.entity.Proposta;
import com.pieropan.propostaapp.mapper.PropostaMapper;
import com.pieropan.propostaapp.repository.PropostaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PropostaService {

	@Autowired
	private PropostaRepository propostaRepository;
	
    public PropostaResponseDto criar(PropostaRequestDto requestDto){
    	
    	//propostaRepository.save(new Proposta());
      Proposta proposta =  PropostaMapper.INSTANCE.convertDtoProposta(requestDto);
      propostaRepository.save(proposta);
      
    	return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

	public List<PropostaResponseDto> obterProposta() {
		
//		Iterable<Proposta> propostas = propostaRepository.findAll();
//		return PropostaMapper.INSTANCE.convertListEntityToDto(propostas); PRIMEIRA FORMA DE SE FAZER
		
		return PropostaMapper.INSTANCE.convertListEntityToDto(propostaRepository.findAll()); //  SEGUNDA FORMA DE SE FAZER
	}
}
