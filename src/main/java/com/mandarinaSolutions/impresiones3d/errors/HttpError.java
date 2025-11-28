package com.mandarinaSolutions.impresiones3d.errors;


public class HttpError{
	
	public Integer errorCode;
	public String errorMessage;
	public HttpError(Integer errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
}


