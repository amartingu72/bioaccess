package vector.bioaccess.repositories;

import java.util.List;

import vector.bioaccess.model.Facility;

public interface FacilityDAO {
	
	/**
	 * Devuelve la lista de instalaciones asociadas al usuario.
	 * Nota: no contempla si es o no adminisrtador de CIA. Solo busca en la tabla admins_facilities 
	 * las relaciones.
	 * @param adminId ID de administrador.
	 * @return Lista de instalaciones.
	 */
	public List<Facility> getFacilities(int adminId);
	
	/**
	 * Devuelve todas las intalaciones existentes.
	 * @return Lista de instalaciones.
	 */
	public List<Facility> getAllFacilities();
}
