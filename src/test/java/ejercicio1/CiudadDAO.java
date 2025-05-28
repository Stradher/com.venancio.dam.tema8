package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

public class CiudadDAO {
	private static Connection creaConexion() throws SQLException {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "toor");
		return conexion;
	}

	// METODO QUE DEVUELVE LAS CIUDADES ORDENADAS POR ID
	public static List<Ciudad> devolverCiudadesOrdenadasPorId() throws SQLException {
		List<Ciudad> resultado = new ArrayList<Ciudad>();
		try (Connection conexion = creaConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM city order by ID");) {
			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Ciudad ciudad = new Ciudad(resultadoConsulta.getInt("ID"), resultadoConsulta.getString("Name"),
						resultadoConsulta.getString("CountryCode"), resultadoConsulta.getString("District"),
						resultadoConsulta.getInt("Population"));
				resultado.add(ciudad);
			}

		}
		return resultado;
	}

	// METODO QUE DEVUELVE LAS CIUADES ORDENADAS POR HABITANTES
	public static List<Ciudad> devolverCiudadesOrdenadasPorPoblacion() throws SQLException {
		List<Ciudad> resultado = new ArrayList<Ciudad>();

		try (Connection conexion = creaConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM city ORDER BY Population")) {
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next()) {
				Ciudad ciudad = new Ciudad(resultadoConsulta.getInt("ID"), resultadoConsulta.getString("Name"), resultadoConsulta.getString("CountryCode"), resultadoConsulta.getString("District"), resultadoConsulta.getInt("Population"));
				resultado.add(ciudad);
			}
		}
		return resultado;
	}
	
	//MÉTODO QUE DEVUELVE LA CIUAD INDICADA POR ID
	public static Ciudad devolverCiudadPorID(int id) throws SQLException{
		Ciudad ciudad = null;
		
		try(Connection conexion = creaConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM city WHERE ID = ?")){
			
			consulta.setInt(1, id);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next()) {
				ciudad = new Ciudad(resultadoConsulta.getInt("ID"), resultadoConsulta.getString("Name"), resultadoConsulta.getString("CountryCode"), resultadoConsulta.getString("District"), resultadoConsulta.getInt("Population"));
			}
		}
		return ciudad;
	}
	
	//MÉTODO QUE DEVUELVE LA CIUDAD INDICADA POR NOMBRE
	public static List<Ciudad> DevolverCiudadPorNombre(String nombre) throws SQLException{
		List<Ciudad> resultado = new ArrayList<Ciudad>();
		
		try(Connection conexion = creaConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM City WHERE Name = ?")){
			consulta.setString(1, nombre);
			ResultSet resultadoConsulta = consulta.executeQuery();
			
			while(resultadoConsulta.next()) {
				Ciudad ciudad = new Ciudad(resultadoConsulta.getInt("ID"), resultadoConsulta.getString("Name"), resultadoConsulta.getString("CountryCode"), resultadoConsulta.getString("District"), resultadoConsulta.getInt("Population"));
				resultado.add(ciudad);
			}
		}
		return resultado;
	}
	
	//MÉTODO QUE DEVUELVE LAS CIUDADES DE UN PAÍS POR CÓDIGO
	public static List<Ciudad> DevolverCiudadesPorCodigoPais(String codigo) throws SQLException{
		List<Ciudad> resultado = new ArrayList<Ciudad>();
		
		try(Connection conexion = creaConexion();
				PreparedStatement consulta = conexion.prepareStatement("select * from city where CountryCode = ? ORDER BY Name")) {
			consulta.setString(1, codigo);
			ResultSet resultadoConsulta = consulta.executeQuery();
			
			while(resultadoConsulta.next()) {
				Ciudad ciudad = new Ciudad(resultadoConsulta.getInt("ID"), resultadoConsulta.getString("Name"), resultadoConsulta.getString("CountryCode"), resultadoConsulta.getString("District"), resultadoConsulta.getInt("Population"));
				resultado.add(ciudad);
			}
		}
		return resultado;
	}
	
	//MÉTODO PARA INTRODUCIR UNA NUEVA CIUDAD
	public static boolean aniadirCiudad(Ciudad ciudad) throws SQLException{
		String nombre = ciudad.getName();
		String countryCode = ciudad.getCountryCode();
		String district = ciudad.getDistrict();
		int population = ciudad.getPopulation();
		
		try(Connection conexion = creaConexion();
				PreparedStatement consulta = conexion.prepareStatement("INSERT INTO city (Name, CountryCode, District, Population) VALUES (?, ?, ?, ?);")){
			consulta.setString(1, nombre);
			consulta.setString(2, countryCode);
			consulta.setString(3, district);
			consulta.setInt(4, population);
			
			consulta.executeUpdate();
			System.out.println("CIUDAD AÑADIDA CORRECTAMENTE");
			return true;
		}
	}
	
}
