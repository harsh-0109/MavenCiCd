package com.blog.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(UserAlreadyPresentException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public Map<String,String> handleUserAlreadyExists(UserAlreadyPresentException ex)
	{
		String message = ex.getMessage();
		Map<String,String> map = new HashMap<>();
		map.put("msg",message);
		return map;
	}
	
	@ExceptionHandler(PostNotFoundException.class )
	public ResponseEntity<String> resourceNotFound(PostNotFoundException ex)
	{
		String message = ex.getMessage();
		return new ResponseEntity<String>(message , HttpStatus.NOT_FOUND);
	}

}
