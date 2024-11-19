package universite_paris8.iut.kkr.zelda.modele.Deplacement;

import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;
import universite_paris8.iut.kkr.zelda.utils.Constantes;

public class DeplacementLinkStrategy implements DeplacementStrategy{
    private Link link;
    private Environnement env;
    private boolean dansEau=false;
    private int vitesseInit;

    public DeplacementLinkStrategy(Link link){
        this.env = Environnement.getInstance();
        this.link=link;
        this.vitesseInit= link.getVitesse();

    }

    @Override
    public void deplacementDeBase() {
        int vitesse = link.getVitesse();
        int nouveauX = link.getX();
        int nouveauY = link.getY();

        // Calculer la nouvelle position en fonction de la direction
        switch (link.getDirection()) {
            case Constantes.Haut -> nouveauY -= vitesse;
            case Constantes.Bas -> nouveauY += vitesse;
            case Constantes.Droite -> nouveauX += vitesse;
            case Constantes.Gauche -> nouveauX -= vitesse;
        }


        // Vérifier les obstacles avant de mettre à jour la position
        if (verificationObstacles(nouveauX, nouveauY)) {
            link.setX(nouveauX);
            link.setY(nouveauY);
            System.out.println("Link déplacé vers : X = " + nouveauX + " Y = " + nouveauY + " vitesse" + vitesse);
        } else {
            System.out.println("Déplacement bloqué obstacle devant");
        }

        // Réinitialiser la direction après le mouvement
        link.setDirection(0);
    }


        @Override
    public boolean verificationObstacles(int x, int y) {
        int tileID = env.getCarte().getTuile(x, y);

        // Vérifier les limites du terrain pour éviter hors champ
        if (x < 0 || x >= env.getLargeur() || y < 0 || y >= env.getHauteur()) {
            return false;
        }
            // Gestion des différents types d'obstacles
            switch (tileID) {
                case Constantes.EAU:
                    if (!dansEau) { //dans eau
                        link.setVitesse(3);
                        dansEau = true;
                    }
                    break;
                default:
                    // hors de l'eau
                    if (dansEau) {
                        link.setVitesse(vitesseInit);
                        dansEau = false;
                    }
                    if (tileID == Constantes.LAVE) {
                        link.setPv(link.getPv() - 1); // Link perd pv sur la lave
                    }
                    break;
            }
        if (tileID == Constantes.IMMEUBLES_ABANDONNES ||
                tileID == Constantes.ARBRES ||
                tileID == Constantes.VOITURE_ABANDONNEE ||
                tileID == Constantes.PETIT_ROCHER ||
                tileID == Constantes.POUBELLE ||
                tileID == Constantes.GROS_ROCHER) {
            return false;
        }
        return true;
    }

}

