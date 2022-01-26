package com.pluralsight.conferencedemo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerConfiguration {

	private static final ObjectMapper mapper = new ObjectMapper();

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid")
	public void notValid() {

	}
}
