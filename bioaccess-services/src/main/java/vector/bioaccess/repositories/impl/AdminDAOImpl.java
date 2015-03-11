package vector.bioaccess.repositories.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import vector.bioaccess.model.Admin;
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

}
