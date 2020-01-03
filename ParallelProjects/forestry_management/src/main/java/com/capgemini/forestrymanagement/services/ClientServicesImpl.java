package com.capgemini.forestrymanagement.services;

import java.util.List;

import com.capgemini.forestrymanagement.dao.ClientDao;
import com.capgemini.forestrymanagement.dto.Client;
import com.capgemini.forestrymanagement.factory.Factory;

public class ClientServicesImpl implements ClientServices {

	ClientDao dao = Factory.getClientDao();
	@Override
	public boolean addClient(Client client) {
		return dao.addClient(client);
	}

	@Override
	public boolean loginClient(int clientId, String clientPassword) {
		return dao.loginClient(clientId, clientPassword);
	}

	@Override
	public List<Client> searchClient(int clientId) {
		return dao.searchClient(clientId);
	}

	@Override
	public List<Client> getAllClient() {
		return dao.getAllClient();
	}

	@Override
	public boolean deleteClient(int clientId) {
		return dao.deleteClient(clientId);
	}

}
