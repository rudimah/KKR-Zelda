package universite_paris8.iut.kkr.zelda.modele.Deplacement;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Algos.BFS;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;

import java.util.List;

public class DeplacementBFSStrategy implements DeplacementStrategy {
    private BFS bfs;
    private Link link;
    private ActeurEnMouvement a;

    public DeplacementBFSStrategy(Environnement env, ActeurEnMouvement a) {
        this.bfs = new BFS(Environnement.getInstance());
        this.link = env.getLink();
        this.a = a;
    }

    @Override
    public void deplacementDeBase() {
        if (link == null) {
            System.out.println("Aucun chemin vers Link.");
            return;
        }

        // Calcul du chemin vers Link
        List<int[]> chemin = bfs.cheminBFS(a.getX(), a.getY(), link.getX(), link.getY());
        if (chemin == null || chemin.size() <= 1) return;

        // Calcule la nouvelle position et vérifie les obstacles
        deplacementVersPosition(chemin.get(1));
    }
    private void deplacementVersPosition(int[] prochaineEtape) {
        int dx = prochaineEtape[0] - a.getX();
        int dy = prochaineEtape[1] - a.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        // Calcul de la nouvelle position
        int nouveauX = (int) (a.getX() + (dx / distance) * a.getVitesse());
        int nouveauY = (int) (a.getY() + (dy / distance) * a.getVitesse());

        // Vérifie les obstacles avant de se déplacer
        if (!verificationObstacles(nouveauX, nouveauY)) {
            // Essaye de se déplacer en horizontalement si le chemin est bloqué
            for (int[] direction : new int[][]{{-1, 0}, {1, 0}}) {
                int nouvellePosX = a.getX() + direction[0];
                if (verificationObstacles(nouvellePosX, a.getY())) {
                    a.setX(nouvellePosX);
                    break;
                }
            }
        } else {
            a.setX(nouveauX);
            a.setY(nouveauY);
        }
    }


    @Override
    public boolean verificationObstacles(int x, int y) {
        return bfs.estAccessible(x, y);
    }
}
