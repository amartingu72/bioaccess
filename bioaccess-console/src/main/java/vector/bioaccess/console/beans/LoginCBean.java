package vector.bioaccess.console.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import vector.bioaccess.console.utils.Messages;
import vector.bioaccess.console.utils.MyLogger;
import vector.bioaccess.helpers.AdminItem;
import vector.bioaccess.services.AdminDataProvider;

public class LoginCBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final MyLogger log = MyLogger.getLogger(LoginCBean.class.getName());
	private LoginSBean loginSBean;  //Inyectado 
	private AdminDataProvider adminDataProvider; //Inyectado
	
	/**
	 * Comprueba usuario y contraseña y carga el bean de sesión con las características nuevas.
	 * @return
	 */
	public String login(){
		AdminItem adminItem=adminDataProvider.load(loginSBean.getEmail());
		String result=null;
		if (adminItem==null || !adminItem.getPwd().equals(this.loginSBean.getPwd())) {
			//Login fallido
			FacesMessage fm = new FacesMessage(Messages.getString("login.msg.error")); 
			FacesContext.getCurrentInstance().addMessage(null, fm);
			log.log("001001");//INFO|Intento fallido de login.
		}
		else {
			//Accedemos a la aplicación
			result="login";
			//Completamos los datos del bean de sesión LoginSBean, del que recuperaremos los datos
			//del usuario logado cuando sea necesario.
			loginSBean.setCiaAdmin(adminItem.isCiaAdmin());
			loginSBean.setId(adminItem.getId());
			loginSBean.setName(adminItem.getName());
			loginSBean.setSurname1(adminItem.getSurname1());
			loginSBean.setSurname2(adminItem.getSurname2());
			//Incluimos la lista de comunidades administradas. En caso de admnistrador de CIA son todas.
			
			log.log("001000");//INFO|Intento exitoso de login. 
		}
		return result;
	}
	
	
	
	//GETTERs y SETTERs.
	public LoginSBean getLoginSBean() {
		return loginSBean;
	}

	public void setLoginSBean(LoginSBean loginSBean) {
		this.loginSBean = loginSBean;
	}

	public AdminDataProvider getAdminDataProvider() {
		return adminDataProvider;
	}

	public void setAdminDataProvider(AdminDataProvider adminDataProvider) {
		this.adminDataProvider = adminDataProvider;
	}
	
	
}
