package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO {
	private static Connection crearConexion() throws SQLException {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "");
		return conexion;
	}
	
	//MÉTODO QUE DEVUELVE LOS PAÍSES ORDENADOS POR CÓDIGO
	public static List<Pais> devolverPaisesPorCodigo() throws SQLException {
		List<Pais> resultado = new ArrayList<Pais>();
		
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM Country ORDER BY Code")){
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next()) {
				Pais pais = new Pais(rs.getString("Code"),rs.getString("Name"),rs.getString("Continent"),rs.getString("Region"),rs.getInt("Population"));
				resultado.add(pais);
			}
		}
		return resultado;
	}
	
	//MÉTODO QUE DEVUELVE LOS PAISES ORDENADOS POR HABITANTES
	public static List<Pais> devolverPaisesPorHabitantes() throws SQLException{
		List<Pais> resultado = new ArrayList<Pais>();
		
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM Country ORDER BY Population")){
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next()) {
				Pais pais = new Pais(rs.getString("Code"),rs.getString("Name"),rs.getString("Continent"),rs.getString("Region"),rs.getInt("Population"));
				resultado.add(pais);
			}
		}
		return resultado;
	}
	
	//METODO QUE DEVUELVE UN PAIS POR CODIGO
	public static Pais devolverPaisPorCodigo(String codigo) throws SQLException{
		Pais resultado = null;
		
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM Country WHERE Code = ?")){				
				consulta.setString(1, codigo);
				ResultSet rs = consulta.executeQuery();
				
				
				if(rs.next()) {
					resultado = new Pais(rs.getString("Code"),rs.getString("Name"),rs.getString("Continent"),rs.getString("Region"),rs.getInt("Population"));
				}
		}
		return resultado; 
	}
	
	//METODO QUE DEVUELVE UN PAIS POR NOMBRE
	public static Pais devolverPaisPorNombre(String nombre) throws SQLException{
		Pais resultado = null;
		
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM Country WHERE Name = ?")){
			consulta.setString(1, nombre);
			ResultSet rs = consulta.executeQuery();
			
			if(rs.next()) {
				resultado = new Pais(rs.getString("Code"),rs.getString("Name"),rs.getString("Continent"),rs.getString("Region"),rs.getInt("Population"));

			}
		}
		return resultado;
	}
	
	//METODO PARA AÑADIR UN NUEVO PAIS
	public static boolean aniadirPais(Pais pais) throws SQLException {
		String code = pais.getCountryCode();
		String name = pais.getName();
		String continent = pais.getContinent();
		String region = pais.getRegion();
		int population = pais.getPopulation();
		
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("INSERT INTO country (Code, Name, Continent, Region, Population) VALUES (?, ?, ?, ?, ?)")){
			consulta.setString(1, code);
			consulta.setString(2, name);
			consulta.setString(3, continent);
			consulta.setString(4, region);
			consulta.setInt(5, population);
			
			consulta.executeUpdate();
			System.out.println("PAIS AÑADIDO CORRECTAMENTE");
			return true;
		}
	}
	
	//METODO PARA MODIFICAR LA POBLACION DEL PAIS
	public static boolean modificarPoblacionPais(Pais pais, int newPopulation) throws SQLException{
		String code = pais.getCountryCode();
		
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("select sum(population) from city where CountryCode = ?")){
			consulta.setString(1, code);
			
			ResultSet rs = consulta.executeQuery();
			
			int resultado = rs.getInt("Population");
			
			if(resultado>newPopulation) {
				System.out.println("LA POBLACIÓN NO PUEDE SER INFERIOR A LA ACTUAL");
				return false;
			}
			
		}
		
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("UPDATE country SET Population = ? WHERE Code = ?")){
			consulta.setString(1, code);
			consulta.setInt(2, newPopulation);
			
			consulta.executeUpdate();
			System.out.println("POBLACIÓN MODIFICADA CORRECTAMENTE");
			return true;
		}
	}
	
}
