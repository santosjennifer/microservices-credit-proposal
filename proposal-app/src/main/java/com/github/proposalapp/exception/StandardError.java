package com.github.proposalapp.exception;

public class StandardError {
	
	private Long timestamp;
	private String message;
	private String path;
	
	public StandardError(Long timestamp, String message, String path) {
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

}
