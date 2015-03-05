package vector.bioaccess.ws;


import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;



@Component
public class PermissionRepository {
	

	@PostConstruct
	public void initData() {
		
	}
	
	

	
	/**
	 * Indica si el usuario tiene o no permisos para franquear el acceso gestionado por el controlador de dispositivo indicado.
	 * @param userId Identificador de usuario.
	 * @param controller Nombre del controlador (hostname)
	 * @return
	 */
	public boolean hasAccess(int userId, int facilityId, String controller) {
	
		return controller.equals("HALL01");
	}
}