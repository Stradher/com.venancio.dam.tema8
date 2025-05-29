package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlatoDAO {
	
	private static Connection crearConexion() throws SQLException {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciudad_db", "root", "");
		return conexion;
	}
	
	public static List<Plato> devolverPlatos() throws SQLException{
		List<Plato> resultado = new ArrayList<Plato>();
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM Plato")){
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next()) {
				Plato plato = new Plato(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("precio"));
				resultado.add(plato);
			}
		}
		return resultado;		
	}
	
	public static List<Plato> devolverPlatosRestaurante(int id_restaurante) throws SQLException{
		List<Plato> resultado = new ArrayList<Plato>();
		
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM plato WHERE restaurante_id = ?")){
			consulta.setInt(1, id_restaurante);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next()) {
				Plato plato = new Plato(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("precio"));
				resultado.add(plato);
			}
		}
		
		return resultado;
	}
}
