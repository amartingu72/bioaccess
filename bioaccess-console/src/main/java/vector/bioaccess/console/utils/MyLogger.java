package vector.bioaccess.console.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;

import vector.bioaccess.console.beans.LoginSBean;



public class MyLogger {
	
	private static final String BUNDLE_NAME = "vector.bioaccess.console.logs"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);
	/**
	 * Implementación de logger realmente utilizado.	
	 */
	private final Logger realLogger;

	/**
	 * Obtain a new or existing Logger instance. 
	 * @param name Name of the logger, package names are recommended
	 */
	public static MyLogger getLogger(String name) {
	    return new MyLogger(name);
	}
	
	public MyLogger(String name) {
	    realLogger = Logger.getLogger(name);
	}
		
	/**
	 * Graba en el log el mensaje, con el nivel indicado en log.properties. Al mensaje se añade la extensión.
	 * @param key
	 * @param extension Texto extra que se añade al indicado en logs.properties.
	 */
	public void log (String key, String extension) {
		String msg="";
		Level level=Level.ALL;
		//Obtengo el mensaje correspondiente a la clave.
		try {
			String value;
			value=RESOURCE_BUNDLE.getString(key);
			int p = value.indexOf('|');
			if (p >= 0) {
			    level=Level.parse(value.substring(0, p));
			    msg = value.substring(p + 1);
			} else {
				msg= '!' + key + '!' + "Formato de la clave de error incorrecta en archivo de mensajes de log.";
				level=Level.WARNING;
			}
		
						
		} catch (MissingResourceException e) {
			msg= '!' + key + '!' + "Clave de no encontrada en registro de mensajes de log.";
			level=Level.WARNING;
		}
		catch (IllegalArgumentException e) {
			msg= '!' + key + '!' + "El nivel de log indicado para la clave no es válido. Revise el archivo de mensajes de log.";
			level=Level.WARNING;
		}
				
		//El nombre de usuario que hizo login.
		LoginSBean loginSBean = (LoginSBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginSBean");
		String prefix="";
		if ( loginSBean != null) {
			prefix+="["+ loginSBean.getId()+"]";
		}
		realLogger.log(level,prefix+msg+extension);
	}
	
	/**
	 * Graba en el log el mensaje, con el nivel indicado en log.properties. Al mensaje se añade la extensión.
	 * @param key
	 */
	public void log (String key) {
		log(key,null);
	}
}
