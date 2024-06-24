package com.github.proposalapp.dto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProposalRequestDto {

	@NotBlank(message = "O nome deve ser informado.")
	private String firstname;
	
	@NotBlank(message = "O sobrenome deve ser informado.")
	private String lastname;
	
	@CPF(message = "O cpf deve ser válido.")
	@NotBlank(message = "O cpf deve ser informado.")
	private String cpf;
	
	@NotBlank(message = "O telefone deve ser informado.")
	private String phone;
	
	@NotNull(message = "A renda deve ser informada.")
	private Double income;
	
	@NotNull(message = "O valor solicitado deve ser informado.")
	private Double valueRequested;
	
	@NotNull(message = "O prazo de pagamento deve ser informado.")
    @Min(value = 1, message = "O prazo de pagamento deve ser no mínimo 1 mês.")
    @Max(value = 420, message = "O prazo de pagamento deve ser no máximo 420 meses.")
	private int deadlinePayment;
	
	public ProposalRequestDto() {}
	
	public ProposalRequestDto(String firstname, String lastname, String cpf, String phone, Double income,
			Double valueRequested, int deadlinePayment) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.cpf = cpf;
		this.phone = phone;
		this.income = income;
		this.valueRequested = valueRequested;
		this.deadlinePayment = deadlinePayment;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getValueRequested() {
		return valueRequested;
	}

	public void setValueRequested(Double valueRequested) {
		this.valueRequested = valueRequested;
	}

	public int getDeadlinePayment() {
		return deadlinePayment;
	}

	public void setDeadlinePayment(int deadlinePayment) {
		this.deadlinePayment = deadlinePayment;
	}
	
}
