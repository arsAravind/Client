package com.qsp.CMS.ExceptionHandling;

public class IdNotFoundException extends Exception {

	@Override
	public String getMessage() {

		return "Id not found ... Ty again!";
	}

}
