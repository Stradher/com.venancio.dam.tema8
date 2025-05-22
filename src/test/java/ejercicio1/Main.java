package ejercicio1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int decision = -1;
		
		while(decision!=0) {
			mostrarMenu();
			decision = sc.nextInt();
			sc.nextLine(); 
			
			switch(decision) {
			case 1:
				mostrarCiudadesOrdenadasPorId();
				break;
			case 2:
				mostrarCiudadesOrdenadasPorHabitantes();
				break;
			case 3:
				mostrarPaisesOrdenadosPorCodigo();
				break;
			case 4:
				mostrarPaisesOrdenadosPorHabitantes();
				break;
			case 5:
				mostrarCiudadPorId(sc);
				break;
			case 6:
				mostrarCiudadPorNombre(sc);
				break;
			}
		}
	}
	
	//MÉTODO PARA MOSTRAR EL MENÚ
	public static void mostrarMenu() {
		System.out.println("SELECCIONE UNA OPCIÓN: ");
		System.out.println("0- SALIR");
		System.out.println("1- MOSTRAR CIUDADES ORDENADAS POR ID");
		System.out.println("2- MOSTRAR CIUDADES ORDENADAS POR HABITANTES");
		System.out.println("3- MOSTRAR PAISES ORDENADOS POR CÓDIGO");
		System.out.println("4- MOSTRAR PAISES ORDENADOS POR HABITANTES");
		System.out.println("5- MOSTRAR CIUDAD POR ID");
		System.out.println("6- MOSTRAR CIUDAD POR NOMBRE");

	}
	
	//MÉTODO PARA MOSTRAR TODAS LAS CIUDADES ORDENADAS POR ID
	public static void mostrarCiudadesOrdenadasPorId() {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		try {
			ciudades = CiudadDAO.devolverCiudadesOrdenadasPorId();
			System.out.println(ciudades);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	//MÉTODO PARA MOSTRAR TODAS LAS CIUDADES ORDENADAS POR HABITANTES
	public static void mostrarCiudadesOrdenadasPorHabitantes() {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		try {
			ciudades = CiudadDAO.devolverCiudadesOrdenadasPorPoblacion();
			System.out.println(ciudades);
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}
	}
	
	//MÉTODO PARA MOSTRAR TODOS LOS PAISES ORDENADOS POR CÓDIGO
	public static void mostrarPaisesOrdenadosPorCodigo() {
		List<Pais> paises = new ArrayList<Pais>();
		try {
			paises = PaisDAO.devolverPaisesPorCodigo();
			System.out.println(paises);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	//MÉTODO PARA MOSTRAR TODOS LOS PAISES ORDENADOS POR HABITANTES
	public static void mostrarPaisesOrdenadosPorHabitantes() {
		List<Pais> paises = new ArrayList<Pais>();
		try {
			paises = PaisDAO.devolverPaisesPorHabitantes();
			System.out.println(paises);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	//METODO PARA MOSTRAR UNA CIUAD POR ID
	public static void mostrarCiudadPorId(Scanner sc) {
		System.out.println("INTRODUZCA EL ID DE LA CIUDAD");
		int id = sc.nextInt();
		sc.nextLine();
		
		try {
			Ciudad ciudad = CiudadDAO.devolverCiudadPorID(id);
			System.out.println(ciudad);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	//METODO PARA MOSTRAR UNA CIUAD POR NOMBRE
		public static void mostrarCiudadPorNombre(Scanner sc) {
			System.out.println("INTRODUZCA EL NOMBRE DE LA CIUDAD");
			String nombre = sc.nextLine();
			
			try {
				List<Ciudad> ciudades = CiudadDAO.DevolverCiudadPorNombre(nombre);
				System.out.println(ciudades);
			}catch(SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	
	
}
