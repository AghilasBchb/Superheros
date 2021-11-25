package superheroStepDefinitions;

import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import superheros.Ennemi;
import superheros.Superheros;

public class StepDefsUS01CombatEnnemiSuperhero {
	private Superheros flash;
	private Ennemi cyboborg;
	private int superhero_power, ennemi_strength;

	@Given("un ennemi de {int} positif")
	public void un_ennemi_de_positif(Integer int1) {
		cyboborg = new Ennemi(int1);
		this.ennemi_strength = int1;
	}

	@Given("un Superheros de {int} positif")
	public void un_Superheros_de_positif(Integer int1) {
		flash = new Superheros(int1);
		this.superhero_power = int1;
	}

	@When("lennemi et superhero sappretent au combat")
	public void lennemi_est_affecté_au_superhero() {
		cyboborg.setOpponent(flash); // automatiquement l'ennemi sera ajouté à la liste d'ennemis du superhero
	}

	@Then("le plus fort gagnera")
	public void le_plus_fort_gagnera() {
		if (this.superhero_power > this.ennemi_strength) {
			assertEquals(false, cyboborg.attack(flash));
		}

		else {
			assertEquals(true, cyboborg.attack(flash));
		}
	}

	@Then("lennemi nest plus relie au superhero")
	public void lennemi_nest_plus_relié_au_superhero() {
		assertEquals(false, flash.isEnnemi(cyboborg));
	}

	@Then("le superhero nest plus relie a lennemi")
	public void le_superhero_nest_plus_relié_à_lennemi() {
		assertNull(cyboborg.getOpponent());
	}

}
