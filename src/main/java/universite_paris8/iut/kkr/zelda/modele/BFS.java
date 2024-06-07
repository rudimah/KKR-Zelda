package universite_paris8.iut.kkr.zelda.modele;

import universite_paris8.iut.kkr.zelda.utils.Constantes;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    // Directions: droite, bas, gauche, haut
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private Environnement environnement;

    public BFS(Environnement env) {
        this.environnement = env;
    }

    // Vérifie si la position est accessible pour se déplacer
    private boolean estAccessible(int x, int y) {
        int typeCellule = environnement.getTuile(x, y);
        return typeCellule != Constantes.EAU &&
                typeCellule != Constantes.IMMEUBLES_ABANDONNES &&
                typeCellule != Constantes.ARBRES &&
                typeCellule != Constantes.BUISSON &&
                typeCellule != Constantes.COFFRE &&
                typeCellule != Constantes.PETIT_ROCHER &&
                typeCellule != Constantes.POUBELLE &&
                typeCellule != Constantes.ROCHER_EN_LAVE &&
                typeCellule != Constantes.VOITURE_ABANDONNEE &&
                typeCellule != Constantes.GROS_ROCHER &&
                typeCellule != Constantes.LAVE;
    }


    public int[] effectuerBFS(int departX, int departY, int destinationX, int destinationY) {
        Queue<int[]> file = new LinkedList<>();
        boolean[][] visite = new boolean[environnement.getLargeur()][environnement.getHauteur()];
        file.add(new int[]{departX, departY});
        visite[departX][departY] = true;

        System.out.println("BFS démarrée de (" + departX + ", " + departY + ") vers (" + destinationX + ", " + destinationY + ").");

        while (!file.isEmpty()) {
            int[] position = file.poll();
            int x = position[0];
            int y = position[1];

            if (x == destinationX && y == destinationY) {
                System.out.println("Destination atteinte pendant BFS: (" + x + ", " + y + ")");
                return new int[]{x, y};
            }

            for (int[] direction : DIRECTIONS) {
                int nouveauX = x + direction[0];
                int nouveauY = y + direction[1];

                if (nouveauX >= 0 && nouveauX < environnement.getLargeur() &&
                        nouveauY >= 0 && nouveauY < environnement.getHauteur() &&
                        !visite[nouveauX][nouveauY] && estAccessible(nouveauX, nouveauY)) {
                    file.add(new int[]{nouveauX, nouveauY});
                    visite[nouveauX][nouveauY] = true;
                    System.out.println("Position accessible" + nouveauX + ", " + nouveauY);
                }
            }
        }

        System.out.println("Aucun chemin trouvé pendant BFS");
        return null;
    }
}

