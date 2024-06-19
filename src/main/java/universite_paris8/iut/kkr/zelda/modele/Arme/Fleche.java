package universite_paris8.iut.kkr.zelda.modele.Arme;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

public class Fleche extends ObjetEnvironnement {
    private int degats;
    private final IntegerProperty directionX;
    private final IntegerProperty directionY;
    private boolean enflammee;

    public Fleche(int x, int y, int directionX, int directionY, int degats, boolean enflammee, Environnement env) {
        super("Fleche", x, y, env);
        this.degats = degats;
        this.directionX = new SimpleIntegerProperty(directionX);
        this.directionY = new SimpleIntegerProperty(directionY);
        this.enflammee = true;
    }

    public  int getDegats() {
        return this.degats;
    }

    public void setDegats(int degats) {
        this.degats=degats;
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



