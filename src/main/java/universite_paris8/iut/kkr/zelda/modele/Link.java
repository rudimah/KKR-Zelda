package universite_paris8.iut.kkr.zelda.modele;

import universite_paris8.iut.kkr.zelda.utils.Constantes;
import java.util.ArrayList;

public class Link extends ActeurEnMouvement{

    private int vitesseOriginale;
    private boolean sprintAppuyer = false;
    public int tileId = 9;
    private Inventaire inventaire;

    public Link(Environnement env) {
        super(80, 50, 2, env, 40, 10);
        this.vitesseOriginale = getVitesse();
        this.inventaire = new Inventaire();

    }

    public int getTileId(){
        return tileId;
    }


    public boolean verifobstacle(int tileId) {
        System.out.println("verifobstcle " + tileId);

        switch (tileId) {
            case 0: // Eau
                System.out.println("Eau");
                break;
            case 1: // Immeubles abandonnés
                System.out.println("Immeuble");
                return true;
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
            case 9: // Herbe (passable)
                System.out.println("Herbe");
                break;
            case 10: // Lave
                System.out.println("Lave");
                // Logique pour enlever des points de vie sera gérée dans la classe Link
                break;
            default:
                System.out.println("Où est-ce qu'on est !?");
                break;
        }

        return true;
    }

    public void seDeplace(int direction) {
        int nouveauX = getX(), nouveauY = getY();
        int vitesse = getVitesse();
        switch (direction) {
            case Constantes.Haut:
                nouveauY -= vitesse;
                if (verifobstacle(env.getTileId(getX(), nouveauY)) && verifobstacle(env.getTileId(getX() + 30, nouveauY))) {
                    setY(nouveauY);
                    tileId = env.getTileId(getX(), getY());

                }
                break;
            case Constantes.Bas:
                nouveauY += vitesse;
                if (verifobstacle(env.getTileId(getX(), nouveauY)) || verifobstacle(env.getTileId(getX() + 30, nouveauY+30))) {
                    setY(nouveauY);
                    tileId = env.getTileId(getX(), getY());
                }
                break;
            case Constantes.Droite:
                nouveauX += vitesse;
                if (verifobstacle(env.getTileId(nouveauX + 30, getY())) && verifobstacle(env.getTileId(nouveauX + 30, getY() + 30))) {
                    setX(nouveauX);
                    tileId = env.getTileId(getX() + 30, getY());
                }
                break;
            case Constantes.Gauche:
                nouveauX -= vitesse;
                if (verifobstacle(env.getTileId(nouveauX, getY())) && verifobstacle(env.getTileId(nouveauX, getY() + 30))) {
                    setX(nouveauX);
                    tileId = env.getTileId(getX(), getY());
                }
                break;
            default:
                System.out.println("Direction inconnue");

        }
        System.out.println(getVitesse());
        ramasserItem();
        System.out.println("s'est déplacé en (" + getX() + ", " + getY() + ")");


        if (tileId == 0) { // Eau
            vitesse = 1;
            System.out.println("Link se déplace dans l'eau, vitesse réduite à 1");
        }
        else {
           vitesse = vitesseOriginale;
        }



    }


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