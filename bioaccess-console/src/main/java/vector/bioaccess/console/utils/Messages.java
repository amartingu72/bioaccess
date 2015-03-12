package vector.bioaccess.console.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
/**
 * Gestiona los mensajes que desde los beans enviaremos a la página <p:messages>
 * El archivo de donde se obtienen coincide con el utilizado para los literales de las páginas. 
 * @author Alberto Martin
 *
 */
public class Messages {
	private static final String BUNDLE_NAME = "vector.bioaccess.console.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
