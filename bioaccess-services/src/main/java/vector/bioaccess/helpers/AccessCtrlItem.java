package vector.bioaccess.helpers;
/**
 * Controlador de acceso.
 * @author Alberto Martín
 *
 */
public class AccessCtrlItem {
	private int id;
	private String name;
	private String ip;
	private String description;
	private int status;
	private boolean exit;
	
	
	
	//GETTERS y SETTERs
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isExit() {
		return exit;
	}
	public void setExit(boolean exit) {
		this.exit = exit;
	}
	
	
}
