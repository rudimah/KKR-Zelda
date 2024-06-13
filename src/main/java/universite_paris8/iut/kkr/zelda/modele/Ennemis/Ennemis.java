package universite_paris8.iut.kkr.zelda.modele.Ennemis;

import universite_paris8.iut.kkr.zelda.modele.Acteur;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Algos.BFS;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

import java.util.List;

public abstract class Ennemis extends ActeurEnMouvement {
    private int toursFige = 0;
    private BFS bfs;

    public Ennemis(int x, int y, int vitesse, Environnement env, int pointsDeVie, int ptAttaque) {
        super(x, y, vitesse, env, pointsDeVie, ptAttaque);
        this.bfs = new BFS(env);
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

            List<int[]> chemin = bfs.cheminBFS(getX(), getY(), linkX, linkY);
            if (chemin != null && !chemin.isEmpty() && chemin.size() > 1) {
                int[] prochaineEtape = chemin.get(1);

                double dx = prochaineEtape[0] - getX();
                double dy = prochaineEtape[1] - getY();
                double distance = Math.sqrt(dx * dx + dy * dy);

                // Normaliser le vecteur de déplacement
                double nx = dx / distance;
                double ny = dy / distance;

                // Calculer la nouvelle position en fonction de la vitesse
                int nouveauX = (int) (getX() + nx * getVitesse());
                int nouveauY = (int) (getY() + ny * getVitesse());

                // Vérifier si la nouvelle position est accessible
                if (bfs.estAccessible(nouveauX, nouveauY)) {
                    setX(nouveauX);
                    setY(nouveauY);
                    System.out.println("Ennemi se déplace" + getX() +  getY());
                } else {
                    int[] gauche = {-1, 0}; // Déplacement d'une tuile à gauche
                    int[] droite = {1, 0};  // Déplacement d'une tuile à droite
                    int nouveauXGauche = getX() + gauche[0];
                    int nouveauXDroite = getX() + droite[0];
                    int y = getY();

                    if (bfs.estAccessible(nouveauXGauche, y)) {
                        setX(nouveauXGauche);
                    } else if (bfs.estAccessible(nouveauXDroite, y)) {
                        setX(nouveauXDroite);
                    }
                }
            }
        } else {
            System.out.println("Aucun chemin ");

        }
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