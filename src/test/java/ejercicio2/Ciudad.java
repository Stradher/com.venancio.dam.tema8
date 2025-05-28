package ejercicio2;

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
		return "\n \t Ciudad [idCiudad=" + idCiudad + ", nombre=" + nombre + ", habitantes=" + habitantes + ", restaurantes="
				+ restaurantes + "]";
	}
	
	
	
	
	
	
}
