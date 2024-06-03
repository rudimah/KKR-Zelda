package universite_paris8.iut.kkr.zelda.modele;

import universite_paris8.iut.kkr.zelda.utils.Constantes;
import java.util.ArrayList;

public class Link extends ActeurEnMouvement{

    public int tileId = 9;
    private Inventaire inventaire;
    private int Direction ;

    private int vitesse;
    public Link(Environnement env) {
        super(80, 50, 2, env, 40, 10);
        this.inventaire = new Inventaire();
    }

    public void seDeplace() {

        int nouveauX = getX(), nouveauY = getY();
        int xGauche, yHaut, yBas, xDroite;
        xGauche = nouveauX;
        xDroite = nouveauX+30;
        yHaut = nouveauY;
        yBas = nouveauY + 30;

        if (tileId == 0) { // Eau
            vitesse = 1;
            System.out.println("Link se déplace dans l'eau, vitesse réduite à 1");
        }
        else {
            vitesse = getVitesse();
        }

        switch (Direction) {
            case Constantes.Haut:
                nouveauY -= vitesse;
                if(verifObstacle(xDroite, yHaut) && verifObstacle(xGauche, yHaut)){
                    setY(nouveauY);
                    tileId = env.getTuile(xGauche+15, yHaut);
                }
                break;
            case Constantes.Bas:
                nouveauY += vitesse;
                if(verifObstacle(xDroite, yBas) && verifObstacle(xGauche, yBas)){
                    setY(nouveauY);
                    tileId = env.getTuile(xGauche+15, yBas);
                }
                break;
            case Constantes.Droite:
                nouveauX += vitesse;
                if(verifObstacle(xDroite, yHaut) && verifObstacle(xDroite, yBas)){
                    setX(nouveauX);
                    tileId = env.getTuile(xGauche, yHaut+15);
                }
                break;
            case Constantes.Gauche:
                nouveauX -= vitesse;
                if(verifObstacle(xGauche, yHaut) && verifObstacle(xGauche, yBas)){
                    setX(nouveauX);
                    tileId = env.getTuile(xGauche, yHaut+15);
                }
                break;
            default:
                System.out.println("Direction inconnue");
        }
        Direction = 0;

        ramasserItem();
        System.out.println("s'est déplacé en (" + getX() + ", " + getY() + ")");

    }
    public boolean verifObstacle(int x, int y){
        int tuile  = env.getTuile(x, y);
        switch (tuile){
            case 1: // Immeubles abandonnés
                System.out.println("Immeuble");
                return false;
            case 2: // Arbres
                System.out.println("Arbre");
                return false;
            case 8: // Voiture abandonnée
                System.out.println("Voiture");
                return false;
            case 4: // Coffre
                System.out.println("coffre");
                return false;
            case 5: // Rocher
                System.out.println("Rocher");
                return false;
            case 6: // Poubelle
                System.out.println("Poubelle");
                return false;

            default:
                System.out.println("Où est-ce qu'on est !?");
                break;
        }
        return true;
    }
    public int getDirection(){return Direction;}
    public void setDirection(int d){Direction = d;}
    public void ramasserItem() {
        ArrayList<ObjetEnvironnement> itemsARamasser = new ArrayList<>();

        for (ObjetEnvironnement item : env.getItems()) {
            if (!item.EstRamassé() && estProcheDe(item)) {
                itemsARamasser.add(item);
            }
        }
        for (ObjetEnvironnement item : itemsARamasser) {
            inventaire.ajouterItemAInventaire(item);
            item.setEstRamassé(true);
            env.retirerItem(item);
            System.out.println("Item ramassé : " + item.getNom());
            inventaire.afficherInventaire();
        }
    }
    public boolean estProcheDe(ObjetEnvironnement item) {
        int distance = 15;
        return Math.abs(getX() - item.getX()) < distance && Math.abs(getY() - item.getY()) < distance;
    }
    @Override
    public void attaquer(ActeurEnMouvement acteurCible) {
        if (estADistanceAttaque(acteurCible)) {
            acteurCible.decrementerPv(getPtAttaque());
        }
        System.out.println("Link attaque " + acteurCible + " ! Il reste " + acteurCible.getPv() + " pv.");
    }

}