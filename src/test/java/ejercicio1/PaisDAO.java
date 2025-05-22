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
	public static Pais devolverPaisPorCodigo() throws SQLException{
		Pais resultado = null;
		
		try(Connection conexion = crearConexion();
				PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM Country WHERE Code = ?")){
			
		}
		return null; 
	}
	
	
}
