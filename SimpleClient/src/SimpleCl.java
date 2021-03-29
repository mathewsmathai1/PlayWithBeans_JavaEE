import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import org.wildfly.naming.client.store.RelativeContext;
public class SimpleCl {

	public static void main(String[] args) throws NamingException, RemoteException, CreateException {
		
		BeanInterface hbean; // = new InitialContext();
		

         hbean =  createInitialContext();
         System.out.println(hbean.toString());
		

		//BeanInterface in = hbean.create();  
		//if you fetched BeanHome in initial lookup, you can call createmethod on home and receive a stub to remote object interface and then in.businessFunc()
		//Here we have directly fetched the remote object stub
		System.out.println(hbean.businessFunc());

		
	}
	
	 private static BeanInterface createInitialContext() throws NamingException {
	        final Hashtable jndiProperties = new Hashtable();
	        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:xxxx");
	        final Context context = new InitialContext(jndiProperties);
	        
	        // The app name is the application name of the deployed EJBs. This is typically the ear name
	        // without the .ear suffix. However, the application name could be overridden in the application.xml of the
	        // EJB deployment on the server.
	        // Since we haven't deployed the application as a .ear, the app name for us will be an empty string
	        final String appName = "BeanEAR";
	        // This is the module name of the deployed EJBs on the server. This is typically the jar name of the
	        // EJB deployment, without the .jar suffix, but can be overridden via the ejb-jar.xml
	        // In this example, we have deployed the EJBs in a jboss-as-ejb-remote-app.jar, so the module name is
	        // jboss-as-ejb-remote-app
	        final String moduleName = "MrBean";
	        // AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
	        // our EJB deployment, so this is an empty string
	        final String distinctName = "";
	        // The EJB name which by default is the simple class name of the bean implementation class
	        final String beanName = "MrBean";
	        // the remote view fully qualified class name
	        final String viewClassName = BeanInterface.class.getName();
	       // System.out.println(viewClassName);
	        //System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName)	  ;    
			// let's do the lookup
	        return (BeanInterface) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
	    }


}
