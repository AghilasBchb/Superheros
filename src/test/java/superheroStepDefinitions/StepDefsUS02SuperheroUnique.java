package superheroStepDefinitions;

import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import superheros.Ennemi;
import superheros.Superheros;

public class StepDefsUS02SuperheroUnique {

	private Superheros flash, batman;
	private Ennemi cyboborg;

	@Given("un ennemi de force {int}")
	public void un_ennemi_de_force(Integer int1) {
		cyboborg = new Ennemi(int1);
	}

	@Given("premier Superhero  de force {int} et deuxieme Superhero de force {int}")
	public void deux_Superheros_de_force(Integer int1, Integer int2) {
		flash = new Superheros(int1);
		batman = new Superheros(int2);
	}

	@When("lennemi et le premier superhero sappretent au combat")
	public void lennemi_est_affecté_au_superhero() {
		cyboborg.setOpponent(flash);
		flash.addEnnemi(cyboborg);
	}

	@Then("impossible daffecter le deuxieme superhero a lennemi")
	public void deuxieme_superhero_refuse() {
		assertEquals("Possede deja un opponent", cyboborg.setOpponent(batman));
	}

	@When("lennemi et le premier superhero sappretent au combat mais lennemi change de superhero")
	public void lennemi_change_de_superhero() {
		flash.addEnnemi(cyboborg);
		cyboborg.setOpponent(flash);

		cyboborg.swapOpponent(batman);
	}

	@Then("le premier superhero est remplace par le deuxieme")
	public void le_premier_superhero_est_remplace_par_le_deuxieme() {
		assertEquals(batman, cyboborg.getOpponent());

	}

	@Then("lennemi nest plus dans la liste du premier superhero")
	public void lennemi_nest_plus_dans_la_liste_du_premier_superhero() {
		assertFalse(flash.isEnnemi(cyboborg));
		assertTrue(batman.isEnnemi(cyboborg));

	}

}
