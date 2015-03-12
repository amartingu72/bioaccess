package vector.bioaccess.console.beans;

import java.io.Serializable;

/**
 * Contiene los datos del usuario que hace login.
 * 
 *  @author Alberto Martin
 * 
 */
public class LoginSBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String surname1;
	private String surname2;
	private String pwd;
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	private String email;
	private boolean ciaAdmin;
	
	//GETTERs y SETTERs.
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname1() {
		return surname1;
	}
	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}
	public String getSurname2() {
		return surname2;
	}
	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isCiaAdmin() {
		return ciaAdmin;
	}
	public void setCiaAdmin(boolean ciaAdmin) {
		this.ciaAdmin = ciaAdmin;
	}
	
	
	

}
