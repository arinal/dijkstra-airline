package dijkstra.cores.units;

public class BaseUnit extends AbstractUnit {

	private double normal;

	public BaseUnit(String name, String symbol, double normal) {
		super(name, symbol);
		this.normal = normal;
	}

	@Override
	public double getNormal() {
		return normal;
	}	
}
