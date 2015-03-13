package vector.bioaccess.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import vector.bioaccess.model.Facility;
import vector.bioaccess.repositories.FacilityDAO;

@Repository("FacilitiesRepository")
public class FacilityDAOImpl implements FacilityDAO {
	private EntityManager em = null;

    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
	@Override
	public List<Facility> getFacilities(int adminId) {
		Query query=em.createQuery( "select af.facility from AdminsFacility as af where af.admin.id=:adminid", 
				Facility.class );
		query.setParameter("adminid", adminId);
		@SuppressWarnings("unchecked")
		List<Facility> result=query.getResultList();
		
		
		return result;
	
	}

	@Override
	public List<Facility> getAllFacilities() {
		Query query=em.createQuery( "select af.facility from AdminsFacility as af", 
				Facility.class );
		
		@SuppressWarnings("unchecked")
		List<Facility> result=query.getResultList();
		
		
		return result;
		
	}

}
