package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Fleche extends ObjetEnvironnement {
    private final IntegerProperty degats;
    private final IntegerProperty directionX;
    private final IntegerProperty directionY;
    private boolean enflammee;

    public Fleche(int x, int y, int directionX, int directionY, int degats, boolean enflammee) {
        super("Fleche", x, y);
        this.degats = new SimpleIntegerProperty(degats);
        this.directionX = new SimpleIntegerProperty(directionX);
        this.directionY = new SimpleIntegerProperty(directionY);
        this.enflammee = true;
    }

    public final int getDegats() {
        return degats.getValue();
    }

    public final void setDegats(int degats) {
        this.degats.setValue(degats);
    }

    public IntegerProperty degatsProperty() {
        return degats;
    }

    public final int getDirectionX() {
        return directionX.getValue();
    }

    public final void setDirectionX(int directionX) {
        this.directionX.setValue(directionX);
    }

    public IntegerProperty directionXProperty() {
        return directionX;
    }

    public final int getDirectionY() {
        return directionY.getValue();
    }

    public final void setDirectionY(int directionY) {
        this.directionY.setValue(directionY);
    }

    public IntegerProperty directionYProperty() {
        return directionY;
    }

    public boolean isEnflammee() {
        return enflammee;
    }



    public void deplacer() {
        // Mise à jour de la position de la flèche
        setX(getX() + getDirectionX());
        setY(getY() + getDirectionY());
        System.out.println(getNom() + " se déplace vers (" + getX() + ", " + getY() + ")");
    }

//    public void infligerDegats(Ennemi ennemi) {
//        if (isEnflammee()) {
//            ennemi.subirDegats(getDegats() + 5); // Dégâts supplémentaires enflammés
//            System.out.println(getNom() + " inflige " + (getDegats() + 5) + " points de dégâts enflammés à " + ennemi.getNom());
//        } else {
//            ennemi.subirDegats(getDegats());
//            System.out.println(getNom() + " inflige " + getDegats() + " points de dégâts à " + ennemi.getNom());
//        }
//    }
}


//package universite_paris8.iut.kkr.zelda.modele;
//
//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//
//public class Ennemi {
//    private final String nom;
//    private final IntegerProperty pointsDeVie;
//
//    public Ennemi(String nom, int pointsDeVie) {
//        this.nom = nom;
//        this.pointsDeVie = new SimpleIntegerProperty(pointsDeVie);
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public int getPointsDeVie() {
//        return pointsDeVie.get();
//    }
//
//    public void subirDegats(int degats) {
//        pointsDeVie.set(pointsDeVie.get() - degats);
//        if (pointsDeVie.get() < 0) {
//            pointsDeVie.set(0);
//        }
//        System.out.println(nom + " a " + pointsDeVie.get() + " points de vie restants.");
//    }
//
//    public IntegerProperty pointsDeVieProperty() {
//        return pointsDeVie;
//    }
//}
