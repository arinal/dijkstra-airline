package dijkstra.cores.airports;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dijkstra.cores.commons.Repository;

public interface AirportRepository extends Repository<Airport> {
	Airport getByName(String name);
	Airport getByIcao(String icao);
	Airport getByIata(String iata);
	
	@Query("select a from Airport a " +
			"where lower(a.name) like lower(:search) " +
			"or lower(a.icao) like lower(:search) " +
			"or lower(a.iata) like lower(:search) " +
			"or lower(a.city) like lower(:search) " +
			"order by a.name")
    Page<Airport> search(@Param("search") String search, Pageable page);    
}
