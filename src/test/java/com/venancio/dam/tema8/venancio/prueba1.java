package com.venancio.dam.tema8.venancio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class prueba1 {
	public static void main(String[] args) {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "");
				Statement consulta = conexion.createStatement()) {
			String sentencia = "SELECT * FROM city WHERE Name='Salamanca' ";
			
			ResultSet rs = consulta.executeQuery(sentencia);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String countryCode = rs.getString("CountryCode");
				String district = rs.getString("District");
				int population = rs.getInt("Population");
				
				Ciudad ciudad = new Ciudad(id, name, countryCode, district, population);
				ciudades.add(ciudad);
				System.out.println(ciudades);
				
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
