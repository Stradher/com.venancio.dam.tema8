package ejercicio2;

import java.sql.SQLException;
import java.util.List;

public class Ciudad {
	
	private int idCiudad;
	private String nombre;
	private int habitantes;
	private List<Restaurante> restaurantes;
	
	public Ciudad(int idCiudad, String nombre, int habitantes) {
		this.idCiudad = idCiudad;
		this.nombre = nombre;
		this.habitantes = habitantes;		
	}
	
	public Ciudad(int idCiudad, String nombre, int habitantes, List<Restaurante> restaurantes) {
		this.idCiudad = idCiudad;
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.restaurantes = restaurantes;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}

	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	@Override
	public String toString() {
		return "\n Ciudad [idCiudad=" + idCiudad + ", nombre=" + nombre + ", habitantes=" + habitantes + ", restaurantes="
				+ restaurantes + "] \n";
	}
	
	public void imprimirCiudad() {
		try {
		System.out.println();
		System.out.println(nombre + " " + CiudadDAO.calcularPrecioMedio(idCiudad) + "€");
		System.out.println("========");
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public Restaurante restauranteMasCaro() throws SQLException {
		float precioMax = 0;
		Restaurante resultado = null;
		
		for(Restaurante restaurante : restaurantes) {
			if(restaurante.calcularPrecioMedio()>precioMax) {
				precioMax = restaurante.calcularPrecioMedio();
				resultado = restaurante;
			}
		}
		
		return resultado;
	}
	
	public Restaurante restauranteMasBarato() throws SQLException {
		float precioMin = 999999;
		Restaurante resultado = null;
		
		for(Restaurante restaurante : restaurantes) {
			if(restaurante.calcularPrecioMedio()<precioMin) {
				precioMin = restaurante.calcularPrecioMedio();
				resultado = restaurante;
			}
		}
		
		return resultado;
	}
	
	
	
	
	
}
