package com.github.proposalapp.mapper;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.github.proposalapp.dto.ProposalRequestDto;
import com.github.proposalapp.dto.ProposalResponseDto;
import com.github.proposalapp.model.Proposal;

@Mapper
public interface ProposalMapper {
	
	ProposalMapper INSTANCE = Mappers.getMapper(ProposalMapper.class);

	@Mapping(target = "user.firstname", source = "firstname")
	@Mapping(target = "user.lastname", source = "lastname")
	@Mapping(target = "user.cpf", source = "cpf")
	@Mapping(target = "user.phone", source = "phone")
	@Mapping(target = "user.income", source = "income")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "approved", ignore = true)
	@Mapping(target = "integrated", constant =  "true")
	@Mapping(target = "observation", ignore = true)
	Proposal requestDtoToProposal(ProposalRequestDto proposalRequestDto);
	
	@Mapping(target = "firstname", source = "user.firstname")
	@Mapping(target = "lastname", source = "user.lastname")
	@Mapping(target = "cpf", source = "user.cpf")
	@Mapping(target = "phone", source = "user.phone")
	@Mapping(target = "income", source = "user.income")
	@Mapping(target = "valueRequested", expression = "java(setValueRequested(proposal))")
	ProposalResponseDto proposalToResponseDto(Proposal proposal);
	
	List<ProposalResponseDto> listProposalToListResponseDto(Iterable<Proposal> proposals);
	
    default String setValueRequested(Proposal proposal) {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
    	return formatter.format(proposal.getValueRequested());
    }
	
}
