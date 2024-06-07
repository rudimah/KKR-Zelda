package universite_paris8.iut.kkr.zelda.modele.Algos;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

import java.util.*;

public class BFS {
    private int premierX,premierY;

    private Environnement env;

    public BFS(Environnement env){
        this.env = env;
    }

    public List<Coordonnees> trouverCheminBFS(ActeurEnMouvement acteurEnMouvement, int butX, int butY) {
        premierX = acteurEnMouvement.getX();
        premierY = acteurEnMouvement.getY();
        Queue<Coordonnees> queue = new LinkedList<>();
        Set<String> noeudVisite = new HashSet<>();
        Coordonnees premierNoeud = new Coordonnees(premierX, premierY, null);
        queue.add(premierNoeud);
        noeudVisite.add(premierX + "," + premierY);

        while (!queue.isEmpty()) {
            Coordonnees noeudCurrent = queue.poll();

            if (noeudCurrent.x == butX && noeudCurrent.y == butY) {
                return reconstruireChemin(noeudCurrent);
            }

            for (Coordonnees voisin : getVoisins(noeudCurrent)) {
                String coordonneesVoisin = voisin.x + "," + voisin.y;
                if (!noeudVisite.contains(coordonneesVoisin) && env.verifObstacle(voisin.x, voisin.y, acteurEnMouvement)) {
                    queue.add(voisin);
                    noeudVisite.add(coordonneesVoisin);
                }
            }
        }

        return Collections.emptyList();
    }

    private List<Coordonnees> getVoisins(Coordonnees noeud) {
        List<Coordonnees> voisins = new ArrayList<>();
        voisins.add(new Coordonnees(noeud.x + 1, noeud.y, noeud));
        voisins.add(new Coordonnees(noeud.x - 1, noeud.y, noeud));
        voisins.add(new Coordonnees(noeud.x, noeud.y + 1, noeud));
        voisins.add(new Coordonnees(noeud.x, noeud.y - 1, noeud));
        return voisins;
    }

    private List<Coordonnees> reconstruireChemin(Coordonnees noeud) {
        List<Coordonnees> chemin = new ArrayList<>();
        while (noeud != null) {
            chemin.add(noeud);
            noeud = noeud.parent;
        }
        Collections.reverse(chemin);
        return chemin;
    }
}
