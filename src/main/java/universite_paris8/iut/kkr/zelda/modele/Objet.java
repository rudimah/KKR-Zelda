package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;

public class Objet {
    private String nom;
    private IntegerProperty x;
    private IntegerProperty y ;
    public static int compteur=0;
    private String id;

    public Objet(String nom, int x, int y){
        this.id = "Objet"+compteur;
        this.nom = nom;
        this.x.setValue(x);
        this.y.setValue(y);
        compteur++;
    }

    public int getX() {return x.getValue();}

    public int getY() {return y.getValue();}

    public String getNom() {return nom;}

    public IntegerProperty XProperty(){return this.x;}

    public IntegerProperty YProperty(){return this.y;}

    public String getId() {return id;}
}
