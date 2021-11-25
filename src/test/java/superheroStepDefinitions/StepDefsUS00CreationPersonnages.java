package superheroStepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import superheros.Ennemi;
import superheros.Superheros;

import static org.junit.Assert.*;

public class StepDefsUS00CreationPersonnages {

	private Superheros flash;
	private Ennemi cyboborg;
	private int power, strength;

	@Given("un Superheros de {int} positifs")
	public void un_Superheros_de_positifs(Integer int1) {
		power = int1;
	}

	@When("le superhero est cree")
	public void le_superhero_est_cree() {
		flash = new Superheros(this.power);
	}

	@Then("le superhero est bien instancie")
	public void le_superhero_est_bien_instancie() {
		assertEquals(this.power, flash.getPower());

	}

	@Given("un Ennemi de {int} positifs")
	public void un_Ennemi_de_positifs(Integer int2) {
		this.strength = int2;
	}

	@When("le Ennemi est cree")
	public void le_Ennemi_est_cree() {
		cyboborg = new Ennemi(this.strength);
	}

	@Then("le Ennemi est bien instancie")
	public void le_Ennemi_est_bien_instancie() {
		assertEquals(this.strength, cyboborg.getStrength());

	}

}
