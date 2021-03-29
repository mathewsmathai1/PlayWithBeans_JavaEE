import java.rmi.RemoteException;

import javax.ejb.*;
@Local
public interface BeanHome extends EJBLocalHome {
	
	public BeanInterface create() throws CreateException, RemoteException;

}
