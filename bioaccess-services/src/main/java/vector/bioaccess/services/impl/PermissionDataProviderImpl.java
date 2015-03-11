package vector.bioaccess.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;





import vector.bioaccess.repositories.UserDAO;
import vector.bioaccess.services.PermissionDataProvider;

@Service("permissionDataProvider")
public class PermissionDataProviderImpl implements PermissionDataProvider {

	@Resource(name="UsersRepository")
	private UserDAO usersRepository;
	
	
	public boolean hasAccess(int userId, String accessCtrlName) {
		
		return usersRepository.loadUser(userId)!=null;
	}

}
