package com.github.proposalapp.dto;

public class ProposalResponseDto {

	private Long id;
	private String firstname;
	private String lastname;
	private String cpf;
	private String phone;
	private Double income;
	private String valueRequested;
	private int deadlinePayment;
	private boolean approved;
	private String observation;
	
	public ProposalResponseDto() {}
	
	public ProposalResponseDto(Long id, String firstname, String lastname, String cpf, String phone, Double income,
			String valueRequested, int deadlinePayment, boolean approved, String observation) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.cpf = cpf;
		this.phone = phone;
		this.income = income;
		this.valueRequested = valueRequested;
		this.deadlinePayment = deadlinePayment;
		this.approved = approved;
		this.observation = observation;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getValueRequested() {
		return valueRequested;
	}
	public void setValueRequested(String valueRequested) {
		this.valueRequested = valueRequested;
	}
	public int getDeadlinePayment() {
		return deadlinePayment;
	}
	public void setDeadlinePayment(int deadlinePayment) {
		this.deadlinePayment = deadlinePayment;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
}
