package vector.bioaccess.repositories;

import vector.bioaccess.model.User;

public interface UserDAO {
	
	public User loadUser(int userId); 

}
