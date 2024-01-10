package com.qsp.CMS.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qsp.CMS.DTO.Client;
@Repository
public interface ClientRepo extends JpaRepository<Client, Integer>{

//	Client findByEmail(String email);

	Client findByClientEmail(String email);

}
