package vector.bioaccess.repositories;


import vector.bioaccess.model.Admin;
import vector.bioaccess.model.Facility;

public interface AdminDAO {
	
	
	
	/**
	 * Devuelve la entidad admin para el administrador indicado en el parámetro.
	 * @param id ID de admin.
	 * @return Administrador buscado.
	 */
	public Admin load(int id);
	
	/**
	 * Devuelve la entidad admin para el administrador indicado en el parámetro.
	 * @param email. No se comprueba formato.
	 * @return Administrador buscado.
	 */
	public Admin load(String email);
	
	/**
	 * Crea un nuevo administrador
	 * @param admin
	 * @return Entidad de administrador creado.
	 */
	public Admin create(Admin admin);
	
	/**
	 * Asigna una lista de instalaciones a un administrador.
	 * @param admin Administrador
	 * @param facilities Lista de instalaciones.
	 */
	public void addFacility(Admin admin, Facility facility);
		
}
