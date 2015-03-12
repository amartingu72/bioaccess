package vector.bioaccess.repositories.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import vector.bioaccess.model.Admin;
import vector.bioaccess.model.AdminsFacility;
import vector.bioaccess.model.Facility;
import vector.bioaccess.repositories.AdminDAO;

@Repository("AdminsRepository")
public class AdminDAOImpl implements AdminDAO {
	
	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	
	
	
	@Override
	public Admin load(int id) {
		
		return em.find(Admin.class, id);
	}

	@Override
	public Admin load(String email) {
		Query query=em.createQuery( "select a from Admin as a where a.email=:email", 
				Admin.class );
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<Admin> result=query.getResultList();
		Admin admin=null;
		if (result.size() > 0)
			admin=result.get(0);
		return admin;
	}

	@Override
	public Admin create(Admin admin) {
		em.persist(admin);
		return load(admin.getEmail());
	}




	@Override
	public void addFacility(Admin admin, Facility facility) {
		AdminsFacility af=new AdminsFacility();
		af.setAdmin(admin);
		af.setFacility(facility);
		em.persist(af);
	}

}
