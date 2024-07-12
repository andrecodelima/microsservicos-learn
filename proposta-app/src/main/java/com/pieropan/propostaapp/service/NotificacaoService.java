package com.pieropan.propostaapp.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.pieropan.propostaapp.dto.PropostaResponseDto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
public class NotificacaoService {

	private RabbitTemplate rabbitTemplate;
	
	public NotificacaoService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void notificar(PropostaResponseDto proposta, String exchange) {
		rabbitTemplate.convertAndSend(exchange,  " ", proposta);
	}
	
}
