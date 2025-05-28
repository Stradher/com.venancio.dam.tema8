package ejercicio2;

import java.sql.SQLException;
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
			}
		}
	}

	public static  void mostrarMenu() {
		System.out.println("SELECCIONE UNA OPCIÓN: ");
		System.out.println("0-SALIR");
		System.out.println("1-MOSTRAR CIUDADES");
		System.out.println("2- MOSTRAR RESTAURANTES");
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
}
