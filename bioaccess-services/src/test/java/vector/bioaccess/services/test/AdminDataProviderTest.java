package vector.bioaccess.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import vector.bioaccess.helpers.AdminItem;
import vector.bioaccess.model.Admin;
import vector.bioaccess.repositories.AdminDAO;
import vector.bioaccess.services.AdminDataProvider;
import vector.bioaccess.services.impl.AdminDataProviderImpl;



@RunWith(MockitoJUnitRunner.class) 
public class AdminDataProviderTest {

		@Mock
		AdminDAO adminsRepository;
			
		@InjectMocks
		AdminDataProvider adminDataProvider=new AdminDataProviderImpl();
	    
	    /**
	     * loadAdmin(id) con id de usuario válido
	     */
	    @Test
	    public void test01LoadAdmin() throws Exception{
	    	
	    	when ( adminsRepository.load(1) )
	        .thenAnswer( new Answer<Admin>() {
	            @Override
	            public Admin answer(InvocationOnMock invocation) throws Throwable {
	            	Admin admin=new Admin();
	            	admin.setId(1);
	            	admin.setEmail("a@vector.com");
	            	admin.setIsCiaAdmin((byte)0);
	            	admin.setName("Name");
	            	admin.setSurname1("ap01");
	            	admin.setSurname2("ap02");
	                return admin;
	            }
	        });
	    	
	    	AdminItem adminItem;
	    	adminItem=adminDataProvider.load(1);
	    	assertNotNull("No carga el usuario.",adminItem);
	    	assertEquals("Id no asignado.",1, adminItem.getId());
	    	assertEquals("Email.","a@vector.com", adminItem.getEmail());
	    	assertEquals("Nombre no asignado.","Name", adminItem.getName());
	    	assertEquals("Primer apellido no asignado.","ap01" ,adminItem.getSurname1());
	    	assertEquals("Segundo apellido no asignado.","ap02" ,adminItem.getSurname2());
	    	assertFalse("Indicador de administrador de CIA no asignado.", adminItem.isCiaAdmin());
	    
	    }
	    
	    /**
	     * loadAdmin(id) con id de usuario no válido
	     */
	    @Test
	    public void test02LoadAdmin() throws Exception{
	    	
	    	when ( adminsRepository.load(1) )
	        .thenAnswer( new Answer<Admin>() {
	            @Override
	            public Admin answer(InvocationOnMock invocation) throws Throwable {
	            	
	                return null;
	            }
	        });
	    	
	    	AdminItem adminItem;
	    	adminItem=adminDataProvider.load(1);
	    	assertEquals("Encuentra un usuario que no existe.",adminItem,null);
	    	
	    
	    }
	    
	    /**
	     * loadAdmin(email) con email de usuario válido
	     */
	    @Test
	    public void test03LoadAdmin() throws Exception{
	    	
	    	when ( adminsRepository.load("a@vector.com") )
	        .thenAnswer( new Answer<Admin>() {
	            @Override
	            public Admin answer(InvocationOnMock invocation) throws Throwable {
	            	Admin admin=new Admin();
	            	admin.setId(1);
	            	admin.setEmail("a@vector.com");
	            	admin.setIsCiaAdmin((byte)0);
	            	admin.setName("Name");
	            	admin.setSurname1("ap01");
	            	admin.setSurname2("ap02");
	                return admin;
	            }
	        });
	    	
	    	AdminItem adminItem;
	    	adminItem=adminDataProvider.load("a@vector.com");
	    	assertNotNull("No carga el usuario.",adminItem);
	    	assertEquals("Id no asignado.",1, adminItem.getId());
	    	assertEquals("Email.","a@vector.com", adminItem.getEmail());
	    	assertEquals("Nombre no asignado.","Name", adminItem.getName());
	    	assertEquals("Primer apellido no asignado.","ap01" ,adminItem.getSurname1());
	    	assertEquals("Segundo apellido no asignado.","ap02" ,adminItem.getSurname2());
	    	assertFalse("Indicador de administrador de CIA no asignado.", adminItem.isCiaAdmin());
	    
	    }
	    
	    /**
	     * loadAdmin(id) con id de usuario no válido
	     */
	    @Test
	    public void test04LoadAdmin() throws Exception{
	    	
	    	when ( adminsRepository.load("a@vector.com") )
	        .thenAnswer( new Answer<Admin>() {
	            @Override
	            public Admin answer(InvocationOnMock invocation) throws Throwable {
	            	
	                return null;
	            }
	        });
	    	
	    	AdminItem adminItem;
	    	adminItem=adminDataProvider.load("a@vector.com");
	    	assertEquals("Encuentra un usuario que no existe.",adminItem,null);
	    	
	    
	    }
}
