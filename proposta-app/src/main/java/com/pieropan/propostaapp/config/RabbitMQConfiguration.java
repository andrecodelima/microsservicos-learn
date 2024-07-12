package com.pieropan.propostaapp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfiguration {

	// Fila 1
	@Bean
	public Queue criarFilaPropostaPendenteMsAnaliseCredito() {
		return QueueBuilder.durable("proposta-pendente.ms-analise-credito").build(); // nao vai perder os dados caso a aplicacao caia.
	}
	
	// Fila 2
	@Bean
	public Queue criarFilaPropostaPendenteMsAnaliseNotificacao() {
		return QueueBuilder.durable("proposta-pendente.ms-analise-notificacao").build(); // nao vai perder os dados caso a aplicacao caia.
	}
	
	// Fila 3
	@Bean
	public Queue criarFilaPropostaConcluidaMsProposta() {
		return QueueBuilder.durable("proposta-concluida.ms-analise-proposta").build(); // nao vai perder os dados caso a aplicacao caia.
	}
	
	
	// Fila 4
	@Bean
	public Queue criarFilaPropostaConcluidaMsAnaliseNotificacao() {
		return QueueBuilder.durable("proposta-concluida.ms-analise-notificacao").build(); // nao vai perder os dados caso a aplicacao caia.
	}
	
	@Bean
	public RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}
	
	@Bean
	public ApplicationListener<ApplicationReadyEvent> inicializarRabbitAdmin(RabbitAdmin rabbitAdmin){ 
		return event  -> rabbitAdmin.initialize();
	}
	
	/*
	 *  A configuração a cima é necessária para que se possa criar as filas e exchanges
	 * */
	
}
