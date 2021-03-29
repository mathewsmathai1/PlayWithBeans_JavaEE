import java.rmi.RemoteException;

import javax.ejb.*;

public interface BeanHome extends EJBHome {
	
	public BeanInterface create() throws CreateException, RemoteException;

}
