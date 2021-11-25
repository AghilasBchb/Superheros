package superheros;

public class Ennemi {
	// variables d'instance - remplacez l'exemple qui suit par le vÃ´tre
	private int strength = 0;
	private Superheros opponent = null;

	/**
	 * Constructeur d'objets de classe Ennemie
	 */

	public Ennemi() {
	}

	public Ennemi(int s) {
		// initialisation des variables d'instance
		if (s < 0) {
			throw new IllegalArgumentException("Invalid value : strength < 0");
		} else {
			this.strength = s;
		}

	}

	public Ennemi(int s, Superheros sh) {
		// initialisation des variables d'instance
		if (s < 0) {
			throw new IllegalArgumentException("Invalid value : strength < 0");
		} else {
			this.strength = s;
			this.opponent = sh;
			sh.addEnnemi(this);
		}
	}

	public boolean attack(Superheros s) {
		// Inserez votre code ici
		if (this.opponent == s) {
			if (s.hurt(this)) {
				this.resetOpponent();
				return true;
			} else {
				// S'il perd, il s'entraîne et devient plus fort
				this.strength = this.strength + 20;
				return false;
			}
		} else {
			return false;
		}
	}

	public int getStrength() {
		return this.strength;
	}

	public void setStrength(int f) {
		this.strength = f;
	}

	public Superheros getOpponent() {
		return this.opponent;
	}

	public String setOpponent(Superheros s) {
		if (this.opponent == null) {
			this.opponent = s;
			s.addEnnemi(this);
			return "Set effectue"; // modification Ajout de ligne
		} else
			return "Possede deja un opponent"; // modification Ajout de ligne
	}

	public void resetOpponent() {
		this.opponent = null;
	}

	public void swapOpponent(Superheros s) {
		if (this.opponent != null) {
			this.opponent.removeEnnemi(this);
			this.opponent = s;
			s.addEnnemi(this);
		}
	}
}
