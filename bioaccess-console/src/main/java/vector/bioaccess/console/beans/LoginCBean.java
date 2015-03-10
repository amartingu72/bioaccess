package vector.bioaccess.console.beans;

import java.io.Serializable;

public class LoginCBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private LoginBBean loginBBean;  //Inyectado 
	
	/**
	 * Comprueba usuario y contraseña y carga el bean de sesión con las caracterísiticas nuevas.
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
