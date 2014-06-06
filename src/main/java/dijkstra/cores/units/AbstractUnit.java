package dijkstra.cores.units;

public abstract class AbstractUnit implements Unit {	
	private String name;
	private String symbol;
	
	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public AbstractUnit(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	@Override
	public double getConvertionRatio(Unit unit) {
		return getNormal() / unit.getNormal(); 
	}
	
	public UnitMagnitude get(double magnitude) {
		return new UnitMagnitude(this, magnitude);
	}
	
	@Override
	public int compareTo(Unit unit) {
		return Double.compare(getNormal(), unit.getNormal());
	}
	
	public abstract double getNormal();
}
