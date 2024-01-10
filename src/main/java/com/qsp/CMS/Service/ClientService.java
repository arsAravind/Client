package com.qsp.CMS.Service;

import java.util.List;

import com.qsp.CMS.DTO.Client;
import com.qsp.CMS.ExceptionHandling.EmailNotValidException;
import com.qsp.CMS.ExceptionHandling.IdNotFoundException;
import com.qsp.CMS.ExceptionHandling.PasswordInvalid;
import com.qsp.CMS.ResponseStructure.ResponseStructure;

public interface ClientService {

	List<Client> fetchAll();

	Client fetchOne(int id) throws IdNotFoundException;

	Client updateClient(int id, Client client) throws IdNotFoundException;

	String deleteClient(int id) throws IdNotFoundException;

	ResponseStructure<Client> saveClient(Client client);

	String loginEmail(String email, String password) throws PasswordInvalid, EmailNotValidException;

}
