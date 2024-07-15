package com.pieropan.propostaapp.agendador;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pieropan.propostaapp.entity.Proposta;
import com.pieropan.propostaapp.repository.PropostaRepository;
import com.pieropan.propostaapp.service.NotificacaoRabbitService;

@Component
public class PropostaSemIntegracao {

	@Autowired
	private  PropostaRepository propostaRepository;
	
	@Autowired
	private  NotificacaoRabbitService notificacaoRabbitService;
	
	@Value("${rabbitmq.propostapendente.exchange}") // subsitui a indicação 'proposta-pendente.ex' em notificacao service.
	private   String exchange;
	
	private final Logger logger = LoggerFactory.getLogger(PropostaSemIntegracao.class);
	
	@Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
	// Quando a app for inicializada, automaticamente ela vai carregar as propostas que nao foram integradas. Vai verificar se houve uma proposta sem integracao. 
	// Uma vez inicializado, o metodo vai aguardar 10 segundos para inicializar de novo.
	public void buscarPropostasSemIntegracao() {
		propostaRepository.findAllByIntegradaIsFalse().forEach(proposta ->{
			
			try {
				notificacaoRabbitService.notificar(proposta,  exchange);		
				atualizarProposta(proposta);
			}catch (RuntimeException ex) {
				logger.error(ex.getMessage());
			}
			
		});
	}
	
	private void atualizarProposta(Proposta proposta) {
		proposta.setIntegrada(true);
		propostaRepository.save(proposta);
	}
	
	
	
	
	
}
