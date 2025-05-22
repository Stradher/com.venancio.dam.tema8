package ejercicio1;
// codigoINT nombre continente región habitantesINT
public class Pais {
	private String countryCode;
	private String name;
	private String continent;
	private String region;
	private int population;
	
	public Pais(String countryCode, String name, String continent, String region, int population) {
		this.countryCode = countryCode;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.population = population;
	}

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "\n \t Pais [countryCode=" + countryCode + ", name=" + name + ", continent=" + continent + ", region=" + region
				+ ", population=" + population + "]";
	}
	
	
	
	
	
	
}
