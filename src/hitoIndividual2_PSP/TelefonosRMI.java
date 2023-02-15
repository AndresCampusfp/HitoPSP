package hitoIndividual2_PSP;

	import java.rmi.RemoteException;
	import java.rmi.server.UnicastRemoteObject;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class TelefonosRMI extends UnicastRemoteObject implements TelefonosInterfaceRMI {

	    Scanner sc = new Scanner(System.in);
	    Connection conexion;

	    protected TelefonosRMI() throws RemoteException {
	        super();
	    }

	    private static final long serialVersionUID = 1L;
	    private static final String Url = "jdbc:mysql://127.0.0.1:3306/telefonos?useSSL=false&serverTimezone=UTC";
	    private static final String usuario = "root";
	    private static final String password = "campusfp";

	    @Override
	    public void actualizar() throws RemoteException {
	        try {
	        	

	            
	            System.out.println("Introduce el modelo del Movil: ");
	            String Modelo = sc.nextLine();
	            
	            System.out.println("Introduce la marca: ");
	            String Marca = sc.nextLine();



	            System.out.println("Introduce el color: ");
	            String Color = sc.nextLine();

	            System.out.println("Introduzca el precio: ");
	            String Precio = sc.nextLine();

	            conexion = DriverManager.getConnection(Url, usuario, password);

	            PreparedStatement p = (PreparedStatement) conexion.prepareStatement(
	                    "Update datosTelefonos set Modelo= '"+Modelo+"',Color= '"+Color+"',Precio= '"+Precio+"' where Marca = "+Marca+"");

	            p.executeUpdate();
	            System.out.println("Actualizado");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Override
	    public void insertar() throws RemoteException {
	        try {
	            conexion = DriverManager.getConnection(Url, usuario, password);
	            PreparedStatement p = (PreparedStatement) conexion.prepareStatement("INSERT INTO datosTelefonos(Marca,Modelo,Color,Precio) VALUES (?,?,?,?)");

	            
	            System.out.println("Inserte marca:");
	            String Marca= sc.nextLine();
	            
	            System.out.println("Inserte modelo:");
	            String Modelo= sc.nextLine();

	            System.out.println("Inserte color:");
	            String Color= sc.nextLine();

	            System.out.println("Inserte precio:");
	            String Precio= sc.nextLine();

	            p.setString(1, Marca);
	            p.setString(2, Modelo);
	            p.setString(3, Color);
	            p.setString(4, Precio);
	            p.executeUpdate();

	            System.out.println("Se ha insertado correctamente");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void eliminar() throws RemoteException {
	        try {
	            conexion = DriverManager.getConnection(Url, usuario, password);

	            System.out.println("Introduzca el modelo a borrar: ");
	            int Modelo = sc.nextInt();

	            PreparedStatement p = (PreparedStatement) conexion.prepareStatement("DELETE FROM datosTelefonos WHERE id= " + Modelo + " ;");
	            System.out.println("Se ha eliminado correctamente");
	            p.execute();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
