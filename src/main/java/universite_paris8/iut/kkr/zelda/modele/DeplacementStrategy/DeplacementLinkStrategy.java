package universite_paris8.iut.kkr.zelda.modele.DeplacementStrategy;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.DeplacementStrategy.DeplacementStrategy;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;
import universite_paris8.iut.kkr.zelda.utils.Carte;
import universite_paris8.iut.kkr.zelda.utils.Constantes;

    public class DeplacementLinkStrategy implements DeplacementStrategy {
        private Carte carte;
        private Link link;

        @Override
        public void deplacementDeBase() {
            int vitesse = link.getVitesse();
            int nouveauX = link.getX();
            int nouveauY = link.getY();
            int xGauche = nouveauX;
            int yHaut = nouveauY;
            int xDroite = nouveauX + 30;
            int yBas = nouveauY + 30;

            switch (link.getDirection()) {
                case Constantes.Haut:
                    nouveauY = -vitesse;
                    break;
                case Constantes.Bas:
                    nouveauY = vitesse;
                    break;
                case Constantes.Droite:
                    nouveauX = vitesse;
                    break;
                case Constantes.Gauche:
                    nouveauX = -vitesse;
                    break;
            }
            link.setDirection(0);


            if (verificationObstacles(xDroite + nouveauX, yHaut + nouveauY) && verificationObstacles(xGauche + nouveauX, yBas + nouveauY)) {
                link.setX(nouveauX);
                link.setY(nouveauY);
                carte.getTuile(xGauche + 15, yHaut + nouveauY / 2 + nouveauX / 2);
            }
        }


        @Override
        public boolean verificationObstacles(int x, int y) {
            int tileID = carte.getTuile(x, y);

            // Vérifie les limites du terrain pour éviter les mouvements hors champ
            if (x < 0 || x + 20 > link.getLargeur() || y < 0 || y + 30 > link.getHauteur()) {
                return false;
            }

            // Gère les différents types d'obstacles
            switch (tileID) {
                case Constantes.EAU:
                    link.setVitesse(3);
                    break;
                case Constantes.LAVE:
                    link.setPv(link.getPv() - 1);
                    return false;
                case Constantes.IMMEUBLES_ABANDONNES:
                case Constantes.ARBRES:
                case Constantes.VOITURE_ABANDONNEE:
                case Constantes.PETIT_ROCHER:
                case Constantes.POUBELLE:
                case Constantes.GROS_ROCHER:
                    return false;
                default:
                    break;
            }
            return true;
        }
    }
