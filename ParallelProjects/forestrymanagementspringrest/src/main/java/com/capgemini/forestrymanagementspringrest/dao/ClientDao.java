package com.capgemini.forestrymanagementspringrest.dao;

import java.util.List;

import com.capgemini.forestrymanagementspringrest.dto.Client;

public interface ClientDao {
	public boolean addClient(Client client);

	public List<Client> searchClient(int clientId);

	public List<Client> getAllClient();

	public boolean deleteClient(int clientId);
	
	public Client login(Client client);
}
