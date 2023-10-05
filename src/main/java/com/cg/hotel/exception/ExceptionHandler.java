package com.cg.hotel.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.cg.hotel.dto.CustomException;



@ControllerAdvice
public class ExceptionHandler {
@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundException.class)
public ResponseEntity<CustomException>handleIdNotFound(Exception e){
	CustomException custom=new CustomException();
	custom.setStatusCode(HttpStatus.NOT_FOUND.name());
	custom.setUserMessage(e.getMessage());
	custom.setDeveloperMessage(e.getLocalizedMessage());
	return new ResponseEntity<>(custom, HttpStatus.NOT_FOUND);
}

@org.springframework.web.bind.annotation.ExceptionHandler(DuplicateEntryException.class)
public ResponseEntity<CustomException>handleDuplicateEntry(Exception e){
	CustomException custom=new CustomException();
	custom.setStatusCode(HttpStatus.CONFLICT.name());
	custom.setUserMessage(e.getMessage());
	custom.setDeveloperMessage(e.getLocalizedMessage());
	return new ResponseEntity<>(custom, HttpStatus.CONFLICT);
}
@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
	 Map<String, String> resp = new HashMap<> () ;
	 ex.getBindingResult().getAllErrors().forEach((error) ->{
		 System.out.println(error.toString());
    	 String fieldName = ((FieldError) error).getField();
    	 String message = error.getDefaultMessage () ;
    	 resp.put (fieldName, message);
	 });
	 return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);
}
}

