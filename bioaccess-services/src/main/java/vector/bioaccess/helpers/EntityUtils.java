package vector.bioaccess.helpers;

import vector.bioaccess.model.Admin;
import vector.bioaccess.model.Facility;
/**
 * Utilidades de conversión POJOs - Entidades JPA
 * @author AMG
 *
 */
public abstract class EntityUtils {
	
	
	/**
	 * Convierte un item de administrador (POJO) en un objeto de entidad.
	 * @param adminItem
	 * @return Entidad admin
	 */
	public static Admin getAdmin(AdminItem adminItem){
		Admin admin=null;
		if (adminItem!=null){
			admin=new Admin();
			admin.setId(adminItem.getId());
			admin.setName(adminItem.getName());
			admin.setSurname1(adminItem.getSurname1());
			admin.setSurname2(adminItem.getSurname2());
			admin.setEmail(adminItem.getEmail());
			admin.setPwd(adminItem.getPwd());
			admin.setIsCiaAdmin( (byte)(adminItem.isCiaAdmin() ? 1 : 0 ) );
		}
		return admin;
		
	}
	/**
	 * Convierte un objeto de entidad en un item de administrador (POJO).
	 * @param admin
	 * @return
	 */
	public static AdminItem getAdminItem(Admin admin){
		AdminItem adminItem=null;
		if (admin!=null){
			adminItem=new AdminItem();
			adminItem.setId(admin.getId());
			adminItem.setName(admin.getName());
			adminItem.setSurname1(admin.getSurname1());
			adminItem.setSurname2(admin.getSurname2());
			adminItem.setEmail(admin.getEmail());
			adminItem.setPwd(admin.getPwd());
			adminItem.setCiaAdmin(admin.getIsCiaAdmin()!=0);
		}
		return adminItem;
	}
	/**
	 * Convierte un objeto de entidad en un item de instalación (POJO).
	 * @param entidad instalación.
	 * @return
	 */
	public static FacilityItem getFacilityItem(Facility facility){
		FacilityItem facilityItem=null;
		if ( facility!=null ){
			facilityItem=new FacilityItem();
			facilityItem.setId(facility.getId());
			facilityItem.setDescription(facility.getDescription());
			facilityItem.setLast_test(facility.getLastTest());
			facilityItem.setName(facility.getName());
			facilityItem.setZipcode(facility.getZipcode());
		}
		return facilityItem;
	}
	/**
	 * Convierte un item de instalación (POJO) en una entidad.
	 * @param facilityItem Instalación
	 * @return
	 */
	public static Facility getFacility(FacilityItem facilityItem){
		Facility facility=null;
		if ( facilityItem!=null ){
			facility=new Facility();
			facility.setId(facilityItem.getId());
			facility.setDescription(facilityItem.getDescription());
			facility.setLastTest(facilityItem.getLast_test());
			facility.setName(facilityItem.getName());
			facility.setZipcode(facilityItem.getZipcode());
		}
		return facility;
	}
	
}	
	
	
