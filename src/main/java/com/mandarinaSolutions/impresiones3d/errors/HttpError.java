package com.mandarinaSolutions.impresiones3d.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;

public class HttpError{
	
	public Integer errorCode;
	public String errorMessage;
	public HttpError(Integer errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
}


