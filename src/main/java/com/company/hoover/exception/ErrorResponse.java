package com.company.hoover.exception;

import java.io.Serializable;

import com.company.hoover.model.Hoover;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErrorResponse implements Serializable,Hoover{

	private static final long serialVersionUID = -4490206350135946215L;
	private String message;
	@JsonInclude(value = Include.NON_NULL)
	private String description;

	public ErrorResponse(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
