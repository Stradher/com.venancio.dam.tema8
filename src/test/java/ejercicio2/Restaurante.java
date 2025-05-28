package ejercicio2;

import java.util.List;

public class Restaurante {
	private int idRestaurante;
	private String nombre;
	private List<Plato> platos;
	private int capacidad;
	
	public Restaurante(int idRestaurante, String nombre, int capacidad) {
		this.idRestaurante = idRestaurante;
		this.nombre = nombre;
		this.capacidad = capacidad;
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}
	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "\n \t Restaurante [idRestaurante=" + idRestaurante + ", nombre=" + nombre + ", platos=" + platos
				+ ", capacidad=" + capacidad + "]";
	}
	
	
	
	
	
	
}
