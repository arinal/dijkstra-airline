package dijkstra.cores.airports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class AirportService {

	private AirportRepository airportRepository;

	@Autowired
	public AirportService(AirportRepository airportRepository) {
		this.airportRepository = airportRepository;
	}

	public AirportService() {
	}

	@Transactional(readOnly = true)
	public Page<Airport> search(String key, Pageable page) {
		return airportRepository.search(key, page);
	}

	@Transactional(readOnly = true)
	public Airport findByIcao(String icao) {
		return airportRepository.getByIcao(icao);
	}
}
