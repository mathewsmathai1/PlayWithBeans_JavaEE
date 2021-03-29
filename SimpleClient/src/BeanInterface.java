import java.rmi.RemoteException;

import javax.ejb.*;
@Local
 public interface BeanInterface extends EJBLocalObject{

 public String businessFunc();

}