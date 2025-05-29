package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestauranteDAO {
	private static Connection crearConexion() throws SQLException {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciudad_db", "root", "");
		return conexion;
	}
	
	public static List<Restaurante> devolverRestaurante() throws SQLException{
		List<Restaurante> resultado = new ArrayList<Restaurante>();
		
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM restaurante")){
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next()) {
				Restaurante restaurante = new Restaurante(rs.getInt("id"), rs.getString("nombre"), rs.getInt("capacidad"), PlatoDAO.devolverPlatosRestaurante(rs.getInt("id")));
				resultado.add(restaurante);
				
			}
		}
		return resultado;
	}
	
	public static List<Restaurante> devolverRestaurantesCiudad(int id_ciudad) throws SQLException{
		List<Restaurante> resultado = new ArrayList<Restaurante>();
		
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM restaurante WHERE ciudad_id = ?")){
			consulta.setInt(1, id_ciudad);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next()) {
				Restaurante restaurante = new Restaurante(rs.getInt("id"), rs.getString("nombre"), rs.getInt("capacidad"), PlatoDAO.devolverPlatosRestaurante(rs.getInt("id")));
				resultado.add(restaurante);
			}
		}
		
		return resultado;
	}

	
	
}
