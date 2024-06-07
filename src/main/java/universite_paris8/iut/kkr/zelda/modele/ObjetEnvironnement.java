package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ObjetEnvironnement {
    private String nom;
    private IntegerProperty x;
    private IntegerProperty y;
    private static int compteur = 0;
    private String id;

    protected Environnement env;
    private boolean estRamassé = false;


    public ObjetEnvironnement(String nom, int x, int y) {
        this.nom = nom;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.id = "ObjetEnvironnement" + compteur++;
    }

    public final int getX() { return x.getValue(); }
    public IntegerProperty xProperty() { return x; }

    public final void setX(int x) { this.x.setValue(x); }

    public final int getY() { return y.getValue(); }
    public IntegerProperty yProperty() { return y; }

    public final void setY(int y) { this.y.setValue(y); }

    public String getNom() { return nom; }

    public String getId() { return id; }
    public boolean EstRamassé() {return estRamassé;}

    public void setEstRamassé(boolean estRamassé) {this.estRamassé = estRamassé;}
}
