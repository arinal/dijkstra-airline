package dijkstra.cores.units;

public abstract class CompositeUnit extends AbstractUnit {
	private Unit unit1;
	private Unit unit2;
			
	public Unit getUnit1() {
		return unit1;
	}
	
	public Unit getUnit2() {
		return unit2;
	}
	
	public CompositeUnit(Unit unit1, Unit unit2, String name, String symbol) {
		super(name, symbol);
		this.unit1 = unit1;
		this.unit2 = unit2;
	}
	
	@Override
	public abstract double getNormal();
}
