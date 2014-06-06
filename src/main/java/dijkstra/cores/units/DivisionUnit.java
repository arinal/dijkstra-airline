package dijkstra.cores.units;

public class DivisionUnit extends CompositeUnit {
	
	public DivisionUnit(Unit unit1, Unit unit2) {
		this(unit1, unit2, 
				unit1.getName() + " per " + unit2.getName(), 
				unit1.getSymbol() + "/" + unit2.getSymbol());
	}
	
	public DivisionUnit(Unit unit1, Unit unit2, String name, String unit) {		
		super(unit1, unit2, name, unit);
	}
	
	@Override
	public double getNormal() {
		return getUnit1().getNormal() / getUnit2().getNormal();
	}	
}
