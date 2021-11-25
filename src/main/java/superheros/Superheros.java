package superheros;

import java.util.*;

public class Superheros {
	// variables d'instance - remplacez l'exemple qui suit par le vôtre
	protected int power = 0;
	protected int health = 100;
	private ArrayList<Ennemi> ennemiList = new ArrayList<Ennemi>();

	/**
	 * Constructeur d'objets de classe Superheros
	 */

	public Superheros() {
	}

	public Superheros(int p) {
		// initialisation des variables d'instance
		if (p < 0) {
			throw new IllegalArgumentException("Invalid value : power < 0");
		} else {
			this.power = p;
		}
	}

	public Superheros(int p, Ennemi e) {
		// initialisation des variables d'instance
		if (p < 0) {
			throw new IllegalArgumentException("Invalid value : power < 0");
		} else {
			this.power = p;
			this.ennemiList.add(e);
		}
	}

	public boolean hurt(Ennemi e) {
		// Compare les puissances des deux protagonistes
		if (this.isEnnemi(e)) {
			if (this.power < e.getStrength()) {
				this.health = 0;
				this.power = 0;
				e.resetOpponent();
				this.removeEnnemi(e);
				return true;
			} else {
				// si le superheros gagne, l'ennemie disparait
				e.resetOpponent();
				this.removeEnnemi(e);
				return false;
			}
		} else {
			return false;
		}
	}

	public int getPower() {
		return this.power;
	}

	public int getHealth() {
		return this.health;
	}

	public void setPower(int p) {
		this.power = p;
	}

	public void setHealth(int v) {
		this.health = v;
	}

	public void addEnnemi(Ennemi e) {
		if (!(this.isEnnemi(e))) {
			this.ennemiList.add(e);
		}
	}

	public void removeEnnemi(Ennemi e) {
		this.ennemiList.remove(e);
	}

	public boolean isEnnemi(Ennemi e) {
		return this.ennemiList.contains(e);
	}

	public List<Ennemi> getListEnnemi() {
		List<Ennemi> immutableList = Collections.unmodifiableList(this.ennemiList);
		return immutableList;
	}

}
