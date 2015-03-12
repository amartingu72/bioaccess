package vector.bioaccess.services;

import java.util.List;

import vector.bioaccess.helpers.AdminItem;
import vector.bioaccess.helpers.FacilityItem;
import vector.bioaccess.services.excp.AdminNotFoundException;
import vector.bioaccess.services.excp.DuplicatedAdminException;

public interface AdminDataProvider {
	/**
	 * Devuelve el adminsitrador con id indicado en el parámetro.
	 * @param adminId Id de administrador.
	 * @return Item de administrador o null si no lo encuentra.
	 */
	public AdminItem load(int adminId);
	
	/**
	 * Devuelve el administrador con email indicado en el parámetro.
	 * @param email Email del administrador a buscar.
	 * @return Item de adminstrador o null si no lo encuentra.
	 */
	public AdminItem load(String email);
	
	/**
	 * Crea un nuevo adminstrador para la lista de instalaciones indicada.
	 * @param adminItem Item con los datos del nuevo administrador. El Id se ignora.
	 * @return Item de administrador con los datos y el ID asignado. 
	 * @return facilities Lista de instalaciones a las que queda vinculado
	 * @throws DuplicatedAdminException Indica que email de administrador ya existe en el sistema.
	 */
	public AdminItem create(AdminItem adminItem, List<FacilityItem> facilities) throws DuplicatedAdminException;

		
	/**
	 * Actualiza un administrador
	 * @param adminItem Permite localizar el administrador (id) e incluye los datos a actualizar.
	 * @throws AdminNotFoundException Indica que el id de administrador no se encuentra.
	 */
	public void update(AdminItem adminItem) throws AdminNotFoundException;
	
	/**
	 * Elimina el administrador con el ID indicado en el parámetro.
	 * @param adminId ID de administrador.
	 * @throws AdminNotFoundException Indica que el id de administrador no se encuentra.
	 */
	public void delete(int adminId) throws AdminNotFoundException;
}
