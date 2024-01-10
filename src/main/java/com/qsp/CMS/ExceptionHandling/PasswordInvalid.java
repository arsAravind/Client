package com.qsp.CMS.ExceptionHandling;


public class PasswordInvalid extends Exception{
	
	@Override
	public String getMessage() {
		
		return "Password invalid exception";
	}

}
