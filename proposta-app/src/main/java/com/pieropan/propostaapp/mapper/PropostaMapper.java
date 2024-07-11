package com.pieropan.propostaapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pieropan.propostaapp.dto.PropostaRequestDto;
import com.pieropan.propostaapp.entity.Proposta;

@Mapper
public interface PropostaMapper {
   
	@Mapping(target = "usuario.nome", source = "nome")
	@Mapping(target = "usuario.sobrenome", source="sobrenome")
	@Mapping(target="usuario.cpf", source="cpf")
	@Mapping(target="usuario.renda", source="renda")
	@Mapping(target="usuario.telefone", source="telefone")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "aprovada", ignore = true)
	@Mapping(target = "integrada", ignore = true)
	@Mapping(target = "observacao", ignore = true)


	Proposta convertDtoProposta(PropostaRequestDto propostaRequestDto);
}
