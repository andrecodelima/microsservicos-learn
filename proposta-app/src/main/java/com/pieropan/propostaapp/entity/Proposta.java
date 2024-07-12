package com.pieropan.propostaapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne(cascade = CascadeType.PERSIST)
    /*Com essa propriedade resolvemos de forma muito eficiente o erro 
     * org.springframework.dao.InvalidDataAccessApiUsageException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.pieropan.propostaapp.entity.Proposta.usuario -> com.pieropan.propostaapp.entity.Usuario] with root cause
     *  Isso porque com ela, o spring salva antes a entidade, nesse caso o usuario.
     *  */
    
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorSolicitado() {
		return valorSolicitado;
	}

	public void setValorSolicitado(Double valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}

	public int getPrazoPagamento() {
		return prazoPagamento;
	}

	public void setPrazoPagamento(int prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}

	public Boolean getAprovada() {
		return aprovada;
	}

	public void setAprovada(Boolean aprovada) {
		this.aprovada = aprovada;
	}

	public boolean isIntegrada() {
		return integrada;
	}

	public void setIntegrada(boolean integrada) {
		this.integrada = integrada;
	}

	public Double getObservacao() {
		return observacao;
	}

	public void setObservacao(Double observacao) {
		this.observacao = observacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    
	 
    
    
}