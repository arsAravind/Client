package com.qsp.CMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.CMS.DTO.Client;
import com.qsp.CMS.ExceptionHandling.EmailNotValidException;
import com.qsp.CMS.ExceptionHandling.IdNotFoundException;
import com.qsp.CMS.ExceptionHandling.PasswordInvalid;
import com.qsp.CMS.ResponseStructure.ResponseStructure;
import com.qsp.CMS.Service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ClientService clientService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveClient(@RequestBody Client client)
	{
		ResponseStructure<Client> s= clientService.saveClient(client);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	
	@GetMapping("/fetchAll")
	public List<Client> fetchAll()
	{
		List<Client> clients=clientService.fetchAll();
		return clients;
	}
	
	@GetMapping("/fetchOne/{id}")
	public Client fetchOne(@PathVariable int id) throws IdNotFoundException
	{
		Client client=clientService.fetchOne(id);
		return client;
	}

	@PutMapping("/update/{id}")
	public Client update(@PathVariable int id, @RequestBody Client client) throws IdNotFoundException
	{
		Client c=clientService.updateClient(id,client);
		return c;
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) throws IdNotFoundException
	{
		String s=clientService.deleteClient(id);
		return s;
	}
	
	@GetMapping("/loginViaEmail")
	public String loginEmail(@RequestParam String email, String password) throws PasswordInvalid, EmailNotValidException
	{
		String s=clientService.loginEmail(email,password);
		return s;
	}
}
