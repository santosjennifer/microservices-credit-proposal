package com.github.proposalapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.proposalapp.dto.ProposalRequestDto;
import com.github.proposalapp.dto.ProposalResponseDto;
import com.github.proposalapp.service.ProposalService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/proposal")
@Tag(name = "Proposal API")
@OpenAPIDefinition(info = @Info(title = "Proposal API", version = "v1.0", description = "Documentation of Proposal API"))
public class ProposalController {
	
	private ProposalService service;
	
	public ProposalController(ProposalService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<ProposalResponseDto> create(@Valid @RequestBody ProposalRequestDto request) {
		ProposalResponseDto response = service.create(request);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(response.getId())
				.toUri())
				.body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<ProposalResponseDto>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProposalResponseDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
}
