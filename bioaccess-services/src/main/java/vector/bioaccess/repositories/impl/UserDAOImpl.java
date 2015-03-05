package vector.bioaccess.repositories.impl;

/*import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;*/

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import vector.bioaccess.model.User;
import vector.bioaccess.repositories.UserDAO;

@Repository("UsersRepository")
public class UserDAOImpl implements UserDAO {
	
	private EntityManager em = null;
	
	
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
	public User loadUser(int userId) {
		return em.find(User.class, userId);
	}
       
	

}
