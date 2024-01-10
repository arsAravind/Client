package com.qsp.CMS.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.CMS.DTO.Client;
import com.qsp.CMS.ExceptionHandling.EmailNotValidException;
import com.qsp.CMS.ExceptionHandling.IdNotFoundException;
import com.qsp.CMS.ExceptionHandling.PasswordInvalid;
import com.qsp.CMS.Repo.ClientRepo;
import com.qsp.CMS.ResponseStructure.ResponseStructure;

@Service
public class ClientImpl implements ClientService{
	@Autowired
	ClientRepo clientRepo;
	
	@Override
	public ResponseStructure<Client> saveClient(Client client) {
		Client save = clientRepo.save(client);
		ResponseStructure<Client> structure=new ResponseStructure<>();
		structure.setData(save);
		structure.setDateTime(LocalDateTime.now());
		structure.setHttpmessage("Data Saved");
		structure.setHttpStatus(HttpStatus.ACCEPTED);
		return structure;
	}
@Override
	public List<Client> fetchAll() {
	
		List<Client> findAll = clientRepo.findAll();
		return findAll;
	}
@Override
	public Client fetchOne(int id) throws IdNotFoundException {
		Client c = clientRepo.findById(id).orElseThrow(()-> new IdNotFoundException());
		return c;
	}

	@Override
	public Client updateClient(int id,Client client) throws IdNotFoundException {
		Client c = clientRepo.findById(id).orElseThrow(()-> new IdNotFoundException());
		c.setClientId(client.getClientId());
		c.setClientName(client.getClientName());
		c.setClientEmail(client.getClientEmail());
		c.setClientPassword(client.getClientPassword());
		c.setClientPhNo(client.getClientPhNo());
		clientRepo.save(c);
		return c;
	}

	@Override
	public String deleteClient(int id) throws IdNotFoundException {
		Client c = clientRepo.findById(id).orElseThrow(()-> new IdNotFoundException());
		clientRepo.delete(c);
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setData(null);
		responseStructure.setDateTime(LocalDateTime.now());
		responseStructure.setHttpmessage("Deleted successfully");
		responseStructure.setHttpStatus(HttpStatus.OK);
		return "Deleted Successfully";
	}
	@Override
	public String loginEmail(String email, String password) throws PasswordInvalid, EmailNotValidException {
		Client c=clientRepo.findByClientEmail(email);
		if(c!=null)
		{
			if(c.getClientPassword().equals(password))
			{
				return "Login successfull";
			}
			else
			{
				throw new PasswordInvalid();
			}
		}
		else {
			throw new EmailNotValidException(email);
		}
		
		
	}
	

}
