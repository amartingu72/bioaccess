package vector.bioaccess.console.beans;

import java.io.Serializable;

public class LoginBBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String user;
	private String pwd;
	
	
	//GETTERs y SETTERs
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
