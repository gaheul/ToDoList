package com.springboot.todolist.handler.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.todolist.handler.CustomValidationApiException;
import com.springboot.todolist.web.dto.CMRespDto;

@RestController
@RestControllerAdvice //예외가 있으면 예외잡음 /rest->무조건 json으로 return
public class ControllerExceptionHandler {
	
	@ExceptionHandler(CustomValidationApiException.class)
	public ResponseEntity<?> validationApiException(CustomValidationApiException e){
		return new ResponseEntity<>(new CMRespDto<Map<String,String>>(-1,e.getMessage(),e.getErrorMap()),HttpStatus.OK);
	}
}
