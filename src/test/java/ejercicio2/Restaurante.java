package ejercicio2;

import java.sql.SQLException;
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
	
	public Restaurante(int idRestaurante, String nombre, int capacidad, List<Plato> platos) {
		this.idRestaurante = idRestaurante;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.platos = platos;
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
				+ ", capacidad=" + capacidad + "] \n";
	}
	
	public void imprimirRestaurante() {
		try {
			System.out.println(nombre + " " + calcularPrecioMedio() + "€");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public float calcularPrecioMedio() throws SQLException{
		float sumatorio = 0;
		float resultado = 0;
		List<Plato> platos = PlatoDAO.devolverPlatosRestaurante(idRestaurante);
		
		for(Plato plato : platos) {
			sumatorio += plato.getPrecio();
		}
		
		resultado = sumatorio / platos.size();
		
		return resultado;
	}
	
	
	
}
