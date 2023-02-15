package hitoIndividual2_PSP;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TelefonosInterfaceRMI extends Remote {

		  public void insertar() throws RemoteException;

		  public void eliminar() throws RemoteException;

		  public void actualizar() throws RemoteException;

		}
