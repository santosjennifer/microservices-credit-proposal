package com.github.proposalapp.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.github.proposalapp.exception.ProposalNotFoundException;
import com.github.proposalapp.exception.StandardError;
import com.github.proposalapp.exception.ValidationError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ValidationExceptionHandler {
	
	@ExceptionHandler(ProposalNotFoundException.class)
	public ResponseEntity<StandardError> proposalNotFoundException(ProposalNotFoundException ex,
			HttpServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> violationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
		ValidationError error = new ValidationError(System.currentTimeMillis(), "Erro na validação dos campos", request.getRequestURI());

		for (FieldError erro : ex.getBindingResult().getFieldErrors()) {
			error.addError(erro.getField(), erro.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
	}

}
