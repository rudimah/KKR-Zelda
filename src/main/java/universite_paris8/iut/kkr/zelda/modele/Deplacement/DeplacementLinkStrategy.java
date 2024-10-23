package universite_paris8.iut.kkr.zelda.modele.Deplacement;

import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;
import universite_paris8.iut.kkr.zelda.utils.Constantes;

public class DeplacementLinkStrategy implements DeplacementStrategy{
    private Link link;
    private Environnement env;


    public DeplacementLinkStrategy(Link link){
        this.env = Environnement.getInstance();
        this.link=link;

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
            System.out.println("Link déplacé vers : X = " + nouveauX + " Y = " + nouveauY);
        } else {
            System.out.println("Déplacement bloqué obstacle devant");
        }

        // Réinitialiser la direction après le mouvement
        link.setDirection(0);
    }




    @Override
    public boolean verificationObstacles(int x, int y) {
        int tileID = env.getTuile(x, y);

        // Vérifier les limites du terrain pour éviter hors champ
        if (x < 0 || x >= env.getLargeur() || y < 0 || y >= env.getHauteur()) {
            return false;
        }

        // Gestion des différents types d'obstacles
        switch (tileID) {
            case Constantes.EAU:
                link.setVitesse(3); // Link peut bouger sur l'eau, mais plus lentement
                break;
            case Constantes.HERBE:
            case Constantes.CHEMIN_EN_PIERRE:
                link.setVitesse(link.getVitesse()); // Réinitialiser la vitesse après l'eau
                break;
            case Constantes.LAVE:
                link.setPv(link.getPv() - 1); // Link perd de la vie sur la lave
                return false;
            case Constantes.IMMEUBLES_ABANDONNES:
            case Constantes.ARBRES:
            case Constantes.VOITURE_ABANDONNEE:
            case Constantes.PETIT_ROCHER:
            case Constantes.POUBELLE:
            case Constantes.GROS_ROCHER:
                return false; // Ce sont des obstacles
            default:
                break;
        }

        return true;
    }
}
