package com.company.exception;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.company.model.Response;

@ControllerAdvice
public class ControllerExceptionProcessor {

    private static Logger processor = LoggerFactory.getLogger(ExceptionProcessor.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionProcessor(Exception exception, WebRequest query) {
        processor.error("Error", exception);
		return new ResponseEntity<>(Response.builder().errors(Arrays.asList(exception.getMessage())).build(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}