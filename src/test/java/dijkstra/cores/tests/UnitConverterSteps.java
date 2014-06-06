package dijkstra.cores.tests;

import static junit.framework.Assert.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.steps.Steps;

import dijkstra.cores.units.UnitMagnitude;
import dijkstra.cores.units.Units;

public class UnitConverterSteps extends Steps {
	private UnitMagnitude original;
	
	@Given("value of $value $unit")
	public void givenLengthOf(@Named("value") double value, @Named("unit") String unit) {
		this.original = Units.of(unit).get(value);
	}

	@Then("converted $unit should be $converted")
	public void thenConvertedshouldBe(@Named("unit") String unit, @Named("converted") double converted) {
		double actual = original.convertTo(Units.of(unit)).getMagnitude();
		assertEquals(actual + " != " + actual,  converted, actual, 0.001);
	}	
}