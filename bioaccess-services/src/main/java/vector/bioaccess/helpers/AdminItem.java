package vector.bioaccess.helpers;

import vector.bioaccess.model.Admin;

public class AdminItem {
	private int id;
	private String name;
	private String surname1;
	private String surname2;
	private String email;
	private boolean isCiaAdmin;
	
	public AdminItem(Admin admin){
		id=admin.getId();
		name=admin.getSurname1();
		surname1=admin.getSurname1();
		surname2=admin.getSurname2();
		email=admin.getEmail();
		isCiaAdmin=admin.getIsCiaAdmin()!=0;
	}
	
	public AdminItem(){
		super();
	}
	
	//Getters y Setters.	
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
		return isCiaAdmin;
	}
	public void setCiaAdmin(boolean isCiaAdmin) {
		this.isCiaAdmin = isCiaAdmin;
	}
	
	
}
