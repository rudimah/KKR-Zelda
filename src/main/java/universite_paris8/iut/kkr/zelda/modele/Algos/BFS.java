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
        if (!estDanslimites(x, y)) {
            return false;
        }

        int tuile = environnement.getTuile(x, y);

        // Vérifie si la tuile correspond à un obstacle
        for (int obstacle : obstacles) {
            if (tuile == obstacle) {
                return false;
            }
        }

        return true;
    }



    public List<int[]> cheminBFS(int departX, int departY, int arriveeX, int arriveeY) {
        if (!estAccessible(arriveeX, arriveeY)) {
            return Collections.emptyList(); // Destination non accessible
        }

        Queue<int[]> file = new LinkedList<>();  //posiiton a explorer fifo
        Map<Integer, int[]> vientde = new HashMap<>();
        boolean[][] visite = new boolean[environnement.getLargeur()][environnement.getHauteur()]; //enregistre les position deja visite

        file.add(new int[]{departX, departY}); //point de départ
        visite[departX][departY] = true; //marquer visité
        vientde.put(departX * environnement.getLargeur() + departY, null); //d'ou on vient encoder les indices dans une case et eviter les collision ex ; 1.3 et 3.1

        while (!file.isEmpty()) {
            int[] positionactuel = file.poll();
            int x = positionactuel[0];
            int y = positionactuel[1];

            if (x == arriveeX && y == arriveeY) {
                return reconstruireChemin(vientde, positionactuel); // Retourne le chemin jsuqua l'arriver
            }

            for (int[] direction : DIRECTIONS) { //explore les direction depuis les coordonnées
                int xSuivant = x + direction[0];
                int ySuivant = y + direction[1];

                if (estDanslimites(xSuivant, ySuivant) && !visite[xSuivant][ySuivant] && estAccessible(xSuivant, ySuivant)) { //vérif avant de passer a la position 1. si dans les limites
                    visite[xSuivant][ySuivant] = true; //met la posiiton a true car considere visité
                    file.add(new int[]{xSuivant, ySuivant}); // ajoute les coordoner a la file
                    vientde.put(ySuivant * environnement.getLargeur() + xSuivant, positionactuel); //stock d'ou elle vient
                }
            }
        }

        return Collections.emptyList(); //renvoie la liste si vide ou non
    }

    public boolean estDanslimites(int x, int y) {
        return x >= 0 && x < environnement.getLargeur() && y >= 0 && y < environnement.getHauteur();
    }

   public List<int[]> reconstruireChemin(Map<Integer,int[]> parentMap, int[] arrivee) {
        LinkedList<int[]> chemin = new LinkedList<>();
        int[] pointdepart = arrivee; //depart de la reconstruction arriver -> départ ( cest la case d'arrivé)
        while (pointdepart != null) { //tant que pt de depart non atteint
            chemin.addFirst(pointdepart);
            pointdepart = parentMap.get(pointdepart[1] * environnement.getLargeur() + pointdepart[0]); //vient de
        }

        return chemin;
    }


}
