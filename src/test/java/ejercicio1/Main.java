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
			case 7:
				mostrarPaisPorCodigo(sc);
				break;
			case 8:
				mostrarPaisPorNombre(sc);
				break;
			case 9:
				mostrarCiudadesDeUnPaisPorCodigo(sc);
				break;
			case 10:
				introducirPais(sc);
				break;
			case 11:
				introducirCiudad(sc);
				break;
			case 12:
				modificarPoblacionPais(sc);
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
		System.out.println("7- MOSTRAR PAIS POR CÓDIGO");
		System.out.println("8- MOSTRAR PAIS POR NOMBRE");
		System.out.println("9- MOSTRAR TODAS LAS CIUDADES DE UN PAIS POR CÓDIGO");
		System.out.println("10- AÑADIR UN PAÍS");
		System.out.println("11- AÑADIR UNA CIUDAD");
		System.out.println("12- MODIFICAR POBLACIÓN DE UN PAÍS");




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
		
	//METODO PARA MOSTRAR UN PAIS POR CODIGO
		public static void mostrarPaisPorCodigo(Scanner sc) {
			System.out.println("INTRODUZCA EL CODIGO DEL PAIS");
			String codigo = sc.nextLine().toUpperCase();
			
			try {
				Pais pais = PaisDAO.devolverPaisPorCodigo(codigo);
				System.out.println(pais);
			}catch(SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		
	//METODO PARA MOSTRAR UN PAIS POR NOMBRE
		public static void mostrarPaisPorNombre(Scanner sc) {
			System.out.println("INTRODUZCA EL NOMBRE DEL PAIS");
			String nombre = sc.nextLine();
			
			try {
				Pais pais = PaisDAO.devolverPaisPorNombre(nombre);
				System.out.println(pais);
				if(pais==null) {
					System.out.println("NO EXISTE NINGÚN PAÍS CON EL NOMBRE INDICADO");
					return;
				}
			}catch(SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		
	//METODO PARA MOSTRAR LAS CIUDADES DE UN PAÍS POR CÓDIGO
		public static void mostrarCiudadesDeUnPaisPorCodigo(Scanner sc) {
			System.out.println("INTRODUZCA EL CÓDIGO DEL PAIS");
			String codigo = sc.nextLine();
			
			try {
				List<Ciudad> ciudades = CiudadDAO.DevolverCiudadesPorCodigoPais(codigo);
				System.out.println(ciudades);
			}catch(SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	
	//METODO PARA AÑADIR UN PAIS
		public static void introducirPais(Scanner sc) {
			System.out.println("INTRODUZCA NOMBRE: ");
			String nombre = sc.nextLine();
			
			try {
				if(PaisDAO.devolverPaisPorNombre(nombre)!=null) {
					System.out.println("YA EXISTE UN PAÍS CON ESE NOMBRE");
					return;
				}
			}catch(SQLException e) {
				System.err.println(e.getMessage());
			}
			
			System.out.println("INTRODUZCA CÓDIGO");
			String codigo = sc.nextLine().toUpperCase();
			
			try {
				if(PaisDAO.devolverPaisPorCodigo(codigo)!=null) {
					System.out.println("YA EXISTE UN PAÍS CON ESE CÓDIGO");
					return;
				}
			}catch(SQLException e) {
				e.getMessage();
			}
			
			System.out.println("INTRODUZCA CONTINENTE: ");
			String continente = sc.nextLine();
			System.out.println("INTRODUZCA REGIÓN");
			String region = sc.nextLine();
			System.out.println("INTRODUZCA HABITANTES");
			int habitantes = sc.nextInt();
			sc.nextLine();
			
			Pais pais = new Pais(codigo, nombre, continente, region, habitantes);
			
			try {
				PaisDAO.aniadirPais(pais);
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		
	//METODO PARA AÑADIR UNA CIUDAD
		public static void introducirCiudad(Scanner sc) {
			System.out.println("INTRODUZCA CODIGO DEL PAIS: ");
			String codigo = sc.nextLine();
			
			try {
				if(PaisDAO.devolverPaisPorCodigo(codigo)==null) {
					System.out.println("No existe ningún país con ese código");
					return;
				}
			}catch(SQLException e) {
				System.err.println(e.getMessage());
			}
			
			System.out.println("INTRODUZCA NOMBRE");
			String nombre = sc.nextLine();
			System.out.println("INTRODUZCA DISTRITO");
			String distrito = sc.nextLine();
			System.out.println("INTRODUZCA POBLACION");
			int poblacion = sc.nextInt();
			sc.nextLine();
			
			Ciudad ciudad = new Ciudad(nombre, codigo, distrito, poblacion);
			
			try {
				CiudadDAO.aniadirCiudad(ciudad);
			}catch(SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		
	//METODO PARA MODIFICAR LA POBLACION DE UN PAIS
		public static void modificarPoblacionPais(Scanner sc){
			Pais pais = null;
			System.out.println("INTRODUZCA EL CODIGO DEL PAIS: ");
			String codigo = sc.nextLine();
			
			try {
				pais = PaisDAO.devolverPaisPorCodigo(codigo);
			}catch(SQLException e) {
				System.err.println(e.getMessage());
			}
			
			if(pais==null) {
				System.out.println("NO EXISTE NINGÚN PAÍS CON ESE CÓDIGO");
				return;
			}
			
			System.out.println("INTRODUZCA LA NUEVA POBLACIÓN");
			int poblacion = sc.nextInt();
			sc.nextLine();
			
			try {
				PaisDAO.modificarPoblacionPais(pais, poblacion);
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
}
