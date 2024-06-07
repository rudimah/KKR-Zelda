package universite_paris8.iut.kkr.zelda.modele.Ennemis;

import universite_paris8.iut.kkr.zelda.modele.Acteur;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Algos.BFS;
import universite_paris8.iut.kkr.zelda.modele.Algos.Coordonnees;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

import java.util.ArrayList;
import java.util.List;


public abstract class Ennemis extends ActeurEnMouvement {
    private int toursFige = 0;

    private BFS bfs = new BFS(env);

    private int positionLinkX =0;
    private int positionLinkY = 0;
    private List<Coordonnees> cheminBFS;


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
            int linkX = link.getX();
            int linkY = link.getY();
            cheminBFS = bfs.trouverCheminBFS(this, linkX, linkY);
            if (cheminBFS != null && !cheminBFS.isEmpty() && cheminBFS.size() > 1) {
                Coordonnees prochainNoeud = cheminBFS.get(1);
                setX(prochainNoeud.getX());
                setY(prochainNoeud.getY());
            }
        }
        System.out.println("Ennemi se déplace en (" + getX() + ',' + getY() + ')');
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