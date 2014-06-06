package dijsktra.ui.konsole;

import org.springframework.context.support.GenericXmlApplicationContext;

import dijkstra.cores.airplanes.Airplane;
import dijkstra.cores.airplanes.AirplaneRepository;
import dijkstra.cores.airports.Airport;
import dijkstra.cores.airports.AirportRepository;
import dijkstra.cores.airports.AirportService;
import dijkstra.cores.flights.Flight;
import dijkstra.cores.flights.FlightFactory;
import dijkstra.cores.flights.Leg;
import dijkstra.cores.lanes.FlightLaneRepository;
import dijkstra.cores.lanes.RouteGenerator;
import dijkstra.cores.units.Units;
import dijkstra.infras.data.inmemory.AirplaneInMemoryRepo;
import dijkstra.infras.data.inmemory.AirportInMemoryRepo;
import dijkstra.infras.data.inmemory.FlightLaneInMemoryRepo;

public class Scratch {

	public static void main2(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-app-context.xml");
		ctx.refresh();
		
		AirportService repo = ctx.getBean("airportService", AirportService.class);
		Airport port = repo.findByIcao("VHHH");
		System.out.println(port.getName());
	}
	
	public static void main(String[] args) {
		AirportRepository cities = new AirportInMemoryRepo();
		FlightLaneRepository lanes = new FlightLaneInMemoryRepo();
		AirplaneRepository airplanes = new AirplaneInMemoryRepo();
		initData(cities, lanes, airplanes);

		Airport from = cities.getByName("Amsterdam");
		Airport to = cities.getByName("Frankfurt");
		int passengers = 300;

		RouteGenerator routeGenerator = new RouteGenerator(lanes);
		FlightFactory flightService = new FlightFactory(routeGenerator);
		for (Airplane plane : airplanes.getBySeatsGreater(passengers)) {
			Flight flight = flightService.generateFlight(from, to, plane, passengers);
			if (!flight.isValid())
				continue;
			System.out.printf("Type: %s\nSeats: %d\nSpeed: %s (%s)\n", 
					plane.getType(), plane.getSeats(), plane.getSpeed(), 
					plane.getSpeed().convertTo(Units.KiloMeterPerHour));
			for (Leg leg : flight.getLegs())
				System.out.printf("%s -> %s (%s)\n", leg.getFrom().getCity(), 
						leg.getTo().getCity(), plane.getSpeed().getTimeSpan(leg.getDistance()));
			System.out.println("\n");
		}
	}

