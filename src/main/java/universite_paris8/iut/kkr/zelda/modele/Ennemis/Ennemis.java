package universite_paris8.iut.kkr.zelda.modele.Ennemis;

import universite_paris8.iut.kkr.zelda.modele.Acteur;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

import java.util.ArrayList;


public abstract class Ennemis extends ActeurEnMouvement {
    private int toursFige=0;

    public Ennemis(int x, int y, int vitesse, Environnement env, int pointsDeVie, int ptAttaque) {
        super(x, y, vitesse, env, pointsDeVie, ptAttaque);
    }


    public void seDeplacer() {
        if (toursFige > 0) {
            toursFige--;
            return;
        }
        Acteur link = env.getLink();
        if (link != null) {
            int dx = link.getX() - getX();
            int dy = link.getY() - getY();
            int nouveauX = getX();
            int nouveauY = getY();
            if (dx != 0) {
                nouveauX += (dx > 0) ? getVitesse() : -getVitesse();
            }
            if (dy != 0) {
                nouveauY += (dy > 0) ? getVitesse() : -getVitesse();
            }
            if(env.verifObstacle(dx, dy, this)){
                setX(getX() + Integer.signum(dx) * getVitesse());
                setY(getY() + Integer.signum(dy) * getVitesse());
            }
        }
        System.out.println("Ennemi se déplace en (" + getX() + ',' + getY() +')' );
    }


    @Override
    public Environnement getEnv() {
        return super.getEnv();
    }
    public void figer(int nbTours) {
        toursFige = nbTours;
    }

    public boolean estFige() {
        return toursFige > 0;
    }
    public void decrementerToursFige() {
        if (toursFige > 0) {
            toursFige--;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}