package com.github.creditanalysis.domain;

public class Proposal {

	private Long id;
	private Double valueRequested;
	private int deadlinePayment;
	private boolean approved;
	private boolean integrated;
	private String observation;
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public boolean isIntegrated() {
		return integrated;
	}
	public void setIntegrated(boolean integrated) {
		this.integrated = integrated;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
