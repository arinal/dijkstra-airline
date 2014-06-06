package dijkstra.ui.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dijkstra.cores.airports.Airport;
import dijkstra.cores.airports.AirportService;

@Controller
public class AirportController {

	@Autowired
	AirportService airportService;

	@RequestMapping("/airport/{icao}")
	@ResponseBody
	public Airport findByIcao(@PathVariable String icao) {
		return airportService.findByIcao(icao);
	}
}
