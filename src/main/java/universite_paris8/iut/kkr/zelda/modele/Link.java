package universite_paris8.iut.kkr.zelda.modele;

import universite_paris8.iut.kkr.zelda.Controleur.DialogueController;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Accessoires;
import universite_paris8.iut.kkr.zelda.modele.Arme.Arme;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Potion.Potion;
import universite_paris8.iut.kkr.zelda.utils.Constantes;
import java.util.ArrayList;

public class Link extends ActeurEnMouvement{

    public int tileId = 9;
    private Inventaire inventaire;
    private int Direction ;
    private Arme armeActuelle;
    private Accessoires accessoireActuel;
    private int vitesse;
    private DialogueController dialogue;
    private ArrayList<ActeurEnMouvement> ennemisAttaquer;
    public Link(Environnement env, DialogueController dialogue) {
        super(80, 50, 10, env, 150, 10);
        this.inventaire = new Inventaire();
        ennemisAttaquer = new ArrayList();
        this.dialogue=dialogue;
    }

    public void demanderDialogue() {
        if (dialogue!= null) {
            dialogue.roueDialogue();
        }
    }

    public void seDeplacer() {

        int nouveauX = getX(), nouveauY = getY();
        int xGauche, yHaut, yBas, xDroite;
        xGauche = nouveauX;
        xDroite = nouveauX + 30;
        yHaut = nouveauY;
        yBas = nouveauY + 30;

        if (tileId == 0) { // Eau
            vitesse = 3;
            System.out.println("Link se déplace dans l'eau, vitesse réduite à 1");
        } else if (tileId == Constantes.LAVE) {
            setPv(getPv()-1);
            System.out.println("Link se déplace dans la lave, point de vie réduite à 1");
        } else {
            vitesse = getVitesse();
        }

        switch (Direction) {
            case Constantes.Haut:
                nouveauY -= vitesse;
                if(env.verifObstacle(xDroite, yHaut, this) && env.verifObstacle(xGauche, yHaut, this)){
                    setY(nouveauY);
                    tileId = env.getTuile(xGauche+15, yHaut);
                }
                break;
            case Constantes.Bas:
                nouveauY += vitesse;
                if(env.verifObstacle(xDroite, yBas, this) && env.verifObstacle(xGauche, yBas, this)){
                    setY(nouveauY);
                    tileId = env.getTuile(xGauche+15, yBas);
                }
                break;
            case Constantes.Droite:
                nouveauX += vitesse;
                if(env.verifObstacle(xDroite, yHaut, this) && env.verifObstacle(xDroite, yBas, this)){
                    setX(nouveauX);
                    tileId = env.getTuile(xGauche, yHaut+15);
                }
                break;
            case Constantes.Gauche:
                nouveauX -= vitesse;
                if(env.verifObstacle(xGauche, yHaut, this) && env.verifObstacle(xGauche, yBas, this)){
                    setX(nouveauX);
                    tileId = env.getTuile(xGauche, yHaut+15);
                }
                break;
            default:
//                System.out.println("Direction inconnue");
        }
        Direction = 0;
        if(inventaire.getInventaire().size()<4){
            ramasserItem();
        }
//        System.out.println("s'est déplacé en (" + getX() + ", " + getY() + ")");

    }
    public int getDirection(){return Direction;}
    public void setDirection(int d){Direction = d;}
    public void ramasserItem() {
        ArrayList<ObjetEnvironnement> itemsARamasser = new ArrayList<>();
        for (ObjetEnvironnement item : env.getItems()) {
            if (!item.EstRamassé() && procheDe(item.getX(), item.getY(), 15) ) {
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

    public void ajouterEnnemisAttaquer(ActeurEnMouvement acteurEnMouvement){
        ennemisAttaquer.add(acteurEnMouvement);
    }

    public ArrayList<ActeurEnMouvement> getEnnemisAttaquer() {
        return ennemisAttaquer;
    }

    public void attaquerAMainsNues(ActeurEnMouvement acteurCible) {
        acteurCible.recevoirDegats(getPtAttaque());
        System.out.println("Link attaque " + acteurCible + " à mains nues ! Il lui reste " + acteurCible.getPv() + " pv ");
    }
    @Override
    public void attaquer(ActeurEnMouvement ennemi) {
        if (armeActuelle != null) {

            armeActuelle.attaquer(); // Utilise l'arme actuelle pour attaquer l'ennemi
            System.out.println("Link attaque " + ennemi + " avec " + armeActuelle.toString() + " Il reste " + ennemi.getPv() + " pv à l'ennemi");
        }
        else {
            attaquerAMainsNues(ennemi);
        }
    }


    public Arme getArme() {
        return armeActuelle;
    }

    public Accessoires getAccessoireActuel() {
        return accessoireActuel;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }


    public void utiliser(ObjetEnvironnement a){
        if( a instanceof Arme){
            if (armeActuelle!=null) inventaire.getInventaire().add(armeActuelle);
            armeActuelle =  (Arme) a;
            System.out.println("Link est équipé de l'arme : " + armeActuelle.getNom());

        } else if (a instanceof Accessoires) {
            accessoireActuel = (Accessoires) a;
            accessoireActuel.appliquerEffet();
            System.out.println("Link est équipé de l'acesoire  : " + accessoireActuel.getNom());
        }
        else {
            Potion potion = (Potion) a;
            System.out.println("utilisaton potion");
            potion.appliquerPotion();

        }
    }
}