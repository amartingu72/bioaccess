package vector.bioaccess.services.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vector.bioaccess.helpers.AdminItem;
import vector.bioaccess.helpers.EntityUtils;
import vector.bioaccess.helpers.FacilityItem;
import vector.bioaccess.model.Admin;
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
		AdminItem adminItem=null;
		Admin admin=adminsRepository.load(adminId);
		if ( admin!=null) adminItem=EntityUtils.getAdminItem(admin);
		return adminItem;
	}

	@Override
	public AdminItem load(String email) {
		AdminItem adminItem=null;
		Admin admin=adminsRepository.load(email);
		if ( admin!=null) adminItem=EntityUtils.getAdminItem(admin);
		return adminItem;
	}

	@Override
	@Transactional
	public AdminItem create(AdminItem adminItem, List<FacilityItem> facilities)
		throws DuplicatedAdminException {
		
		//Comprobamos que no hay otro administrador con ese usuario.
		if (this.adminsRepository.load(adminItem.getEmail()) != null)
			throw new DuplicatedAdminException();
		
		//Creamos el administrador.
		Admin admin=EntityUtils.getAdmin(adminItem);
		admin=this.adminsRepository.create(admin);
		//Asignamos instalaciones al administrador,
		Iterator<FacilityItem> it=facilities.iterator();
		FacilityItem facilityItem;
		while ( it.hasNext() ){
			facilityItem=it.next();
			this.adminsRepository.addFacility(admin, EntityUtils.getFacility(facilityItem));
		}
		return EntityUtils.getAdminItem(admin);
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
