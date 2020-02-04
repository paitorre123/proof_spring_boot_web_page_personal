package com.emanon.controladores;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControladorErrores {
	
	public static final String ISE_VIEW ="error/500";
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		
		return ISE_VIEW;
	}

}
