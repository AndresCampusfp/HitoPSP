package hitoIndividual2_PSP;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		Registry Registro;

		try {
			Registro = LocateRegistry.getRegistry("192.168.1.134", 2402);
			String Url = "rmi://192.168.1.134:2402/telefonos";
			TelefonosRMI t = new TelefonosRMI();
			System.out.println("Registro Completado");
			Scanner sc = new Scanner(System.in);
			String opciones;

			do {
				System.out.println("Elije una opción");
				System.out.println("1-Inserta");
				System.out.println("2-Eliminar");
				System.out.println("3-Actualizar");
				System.out.println("4-Salir");
				opciones = sc.nextLine();

				switch (opciones) {

				case "1": {
					t.insertar();
					break;

				}

				case "2": {
					t.eliminar();
					break;
				}

				case "3": {
					t.actualizar();
					break;
				}

				case "4": {
					break;
				}

				default:
					System.out.println("Elije una opción válida");
				}

			} while (!opciones.equals("4"));

		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}
	}
}
