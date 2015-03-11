package vector.bioaccess.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import vector.bioaccess.helpers.AdminItem;
import vector.bioaccess.repositories.AdminDAO;
import vector.bioaccess.services.AdminDataProvider;
import vector.bioaccess.services.excp.AdminNotFoundException;
import vector.bioaccess.services.excp.DuplicatedAdminException;

@Service("adminDataProvider")
public class AdminDataProviderImpl implements AdminDataProvider {

	@Resource(name="AdminsRepository")
	private AdminDAO adminsRepository;
	
	@Override
	public AdminItem load(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminItem load(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminItem create(AdminItem adminItem)
		throws DuplicatedAdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(AdminItem adminItem) throws AdminNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int adminId) throws AdminNotFoundException {
		// TODO Auto-generated method stub

	}

}
