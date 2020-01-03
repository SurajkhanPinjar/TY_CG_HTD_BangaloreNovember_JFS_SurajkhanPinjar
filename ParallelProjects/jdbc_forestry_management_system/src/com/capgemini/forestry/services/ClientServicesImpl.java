package com.capgemini.forestry.services;

import java.util.List;

import com.capgemini.forestry.bean.ClientBean;
import com.capgemini.forestry.dao.ClientDao;
import com.capgemini.forestry.dao.ClientDaoImpl;
import com.capgemini.forestry.factory.Factory;
import com.capgemini.forestry.factory.Factory1;

public class ClientServicesImpl implements ClientSevices {
	ClientDao dao = Factory1.getClDao();
	@Override
	public boolean addClient(ClientBean bean) {
		return dao.addClient(bean);
	}

	@Override
	public boolean loginClient(int clientid, String clientpass) {
		return dao.loginClient(clientid, clientpass);
	}

	@Override
	public List<ClientBean> searchClient(int clientid) {
		// TODO Auto-generated method stub
		return dao.searchClient(clientid);
	}

	@Override
	public List<ClientBean> getAllClient() {
		// TODO Auto-generated method stub
		return dao.getAllClient();
	}

	@Override
	public boolean deleteClient(int clientid, String clientpass) {
		// TODO Auto-generated method stub
		return dao.deleteClient(clientid, clientpass);
	}

}
