package vector.bioaccess.console.beans;

import java.io.Serializable;

public class LoginCBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private LoginBBean loginBBean;  //Inyectado 
	
	/**
	 * Comprueba usuario y contrase�a y carga el bean de sesi�n con las caracter�siticas nuevas.
	 * @return
	 */
	public String login(){
		return "login";
	}
	
	//GETTERs y SETTERs
	public LoginBBean getLoginBBean() {
		return loginBBean;
	}
	public void setLoginBBean(LoginBBean loginBBean) {
		this.loginBBean = loginBBean;
	}
	
}
