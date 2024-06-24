package com.github.proposalapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "proposal")
public class Proposal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double valueRequested;
	private int deadlinePayment;
	private boolean approved;
	private boolean integrated;
	private String observation;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_user")
	@JsonManagedReference
	private User user;
	
	public Proposal() {}

	public Proposal(Long id, Double valueRequested, int deadlinePayment, boolean approved, boolean integrated,
			String observation, User user) {
		this.id = id;
		this.valueRequested = valueRequested;
		this.deadlinePayment = deadlinePayment;
		this.approved = approved;
		this.integrated = integrated;
		this.observation = observation;
		this.user = user;
	}

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
