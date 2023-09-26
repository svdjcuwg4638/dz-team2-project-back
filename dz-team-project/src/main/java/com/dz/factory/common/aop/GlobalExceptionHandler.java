package com.dz.factory.common.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dz.factory.common.domain.CMRespDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex){
		String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
		return new ResponseEntity<>(new CMRespDto<>(-1,errorMessage,null),HttpStatus.BAD_REQUEST);
	}
	
}
