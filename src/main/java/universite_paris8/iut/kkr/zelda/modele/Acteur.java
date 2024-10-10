package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {

	final IntegerProperty x;
    final IntegerProperty y;
	protected Environnement env;
	public static int compteur = 0;
	private String id;

	public Acteur(int x, int y, Environnement env) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.env = env;
		this.id = "Acteur" + compteur;
		compteur++;
	}

	public final void setX(int n) {
		x.setValue(n);
	}

	public final void setY(int n) {
		y.setValue(n);
	}

	public final IntegerProperty getXProperty() {
		return x;
	}

	public final IntegerProperty getYProperty() {
		return y;
	}

	public int getX() {
		return x.getValue();
	}

	public int getY() {
		return y.getValue();
	}

	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y + ", id=" + id;
	}
}
