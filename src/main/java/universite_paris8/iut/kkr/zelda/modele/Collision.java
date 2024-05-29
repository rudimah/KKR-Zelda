package universite_paris8.iut.kkr.zelda.modele;

import universite_paris8.iut.kkr.zelda.Utils.ConstantesTuile;

public class Collision {

    public static boolean position(int x, int y, int largeur, int hauteur, int[][] tableauMap) {
        int largeurPersonnage = 20; // Largeur du personnage en pixels
        int hauteurPersonnage = 20; // Hauteur du personnage en pixels

        if (x < 0 || x + largeurPersonnage > largeur || y < 0 || y + hauteurPersonnage > hauteur) {
            return false;
        }

        int[][] coinsPersonnage = {{x, y}, {x + largeurPersonnage, y}, {x, y + hauteurPersonnage}, {x + largeurPersonnage, y + hauteurPersonnage}};

        for (int[] coin : coinsPersonnage) {
            if (!tuileTraversable(coin[0], coin[1], tableauMap)) {
                return false;
            }
        }

        return true;
    }

    public static boolean tuileTraversable(int x, int y, int[][] tableauMap) {
        int colonneGrille = (y + 6) / 30; //30 = taille tuile
        int ligneGrille = (x + 19) / 30;
        int tileId = tableauMap[ligneGrille][colonneGrille];

        switch (tileId) {
            case ConstantesTuile.EAU:
            case ConstantesTuile.HERBE:
                return true;
            case ConstantesTuile.IMMEUBLES_ABANDONNES:
            case ConstantesTuile.ARBRES:
            case ConstantesTuile.VOITURE_ABANDONNEE:
            case ConstantesTuile.COFFRE:
            case ConstantesTuile.PETIT_ROCHER:
            case ConstantesTuile.POUBELLE:
            case ConstantesTuile.LAVE:
                return false;
            default:
                System.out.println("Type de tuile inconnu: " + tileId);
                return false;
        }
    }
}