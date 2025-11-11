package com.mandarinaSolutions.impresiones3d.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.mandarinaSolutions.impresiones3d.errors.HttpError;
import com.mandarinaSolutions.impresiones3d.exceptions.ArticuloConflictException;
import com.mandarinaSolutions.impresiones3d.exceptions.ArticuloEmptyCollectionException;
import com.mandarinaSolutions.impresiones3d.exceptions.ArticuloIllegalNullException;
import com.mandarinaSolutions.impresiones3d.exceptions.ArticuloNotFoundException;



@ControllerAdvice
public class RestControllerExceptionHAndler{
	
	@ExceptionHandler(ArticuloNotFoundException.class)
	public ResponseEntity<HttpError> handleNotFoundByID() {
		HttpError error = new HttpError(HttpStatus.NOT_FOUND.value(), "No existe articulo con ese ID");
		return new ResponseEntity<HttpError>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ArticuloConflictException.class)
	public ResponseEntity<HttpError> handleExist() {
		HttpError error = new HttpError(HttpStatus.CONFLICT.value(), "Ya existe articulo con ese ID");
		return new ResponseEntity<HttpError>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ArticuloEmptyCollectionException.class)
	public ResponseEntity<HttpError> handleArticuloEmptyCollection() {
		HttpError error = new HttpError(HttpStatus.LENGTH_REQUIRED.value(), "Categorias, Colores, Dimensiones o Imagenes vacias. Verificar campos");
		return new ResponseEntity<HttpError>(error, HttpStatus.LENGTH_REQUIRED);
	}
	
	@ExceptionHandler(ArticuloIllegalNullException.class)
	public ResponseEntity<HttpError> handleArticuloIllegalNull() {
		HttpError error = new HttpError(411, "Titulo o precio con valor NULL. Verificar campos");
		return new ResponseEntity<HttpError>(error, HttpStatus.LENGTH_REQUIRED);
	}
	
//	@ResponseStatus(value=HttpStatus.CONFLICT, reason="No existe articulo con ese ID")
//	@ExceptionHandler(HttpNotFoundException.class)
//	public void handleNotFoundByID() {}
	
}