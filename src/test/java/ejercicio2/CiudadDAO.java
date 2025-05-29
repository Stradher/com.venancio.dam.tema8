package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO {
	private static Connection crearConexion() throws SQLException {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciudad_db", "root", "");
		return conexion;
	}

	public static List<Ciudad> devolverCiudades() throws SQLException {
		List<Ciudad> resultado = new ArrayList<Ciudad>();

		try (Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM ciudad")) {
			ResultSet rs = consulta.executeQuery();

			while (rs.next()) {
				Ciudad ciudad = new Ciudad(rs.getInt("id"), rs.getString("nombre"), rs.getInt("habitantes"),
						RestauranteDAO.devolverRestaurantesCiudad(rs.getInt("id")));
				resultado.add(ciudad);
			}
		}
		return resultado;
	}

	public static float calcularPrecioMedio(int id_ciudad) throws SQLException{
		float sumatorio = 0;
		float resultado = 0;
		List<Restaurante> restaurantes = RestauranteDAO.devolverRestaurantesCiudad(id_ciudad);
		
		for(Restaurante restaurante : restaurantes) {
			sumatorio = restaurante.calcularPrecioMedio(); 
		}
		
		resultado = sumatorio / restaurantes.size();
		
		return resultado;
		
	}

}
