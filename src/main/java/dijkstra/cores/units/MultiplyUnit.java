package dijkstra.cores.units;

public class MultiplyUnit extends CompositeUnit {

	public MultiplyUnit(Unit unit1, Unit unit2) {
		this(unit1, unit2, 
				unit1.getName() + " " + unit2.getName(), 
				unit1.getSymbol() + " " + unit2.getSymbol());
	}
	
	public MultiplyUnit(Unit unit1, Unit unit2, String name, String unit) {		
		super(unit1, unit2, name, unit);
	}
	
	@Override
	public double getNormal() {
		return getUnit1().getNormal() * getUnit2().getNormal();
	}
}
