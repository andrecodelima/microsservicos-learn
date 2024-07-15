package com.pieropan.propostaapp.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.pieropan.propostaapp.entity.Proposta;

@Service
public class NotificacaoRabbitService {

	private RabbitTemplate rabbitTemplate;
	
	public NotificacaoRabbitService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	// Antigo
//	public void notificar(PropostaResponseDto proposta, String exchange) {
//		rabbitTemplate.convertAndSend(exchange,  " ", proposta);
//	} 
	
	public void notificar(Proposta proposta, String exchange) {
		rabbitTemplate.convertAndSend(exchange,  " ", proposta);
	}	
	
}
