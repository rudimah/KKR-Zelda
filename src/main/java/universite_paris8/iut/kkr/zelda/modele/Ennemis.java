package universite_paris8.iut.kkr.zelda.modele;

import universite_paris8.iut.kkr.zelda.modele.Algos.BFS;
import universite_paris8.iut.kkr.zelda.modele.Deplacement.DeplacementBFSStrategy;
import universite_paris8.iut.kkr.zelda.modele.Deplacement.DeplacementStrategy;

import java.util.List;

public  class Ennemis extends ActeurEnMouvement {
    private int toursFige = 0;
    private BFS bfs;
    private String nom;
    private DeplacementStrategy dep;
    public Ennemis(String nom, int x, int y, int vitesse, Environnement env, int pointsDeVie, int ptAttaque) {
        super(nom, x, y, vitesse, env, pointsDeVie, ptAttaque);
        this.nom = nom;
        this.bfs = new BFS(Environnement.getInstance());
        setEnnemiAttaque(env.getLink());
        this.dep = new DeplacementBFSStrategy(env, this);
    }
    public DeplacementStrategy getDep() {
        return dep;
    }

    public boolean estFige() {
        return toursFige > 0;
    }

    public void figer(int nbTours) {
        toursFige = nbTours;
    }

    public void decrementerToursFige() {
        if (toursFige > 0) {
            toursFige--;
        }
    }

    //Méthode avec lequel les ennemis se déplace
    public void seDeplacer() {
       dep.deplacementDeBase();
    }

    @Override
    public void attaquer(ActeurEnMouvement acteurCible) {
        acteurCible.recevoirDegats(getPtAttaque());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}