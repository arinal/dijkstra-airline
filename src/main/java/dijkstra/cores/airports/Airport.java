package dijkstra.cores.airports;

import javax.persistence.Entity;

import dijkstra.cores.commons.AbstractEntity;

@Entity
public class Airport extends AbstractEntity {
	private String icao;
	private String iata;
	private String name;
	private String city;

	public Airport(String icao, String iata, String name, String city) {
		this.icao = icao;
		this.iata = iata;
		this.name = name;
		this.city = city;
	}
	
	public Airport() {
		this("", "", "", "");
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
