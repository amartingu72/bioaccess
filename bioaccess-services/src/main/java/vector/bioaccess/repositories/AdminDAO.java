package vector.bioaccess.repositories;

import vector.bioaccess.model.Admin;

public interface AdminDAO {
	/**
	 * Devuelve la entidad admin para el administrador indicado en el ID
	 * @param id ID de admin.
	 * @return Administrador buscado.
	 */
	public Admin load(int id);
}
