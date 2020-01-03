package com.capgemini.forestry.dao;

import java.util.List;

import com.capgemini.forestry.bean.ClientBean;

public interface ClientDao {
	public boolean addClient(ClientBean bean);
	public boolean loginClient(int clientid, String clientpass);
	public List<ClientBean> searchClient(int clientid);
	public List<ClientBean> getAllClient();
	public boolean deleteClient(int clientid , String clientpass);
}
