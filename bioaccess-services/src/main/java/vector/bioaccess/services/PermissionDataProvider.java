package vector.bioaccess.services;

public interface PermissionDataProvider {
	
	/**
	 * Devuelve si el usuario indicado en el parámetro puede franquear el paso gestionado
	 * por el controladeor de dispositivo con el nombre indicado
	 * @param userId Identificador de usuario.
	 * @param accessCtrlName Nombre del controlador de acceso.
	 * @return True si el usuario tiene permiso de acceso según su configuración y false si no lo tiene
	 */
	public abstract boolean hasAccess(int userId, String accessCtrlName);
}
