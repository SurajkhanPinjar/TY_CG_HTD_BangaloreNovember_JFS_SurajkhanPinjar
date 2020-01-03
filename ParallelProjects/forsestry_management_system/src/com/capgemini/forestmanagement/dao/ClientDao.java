package com.capgemini.forestmanagement.dao;

import java.util.List;

import com.capgemini.forestmanagement.bean.ClientBean;

public interface ClientDao {
	public boolean addClient(ClientBean bean);
	public boolean loginClient(Object cid, String cpass);
	public List<ClientBean> searchClient(int clientid);
	public List<ClientBean> getAllClient();
	public boolean deleteClient(int clientid );
	public boolean updateClient(int clientid);
}
