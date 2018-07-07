
import java.rmi.RemoteException;

import ru.specialist.service.*;

public class Program {

	public static void main(String[] args) throws RemoteException {
		System.out.println("Call web service...");
		MyService proxy = new MyServiceProxy();
		System.out.println(proxy.serverTime());

	}

}
