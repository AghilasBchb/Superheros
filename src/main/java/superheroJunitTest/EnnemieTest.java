package superheroJunitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import superheros.Ennemi;
import superheros.Superheros;

public class EnnemieTest {

	/**
	 * Constructeur de la classe-test EnnemieTest
	 */
	public EnnemieTest() {
	}

	/**
	 * Met en place les engagements.
	 *
	 * Méthode appelée avant chaque appel de méthode de test.
	 */
	@Before
	public void setUp() // throws java.lang.Exception
	{

	}

	/**
	 * Supprime les engagements
	 *
	 * Méthode appelée après chaque appel de méthode de test.
	 */
	@After
	public void tearDown() // throws java.lang.Exception
	{
		// Libérez ici les ressources engagées par setUp()
	}

	@Test
	public void testGetStrength() {
		Ennemi cyboborg = new Ennemi();
		assertEquals(0, cyboborg.getStrength());
	}

	@Test
	public void testGetOpponent() {
		Ennemi cyboborg = new Ennemi();
		assertEquals(null, cyboborg.getOpponent());
	}

	@Test
	public void testConstructorOneParam() {
		Ennemi cyboborg = new Ennemi(100);
		assertEquals(100, cyboborg.getStrength());
		assertEquals(null, cyboborg.getOpponent());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidParam() {
		Ennemi cyboborg = new Ennemi(-10);
	}

	@Test
	public void testConstructorTwoParam() {
		Superheros flash = new Superheros();
		Ennemi cyboborg = new Ennemi(100, flash);
		assertEquals(100, cyboborg.getStrength());
		assertEquals(flash, cyboborg.getOpponent());
		assertEquals(true, flash.isEnnemi(cyboborg));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidTwoParam() {
		Superheros flash = new Superheros(100);
		Ennemi cyboborg = new Ennemi(-10, flash);

	}

	@Test
	public void testSetStrength() {
		Ennemi cyboborg = new Ennemi(100);
		cyboborg.setStrength(50);
		assertEquals(50, cyboborg.getStrength());
	}

	@Test
	public void testSetOpponentIfOne() {
		Superheros flash = new Superheros(100);
		Ennemi cyboborg = new Ennemi(100);
		assertEquals("Set effectue", cyboborg.setOpponent(flash));
	}

	@Test
	public void testSetOpponentParamsIfOne() {
		Superheros flash = new Superheros(100);
		Ennemi cyboborg = new Ennemi(100);
		cyboborg.setOpponent(flash);
		assertEquals(flash, cyboborg.getOpponent());
		assertEquals(true, flash.isEnnemi(cyboborg));
	}

	@Test
	public void testSetOpponentAlreadyHasOpponent() {
		Superheros flash = new Superheros(100);
		Superheros batman = new Superheros(250);
		Ennemi cyboborg = new Ennemi(100, flash);
		assertEquals("Possede deja un opponent", cyboborg.setOpponent(batman));
	}

	@Test
	public void testSetOpponentIfTwo() {
		Superheros flash = new Superheros(100);
		Superheros batman = new Superheros(250);
		Ennemi cyboborg = new Ennemi(100);
		cyboborg.setOpponent(flash);
		cyboborg.setOpponent(batman);
		assertEquals(flash, cyboborg.getOpponent());
		assertEquals(true, flash.isEnnemi(cyboborg));
		assertEquals(false, batman.isEnnemi(cyboborg));
	}

	@Test
	public void testResetOpponent() {
		Superheros flash = new Superheros(100);
		Ennemi cyboborg = new Ennemi(100);
		cyboborg.setOpponent(flash);
		cyboborg.resetOpponent();
		assertEquals(null, cyboborg.getOpponent());
	}

	@Test
	public void testAttackIfNotOpponent() {
		Superheros flash = new Superheros(100);
		Ennemi cyboborg = new Ennemi(100);
		assertEquals(false, cyboborg.attack(flash));
	}

	@Test
	public void testAttackIfStronger() {
		Superheros flash = new Superheros(100);
		Ennemi cyboborg = new Ennemi(120, flash);
		assertEquals(true, cyboborg.attack(flash));
	}

	@Test
	public void testAttackIfWeaker() {
		Superheros flash = new Superheros(200);
		Ennemi cyboborg = new Ennemi(100, flash);
		assertEquals(false, cyboborg.attack(flash));
	}

	@Test
	public void testAttackParamIfStronger() {
		Superheros flash = new Superheros(100);
		Ennemi cyboborg = new Ennemi(120, flash);
		cyboborg.attack(flash);
		assertEquals(null, cyboborg.getOpponent());
	}

	@Test
	public void testAttackParamsIfWeaker() {
		Superheros flash = new Superheros(200);
		Ennemi cyboborg = new Ennemi(100, flash);
		cyboborg.attack(flash);
		assertEquals(120, cyboborg.getStrength());
		assertEquals(null, cyboborg.getOpponent());
	}

	@Test
	public void testSwapOpponentIfNone() {
		Superheros flash = new Superheros(100);
		Ennemi cyboborg = new Ennemi(100);
		cyboborg.swapOpponent(flash);
		assertEquals(null, cyboborg.getOpponent());
	}

	@Test
	public void testSwapOpponentIfOne() {
		Superheros flash = new Superheros(100);
		Superheros batman = new Superheros(250);
		Ennemi cyboborg = new Ennemi(100);
		cyboborg.setOpponent(flash);
		cyboborg.swapOpponent(batman);
		assertEquals(false, flash.isEnnemi(cyboborg));
		assertEquals(batman, cyboborg.getOpponent());
		assertEquals(true, batman.isEnnemi(cyboborg));
	}

}
