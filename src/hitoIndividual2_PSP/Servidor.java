package hitoIndividual2_PSP;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
	
	public static void main(String[] args) throws UnknownHostException {

        String host="";
        int Puerto = 2402;

        try {
            host = InetAddress.getLocalHost().getHostAddress();
            Registry Registro = LocateRegistry.createRegistry(Puerto);
            TelefonosRMI t = new TelefonosRMI();
            String Url = "rmi://" + host + ":" + Puerto + "/telefonos";

            Registro.rebind(Url, t);
            System.out.println("Registrado en " + host);

        } catch (RemoteException e) {
            System.out.println("");
        }
    }
}
