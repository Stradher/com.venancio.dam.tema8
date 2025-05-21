package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

public class CiudadDAO {
	private static Connection creaConexion() throws SQLException {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "");
		return conexion;
	}
	
	public List<Ciudad> mostrarCiudadesOrdenadasPorId() throws SQLException{
		
		try(Connection conexion = creaConexion();
		PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM city order by ID");){
					ResultSet resultadoConsulta = consulta.executeQuery();
					while(resultadoConsulta.next()) {
						Ciudad ciudad = new Ciudad(resultadoConsulta.getInt("ID"), null, null, null, 0);
						//crear la ciudad y añadirla a la lista que hay que crear arriba
					}

		}
		
		return null; //PARA QUE ME DEJE GUARDAR SIN ERRORES
	}
}
