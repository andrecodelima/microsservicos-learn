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

@Service
public class PropostaService {

	@Autowired
	private PropostaRepository propostaRepository;
	private NotificacaoService notificacaoService;
	
    @Autowired
    public PropostaService(PropostaRepository propostaRepository, NotificacaoService notificacaoService) {
        this.propostaRepository = propostaRepository;
        this.notificacaoService = notificacaoService;
    }

    public PropostaResponseDto criar(PropostaRequestDto requestDto){
    	
    	//propostaRepository.save(new Proposta());
      Proposta proposta =  PropostaMapper.INSTANCE.convertDtoProposta(requestDto);
      propostaRepository.save(proposta);
      
      PropostaResponseDto response =  PropostaMapper.INSTANCE.convertEntityToDto(proposta);
      notificacaoService.notificar(response, "proposta-pendente.ex");
      
    	return response;
    }

	public List<PropostaResponseDto> obterProposta() {
		
//		Iterable<Proposta> propostas = propostaRepository.findAll();
//		return PropostaMapper.INSTANCE.convertListEntityToDto(propostas); PRIMEIRA FORMA DE SE FAZER
		
		return PropostaMapper.INSTANCE.convertListEntityToDto(propostaRepository.findAll()); //  SEGUNDA FORMA DE SE FAZER
	}
}
