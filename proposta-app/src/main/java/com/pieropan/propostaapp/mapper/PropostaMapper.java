package com.pieropan.propostaapp.mapper;

import java.text.NumberFormat;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.pieropan.propostaapp.dto.PropostaRequestDto;
import com.pieropan.propostaapp.dto.PropostaResponseDto;
import com.pieropan.propostaapp.entity.Proposta;

@Mapper
public interface PropostaMapper {
   
	PropostaMapper INSTANCE =  Mappers.getMapper(PropostaMapper.class);
	
	
	@Mapping(target = "usuario.nome", source = "nome")
	@Mapping(target = "usuario.sobrenome", source="sobrenome")
	@Mapping(target="usuario.cpf", source="cpf")
	@Mapping(target="usuario.renda", source="renda")
	@Mapping(target="usuario.telefone", source="telefone")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "aprovada", ignore = true)
	@Mapping(target = "integrada", constant = "true")
	@Mapping(target = "observacao", ignore = true)
	Proposta convertDtoProposta(PropostaRequestDto propostaRequestDto);
	
	
	@Mapping(target = "nome", source = "usuario.nome")
	@Mapping(target = "sobrenome", source = "usuario.sobrenome")
	@Mapping(target = "telefone", source = "usuario.telefone")
	@Mapping(target = "cpf", source = "usuario.cpf")
	@Mapping(target = "renda", source = "usuario.renda")
	@Mapping(target = "valorSolicitadoFmt", expression = "java(setvalorSolicitadoFmt(proposta))")
	PropostaResponseDto convertEntityToDto(Proposta proposta);
	
	List<PropostaResponseDto> convertListEntityToDto(Iterable<Proposta>proposta);
	
	default String setvalorSolicitadoFmt(Proposta proposta) {
		return NumberFormat.getCurrencyInstance().format(proposta.getValorSolicitado());
	}
	
	
}
