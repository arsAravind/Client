package com.qsp.CMS.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Client_Id")
	private int clientId;
	@Column(name = "Client_Name")
	private String clientName;
	@Column(name = "Client_Email")
	private String clientEmail;
	@Column(name = "Client_Password")
	private String clientPassword;
	@Column(name = "Client_PhoneNo")
	private String clientPhNo;
	

}
