package superheroJunitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import superheros.Ennemi;
import superheros.Superheros;

/**
 * Classe-test SuperherosTest.
 *
 * @author CABRITA
 * @version 16/10/2021
 *
 */
public class SuperherosTest {
	// Définissez ici les variables d'instance nécessaires à vos engagements;
	// Vous pouvez également les saisir automatiquement du présentoir
	// à l'aide du menu contextuel "Présentoir --> Engagements".
	// Notez cependant que ce dernier ne peut saisir les objets primitifs
	// du présentoir (les objets sans constructeur, comme int, float, etc.).

	/**
	 * Constructeur de la classe-test SuperherosTest
	 */
	public SuperherosTest() {
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
	public void testGetPower() {
		Superheros flash = new Superheros();
		assertEquals(0, flash.getPower());
	}

	@Test
	public void testGetHealth() {
		Superheros flash = new Superheros();
		assertEquals(100, flash.getHealth());
	}

	@Test
	public void testGetEnnemieList() {
		Superheros flash = new Superheros();
		assertEquals(true, flash.getListEnnemi().isEmpty());
	}

	@Test
	public void testConstructorOneParam() {
		Superheros flash = new Superheros(100);
		assertEquals(100, flash.getHealth());
		assertEquals(100, flash.getPower());
		assertEquals(true, flash.getListEnnemi().isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidParam() {
		Superheros flash = new Superheros(-10);
	}

	@Test
	public void testConstructorTwoParams() {
		Ennemi cyboborg = new Ennemi(100);
		Superheros flash = new Superheros(100, cyboborg);
		ArrayList<Ennemi> e = new ArrayList<Ennemi>();
		e.add(cyboborg);
		assertEquals(100, flash.getHealth());
		assertEquals(100, flash.getPower());
		assertEquals(e, flash.getListEnnemi());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidTwoParam() {
		Ennemi cyboborg = new Ennemi(100);
		Superheros flash = new Superheros(-10, cyboborg);
	}

	@Test
	public void testSetPower() {
		Superheros flash = new Superheros(100);
		flash.setPower(120);
		assertEquals(120, flash.getPower());
	}

	@Test
	public void testSetLife() {
		Superheros flash = new Superheros(100);
		flash.setHealth(120);
		assertEquals(120, flash.getHealth());
	}

	@Test
	public void testIsEnnemie() {
		Ennemi cyboborg = new Ennemi(100);
		Superheros flash = new Superheros(100, cyboborg);
		assertEquals(true, flash.isEnnemi(cyboborg));
	}

	@Test
	public void testIsNotEnnemie() {
		Ennemi cyboborg = new Ennemi(100);
		Ennemi megamechant = new Ennemi(100);
		Superheros flash = new Superheros(100, cyboborg);
		assertEquals(false, flash.isEnnemi(megamechant));
	}

	@Test
	public void testAddEnnemie() {
		Ennemi cyboborg = new Ennemi(100);
		Superheros flash = new Superheros(100);
		flash.addEnnemi(cyboborg);
		assertEquals(true, flash.isEnnemi(cyboborg));
	}

	@Test
	public void testRemoveEnnemie() {
		Ennemi cyboborg = new Ennemi(100);
		Superheros flash = new Superheros(100);
		flash.addEnnemi(cyboborg);
		flash.removeEnnemi(cyboborg);
		assertEquals(false, flash.isEnnemi(cyboborg));
		assertEquals(null, cyboborg.getOpponent());
	}

	@Test
	public void testGetEnnemieListMultipleEnnemies() {
		Ennemi cyboborg = new Ennemi(100);
		Ennemi megamechant = new Ennemi(100);
		Superheros flash = new Superheros(100);
		flash.addEnnemi(cyboborg);
		flash.addEnnemi(megamechant);
		ArrayList<Ennemi> e = new ArrayList<Ennemi>();
		e.add(cyboborg);
		e.add(megamechant);
		assertEquals(e, flash.getListEnnemi());
	}

	@Test
	public void testAddAlreadyEnnemie() {
		Ennemi cyboborg = new Ennemi(100);
		Superheros flash = new Superheros(100);
		flash.addEnnemi(cyboborg);
		flash.addEnnemi(cyboborg);
		assertEquals(1, flash.getListEnnemi().size());
	}

	@Test
	public void testHurtIfNotEnnemie() {
		Ennemi cyboborg = new Ennemi(100);
		Superheros flash = new Superheros(100);
		assertEquals(false, flash.hurt(cyboborg));
	}

	@Test
	public void testHurtIfEnnemieStronger() {
		Ennemi cyboborg = new Ennemi(120);
		Superheros flash = new Superheros(100);
		flash.addEnnemi(cyboborg);
		assertEquals(true, flash.hurt(cyboborg));
	}

	@Test
	public void testHurtIfEnnemieWeaker() {
		Ennemi cyboborg = new Ennemi(90);
		Superheros flash = new Superheros(100);
		flash.addEnnemi(cyboborg);
		assertEquals(false, flash.hurt(cyboborg));
	}

	@Test
	public void testHurtSuperherosParamsIfEnnemieStronger() {
		Ennemi cyboborg = new Ennemi(120);
		Superheros flash = new Superheros(100);
		flash.addEnnemi(cyboborg);
		flash.hurt(cyboborg);
		assertEquals(0, flash.getHealth());
		assertEquals(0, flash.getPower());
		assertEquals(false, flash.isEnnemi(cyboborg));
		assertEquals(null, cyboborg.getOpponent());
	}

	@Test
	public void testHurtSuperherosParamsIfEnnemieWeaker() {
		Ennemi cyboborg = new Ennemi(90);
		Superheros flash = new Superheros(100);
		flash.addEnnemi(cyboborg);
		flash.hurt(cyboborg);
		assertEquals(false, flash.isEnnemi(cyboborg));
		assertEquals(null, cyboborg.getOpponent());
	}

}