	private static void initData(AirportRepository airports,
			FlightLaneRepository laneRepository, AirplaneRepository airplanes) {
		Airport amsterdam = new Airport("EHAM", "AMS", 
				"Amsterdam Airport Schipol", "Amsterdam");
		Airport beijing = new Airport("ZBAA", "PEK", 
				"Beijing Capital International Airport", "Beijing");
		Airport cairo = new Airport("HECA", "CAI", "Cairo International Airport", "Cairo");
		Airport denver = new Airport("KDEN", "DEN", 
				"Denver International Airport", "Denver");
		Airport frankfurt = new Airport("EDDF", "FRA", "Frankfurt Airport", "Frankfurt");
		Airport hongKong = new Airport("VHHH", "HKG", 
				"Hong Kong International Airport", "Hong Kong");
		Airport geneva = new Airport("LSGG", "GVA", 
				"Geneva International Airport", "Geneva");
		Airport istanbul = new Airport("LTBA", "IST", 
				"Istanbul Atatürk Airport", "Istanbul");
		Airport jakarta = new Airport("WIII", "CGK", 
				"Soekarno-Hatta International Airport", "Jakarta");

		airports.save(amsterdam);
		airports.save(beijing);
		airports.save(cairo);
		airports.save(denver);
		airports.save(frankfurt);
		airports.save(hongKong);
		airports.save(geneva);
		airports.save(istanbul);
		airports.save(jakarta);

		Airplane plane = new Airplane();
		plane.setType("Airbus 319");
		plane.setSeats(124);
		plane.setSpeed(Units.KiloMeterPerHour, 1004.53);
		plane.setMaxDistance(Units.Kilometer, 3350);
		airplanes.save(plane);

		plane = new Airplane();
		plane.setType("Airbus 320");
		plane.setSeats(240);
		plane.setSpeed(Units.KiloMeterPerHour, 1004.53);
		plane.setMaxDistance(Units.Kilometer, 4800);
		airplanes.save(plane);

		plane = new Airplane();
		plane.setType("Airbus 340-600");
		plane.setSeats(380);
		plane.setSpeed(Units.KiloMeterPerHour, 1053.53);
		plane.setMaxDistance(Units.Kilometer, 14360);
		airplanes.save(plane);

		plane = new Airplane();
		plane.setType("Airbus 380");
		plane.setSeats(525);
		plane.setSpeed(Units.KiloMeterPerHour, 1090.28);
		plane.setMaxDistance(Units.Kilometer, 15200);
		airplanes.save(plane);

		RouteGenerator service = new RouteGenerator(laneRepository);

		service.addDoubleDirectedLane(jakarta, amsterdam, Units.Kilometer.get(11359.19));
		service.addDoubleDirectedLane(jakarta, beijing, Units.Kilometer.get(5239.33));
		service.addDoubleDirectedLane(jakarta, cairo, Units.Kilometer.get(8980.42));
		service.addDoubleDirectedLane(jakarta, denver, Units.Kilometer.get(15113.22));
		service.addDoubleDirectedLane(jakarta, frankfurt, Units.Kilometer.get(11122.1));
		service.addDoubleDirectedLane(jakarta, hongKong, Units.Kilometer.get(3259.64));
		service.addDoubleDirectedLane(jakarta, geneva, Units.Kilometer.get(11322.07));
		service.addDoubleDirectedLane(jakarta, istanbul, Units.Kilometer.get(9452.58));

		service.addDoubleDirectedLane(istanbul, amsterdam, Units.Kilometer.get(2210.17));
		service.addDoubleDirectedLane(istanbul, beijing, Units.Kilometer.get(7059.44));
		service.addDoubleDirectedLane(istanbul, cairo, Units.Kilometer.get(1236.57));
		service.addDoubleDirectedLane(istanbul, denver, Units.Kilometer.get(9873.17));
		service.addDoubleDirectedLane(istanbul, frankfurt, Units.Kilometer.get(1869.04));
		service.addDoubleDirectedLane(istanbul, hongKong, Units.Kilometer.get(7996.54));
		service.addDoubleDirectedLane(istanbul, geneva, Units.Kilometer.get(1915.04));

		service.addDoubleDirectedLane(geneva, amsterdam, Units.Kilometer.get(692.47));
		service.addDoubleDirectedLane(geneva, beijing, Units.Kilometer.get(8199.39));
		service.addDoubleDirectedLane(geneva, cairo, Units.Kilometer.get(2813.79));
		service.addDoubleDirectedLane(geneva, denver, Units.Kilometer.get(8241.52));
		service.addDoubleDirectedLane(geneva, frankfurt, Units.Kilometer.get(463.66));
		service.addDoubleDirectedLane(geneva, hongKong, Units.Kilometer.get(9504.62));

		service.addDoubleDirectedLane(hongKong, amsterdam, Units.Kilometer.get(9262.42));
		service.addDoubleDirectedLane(hongKong, beijing, Units.Kilometer.get(1991.95));
		service.addDoubleDirectedLane(hongKong, cairo, Units.Kilometer.get(8117.11));
		service.addDoubleDirectedLane(hongKong, denver, Units.Kilometer.get(12027.61));
		service.addDoubleDirectedLane(hongKong, frankfurt, Units.Kilometer.get(9151.97));

		service.addDoubleDirectedLane(frankfurt, beijing, Units.Kilometer.get(8199.39));
		service.addDoubleDirectedLane(frankfurt, cairo, Units.Kilometer.get(7785.76));
		service.addDoubleDirectedLane(frankfurt, denver, Units.Kilometer.get(8087.29));

		service.addDoubleDirectedLane(denver, amsterdam, Units.Kilometer.get(7724.81));
		service.addDoubleDirectedLane(denver, beijing, Units.Kilometer.get(10191.43));

		service.addDoubleDirectedLane(cairo, amsterdam, Units.Kilometer.get(3282.76));
	}
}