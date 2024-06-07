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
        System.out.println("Tentative de déplacement de " + this + " en cours");

        if (toursFige > 0) {
            toursFige--;
            System.out.println("Ennemi figé pour " + toursFige + " tours");
            return;
        }

        Acteur link = env.getLink();
        if (link == null) {
            System.out.println("Link n'est pas trouvé ");
            return;
        }

        System.out.println("Coordonnées actuelles de l'ennemi : (" + getX() + ", " + getY() + ")");
        System.out.println("Coordonnées de Link : (" + link.getX() + ", " + link.getY() + ")");

        int[] destination = env.trouverCheminVersLink(getX(), getY(), link.getX(), link.getY());
        if (destination == null) {
            System.out.println("Aucun chemin vers Link");
            return;
        }

        System.out.println("Destination trouvée : (" + destination[0] + ", " + destination[1] + ")");

        int maxRetries = 10;
        while (!env.verifObstacle(destination[0], destination[1], this)) {
            System.out.println("Essaye de trouver son chemin sans obstacle. Tentative restante: " + maxRetries);

            destination = env.trouverCheminVersLink(getX(), getY(), link.getX(), link.getY());
            if (destination == null) {
                System.out.println("Aucun chemin trouvé après recalcul");
                return;
            }

            maxRetries--;
            if (maxRetries <= 0) {
                System.out.println("Échec de trouver un chemin sans obstacle après plusieurs tentatives");
                return;
            }
        }

        setX(destination[0]);
        setY(destination[1]);
        System.out.println("Ennemi se déplace en (" + getX() + ", " + getY() + ")");
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
