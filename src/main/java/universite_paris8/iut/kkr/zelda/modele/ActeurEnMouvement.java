package universite_paris8.iut.kkr.zelda.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class ActeurEnMouvement extends Acteur {
    private int vitesse; // vitesse de déplacement
    private int ptAttaque;
    private IntegerProperty pv ;
    private int largeur, longueur;


    public ActeurEnMouvement(int x, int y, int vitesse, Environnement env, int pv, int ptAttaque) {
        super(x, y, env);
        this.vitesse = vitesse;
        this.ptAttaque = ptAttaque;
        this.pv = new SimpleIntegerProperty(pv);
        this.largeur=20;
        this.longueur=30;
    }

    public abstract void seDeplacer();

    public int getVitesse() {
        return vitesse;
    }

    public int getPtAttaque() {return ptAttaque;}

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void setPtAttaque(int ptAttaque) {this.ptAttaque = ptAttaque;}

    public final void setPv(int pv) {this.pv.setValue(pv);}

    public final int getPv() {return pv.getValue();}

    public IntegerProperty pointDeVieProperty(){
        return pv;
    }

    public void decrementerPv(int pointAttaque){
        setPv(getPv() - pointAttaque);
    }

    public void VerifEstVivant(){
        if(estMort()){
            env.retirerActeur(this);
        }
    }
    public boolean estMort(){return getPv() <= 0;}

    //cette methode sert a savoir si des acteurs en mouvement est a porté d'une attaque.
    public boolean estADistanceAttaque(Acteur ActeurCible) {
        if(ActeurCible != null){
            int distanceX = Math.abs(getX() - ActeurCible.getX());
            int distanceY = Math.abs(getY() - ActeurCible.getY());
            int distanceManhattan = distanceX + distanceY;

            return distanceManhattan <= 5;
        }
        return false;
    }
    public void recevoirDegats(int degats) {
        setPv(getPv() - degats);
        if (estMort()) {
            System.out.println("Ennemi tué!");
        } else {
            System.out.println("Ennemi a maintenant " + getPv() + " points de vie.");
        }
    }
    public abstract void attaquer(ActeurEnMouvement acteurCible);

    public int getLargeur(){
        return largeur;
    }

    public int getLongueur() {
        return longueur;
    }
}