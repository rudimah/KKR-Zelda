package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;

public class Item {
    private String nom;
    private IntegerProperty x;
    private IntegerProperty y;
    private boolean estRamassé;
    public static int compteur=0;
    private String id;

    public Item(String nom, int x,int y){
        this.id = "Item"+compteur;
        this.nom = nom;
        this.x.setValue(x);
        this.y.setValue(y);
        this.estRamassé = false;
    }

    public int getX() {return x.getValue();}

    public int getY() {return y.getValue();}

    public IntegerProperty XProperty(){return this.x;}

    public IntegerProperty YProperty(){return this.y;}

    public boolean EstRamassé() {return estRamassé;}

    public void setEstRamassé(boolean estRamassé) {this.estRamassé = estRamassé;}

    public String getId() {return id;}
}
