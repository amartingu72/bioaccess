package vector.bioaccess.helpers;

import java.sql.Timestamp;



public class FacilityItem {
	private int id;
	private String name;
	private String description;
	private Timestamp last_test;
	private String zipcode;
	
	
	//GETTERs y SETTERs
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getLast_test() {
		return last_test;
	}
	public void setLast_test(Timestamp last_test) {
		this.last_test = last_test;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
