package com.qsp.CMS.ResponseStructure;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.qsp.CMS.DTO.Client;

import lombok.Data;
@Data
public class ResponseStructure<T> {
	
	private T data;
	private HttpStatus httpStatus;
	private String httpmessage;
	private LocalDateTime dateTime;

}
