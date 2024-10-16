package universite_paris8.iut.kkr.zelda.modele.DeplacementStrategy;

import universite_paris8.iut.kkr.zelda.modele.Acteur;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Algos.BFS;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;

import java.util.List;

public class DeplacementBFSStrategy implements DeplacementStrategy {
    private BFS bfs;
    private Link link;
    private Environnement env;
    private ActeurEnMouvement a;


    @Override
    public void deplacementDeBase() {
        if (env.getLink() == null) {
            System.out.println("Aucun chemin");
        }
        int linkX = link.getX();
        int linkY = link.getY(); //recuperer position link

        List<int[]> chemin = bfs.cheminBFS(a.getX(), a.getY(), linkX, linkY);
        if (chemin != null && !chemin.isEmpty()) { //si chemin n'est pas vide  null si le chemin na pas ete calculer
            int[] prochaineEtape = chemin.get(1); //prochain position ennnemi car get(0) la ou est l'ennnemi
            int dx = prochaineEtape[0] - a.getX();  //prochaine position  positionCible- position actuel
            int dy = prochaineEtape[1] - a.getY();
            double distance = Math.sqrt(dx * dx + dy * dy); //distance que l'ennnemi parcours en verticale et horizontale

            // Normaliser le vecteur de déplacement permet de deplacer l'ennemi a une vitesse constante et calcul nouvelle positions
            int nouveauX = (int) (a.getX() + (dx / distance) * a.getVitesse());
            int nouveauY = (int) (a.getY() + (dy / distance) * a.getVitesse());

            // Vérifier si la nouvelle position est accessible
            if (bfs.estAccessible(nouveauX, nouveauY)) {
                a.setX(nouveauX);
                a.setY(nouveauY);
            } else {
                // Essayer de se déplacer à gauche ou à droite si bloqué
                for (int[] direction : new int[][]{{-1, 0}, {1, 0}}) {
                    int tentativeEnX = a.getX() + direction[0];
                    if (bfs.estAccessible(tentativeEnX, a.getY())) {
                        a.setX(tentativeEnX);
                        //break
                    }
                }
            }
        }
    }






    @Override
    public boolean verificationObstacles(int x, int y) {
        return bfs.estAccessible(x,y);
    }
}
