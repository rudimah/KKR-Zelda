package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {

	final IntegerProperty x;
    final IntegerProperty y;
	protected Environnement env;
	public static int compteur = 0;
	private String id;
	private String nom;
	public Acteur(String nom, int x, int y, Environnement env) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.env = env;
		this.id = "Acteur" + compteur;
		this.nom = nom;
		compteur++;
	}

	public final void setX(int n) {
		x.setValue(n);
	}

	public int getX() {
		return x.getValue();
	}

	public final IntegerProperty getXProperty() {
		return x;
	}

	public final void setY(int n) {
		y.setValue(n);
	}

	public int getY() {
		return y.getValue();
	}

	public final IntegerProperty getYProperty() {
		return y;
	}

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y + ", id=" + id;
	}
}
