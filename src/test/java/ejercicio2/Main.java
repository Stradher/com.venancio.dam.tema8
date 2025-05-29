package ejercicio2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int decision = -1;
		
		while(decision != 0) {
			mostrarMenu();
			decision = sc.nextInt();
			sc.nextLine();
			
			switch(decision) {
			case 1:
				mostrarCiudades();
				break;
			case 2:
				mostrarRestaurantes();
				break;
			case 3:
				mostrarPlatos();
				break;
			case 4:
				mostrarPreciosMedios();
				break;
			case 5:
				mostrarRestaurantesMasCarosPorCiudad();
				break;
			case 6:
				mostrarRestaurantesMasBaratosPorCiudad();
				break;
			}
		}
	}

	public static  void mostrarMenu() {
		System.out.println("SELECCIONE UNA OPCIÓN: ");
		System.out.println("0-SALIR");
		System.out.println("1-MOSTRAR CIUDADES");
		System.out.println("2- MOSTRAR RESTAURANTES");
		System.out.println("3- MOSTRAR PLATOS");
		System.out.println("4- MOSTRAR PRECIOS MEDIOS");
		System.out.println("5- MOSTRAR RESTAURANTES MAS CAROS POR CIUDAD: ");
		System.out.println("6- MOSTRAR RESTAURANTES MAS BARATOS POR CIUDAD: ");
	}
	
	public static  void mostrarCiudades() {
		try {
			System.out.println(CiudadDAO.devolverCiudades());
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void mostrarRestaurantes() {
		try {
			System.out.println(RestauranteDAO.devolverRestaurante());
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void mostrarPlatos() {
		try {
			System.out.println(PlatoDAO.devolverPlatos());
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void mostrarPreciosMedios() {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		try {
			ciudades = CiudadDAO.devolverCiudades();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		for(Ciudad ciudad : ciudades) {
			ciudad.imprimirCiudad();
			for(Restaurante restaurante :ciudad.getRestaurantes()) {
				restaurante.imprimirRestaurante();
			}
		}
	}
	
	public static void mostrarRestaurantesMasCarosPorCiudad() {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		try {
			ciudades = CiudadDAO.devolverCiudades();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		for(Ciudad ciudad : ciudades) {
			ciudad.imprimirCiudad();
			try {
				System.out.println(ciudad.restauranteMasCaro());
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	public static void mostrarRestaurantesMasBaratosPorCiudad() {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		try {
			ciudades = CiudadDAO.devolverCiudades();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		for(Ciudad ciudad : ciudades) {
			ciudad.imprimirCiudad();
			try {
				System.out.println(ciudad.restauranteMasBarato());
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
