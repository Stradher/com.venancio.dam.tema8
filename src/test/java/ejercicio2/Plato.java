package ejercicio2;

public class Plato {
	private int idPlato;
	private String nombre;
	private float precio;
	
	public Plato(int idPlato, String nombre, float precio) {
		this.idPlato = idPlato;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getIdPlato() {
		return idPlato;
	}
	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "\n \t \t Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
	
	
}
