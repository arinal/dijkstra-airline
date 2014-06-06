package dijkstra.infras.data.inmemory;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import dijkstra.cores.airplanes.Airplane;
import dijkstra.cores.airplanes.AirplaneRepository;

public class AirplaneInMemoryRepo extends InMemoryRepositoryBase<Airplane>
		implements AirplaneRepository {

	private static ArrayList<Airplane> data = new ArrayList<Airplane>();

	@Override
	public Iterable<Airplane> whereDistanceLessThan(double distance) {
		ArrayList<Airplane> result = new ArrayList<Airplane>();
		for (Airplane a : this)
			if (a.getMaxDistance().getMagnitude() >= distance)
				result.add(a);
		return result;
	}

	@Override
	protected ArrayList<Airplane> getData() {
		return data;
	}

	@Override	
	public Page<Airplane> search(String key, Pageable page) {
		ArrayList<Airplane> result = new ArrayList<Airplane>();
		for (Airplane a : this)
			if (a.getType().contains(key))
				result.add(a);
		return new PageImpl<Airplane>(result, page, result.size());
	}

	@Override
	public Airplane getByType(String type) {
		for (Airplane a : this)
			if (a.getType().equals(type))
				return a;
		return null;
	}

	@Override
	public Iterable<Airplane> getBySeatsGreater(int passengers) {
		ArrayList<Airplane> result = new ArrayList<Airplane>();
		for (Airplane a : this)
			if (a.getSeats() >= passengers)
				result.add(a);
		return result;
	}		
}
