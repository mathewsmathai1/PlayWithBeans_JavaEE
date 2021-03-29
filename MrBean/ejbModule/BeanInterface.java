import java.rmi.RemoteException;

import javax.ejb.*;
@Remote
 public interface BeanInterface extends EJBObject{

 public String businessFunc();

}