package com.capgemini.forestrymanagementspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringrest.dao.ClientDao;
import com.capgemini.forestrymanagementspringrest.dto.Client;

@Service
public class ClientServicesImpl implements ClientServices {
	
	@Autowired
	private ClientDao clientDao ;

	@Override
	public boolean addClient(Client client) {
		return clientDao.addClient(client);
	}

	@Override
	public List<Client> searchClient(int clientId) {
		return clientDao.searchClient(clientId);
	}

	@Override
	public List<Client> getAllClient() {
		return clientDao.getAllClient();
	}

	@Override
	public boolean deleteClient(int clientId) {
		return clientDao.deleteClient(clientId);
	}

	@Override
	public Client login(Client client) {
		return clientDao.login(client);
	}




	

}
