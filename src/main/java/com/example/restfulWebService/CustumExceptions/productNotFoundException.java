package com.example.restfulWebService.CustumExceptions;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class productNotFoundException extends Exception{
	
	public productNotFoundException(String ExName) {
		super(ExName);
	}

}
