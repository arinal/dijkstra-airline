package dijkstra.infras.data.inmemory;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import dijkstra.cores.airports.Airport;
import dijkstra.cores.airports.AirportRepository;

public class AirportInMemoryRepo extends InMemoryRepositoryBase<Airport> implements AirportRepository {

	private static ArrayList<Airport> data = new ArrayList<Airport>();

	@Override
	protected ArrayList<Airport> getData() {
		return data;
	}

	@Override
	public Page<Airport> search(String key, Pageable page) {
		ArrayList<Airport> result = new ArrayList<Airport>();
		for (Airport a : this)
			if (a.getCity().contains(key))
				result.add(a);
		return new PageImpl<Airport>(result, page, result.size());
	}	

	@Override
	public Airport getByName(String name) {
		for (Airport c : this)
			if (c.getCity().equals(name))
				return c;
		return null;
	}

	@Override
	public Airport getByIcao(String icao) {
		for (Airport c : this)
			if (c.getIcao().equals(icao))
				return c;
		return null;
	}

	@Override
	public Airport getByIata(String iata) {
		for (Airport c : this)
			if (c.getIata().equals(iata))
				return c;
		return null;
	}
}
