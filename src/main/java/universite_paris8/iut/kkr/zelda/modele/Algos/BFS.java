package universite_paris8.iut.kkr.zelda.modele.Algos;

import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.utils.Constantes;

import java.util.*;

public class BFS {

    private static final int[][] DIRECTIONS = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0},  // Droite, Bas, Gauche, Haut
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1} // Diagonales: Bas-Droite, Haut-Gauche, Bas-Gauche, Haut-Droite
    };

    private int[] obstacles = {
            Constantes.EAU,Constantes.IMMEUBLES_ABANDONNES, Constantes.ARBRES,
            Constantes.BUISSON, Constantes.COFFRE, Constantes.PETIT_ROCHER,
            Constantes.POUBELLE, Constantes.ROCHER_EN_LAVE, Constantes.VOITURE_ABANDONNEE,
            Constantes.GROS_ROCHER, Constantes.LAVE
    };
    private Environnement environnement;

    public BFS(Environnement env) {
        this.environnement = env;
    }

    // Vérifie si la position est accessible pour se déplacer
    public boolean estAccessible(int x, int y) {
        int tuile = environnement.getTuile(x, y);

        // Parcourir le tableau d'obstacles pour voir si la tuile==obstacle
        for (int i=0; i<obstacles.length;i++) {
            if (tuile == obstacles[i]) {
                return false; // La cellule est un obstacle
            }
        }
        return true; // Aucun obstacle trouvé
    }


    public List<int[]> cheminBFS(int departX, int departY, int arriveeX, int arriveeY) {
        if (!estAccessible(arriveeX, arriveeY)) {
            return Collections.emptyList(); // Destination non accessible
        }

        Queue<int[]> file = new LinkedList<>();
        Map<Integer, int[]> parentMap = new HashMap<>();
        boolean[][] visite = new boolean[environnement.getLargeur()][environnement.getHauteur()];

        file.add(new int[]{departX, departY});
        visite[departX][departY] = true;
        parentMap.put(departY * environnement.getLargeur() + departX, null);

        while (!file.isEmpty()) {
            int[] courant = file.poll();
            int x = courant[0];
            int y = courant[1];

            if (x == arriveeX && y == arriveeY) {
                return reconstruireChemin(parentMap, courant); // Retourne le chemin complet en reconstruisant
            }

            for (int[] direction : DIRECTIONS) {
                int xSuivant = x + direction[0];
                int ySuivant = y + direction[1];

                if (estDanslimites(xSuivant, ySuivant) && !visite[xSuivant][ySuivant] && estAccessible(xSuivant, ySuivant)) {
                    visite[xSuivant][ySuivant] = true;
                    file.add(new int[]{xSuivant, ySuivant});
                    parentMap.put(ySuivant * environnement.getLargeur() + xSuivant, courant);
                }
            }
        }

        return Collections.emptyList(); // Aucun chemin trouvé
    }

    public boolean estDanslimites(int x, int y) {
        return x >= 0 && x < environnement.getLargeur() && y >= 0 && y < environnement.getHauteur();
    }

    private List<int[]> reconstruireChemin(Map<Integer, int[]> parentMap, int[] arrivee) {
        LinkedList<int[]> chemin = new LinkedList<>();
        int[] etape = arrivee;
        while (etape != null) {
            chemin.addFirst(etape);
            etape = parentMap.get(etape[1] * environnement.getLargeur() + etape[0]);
        }

        return chemin;
    }


}
