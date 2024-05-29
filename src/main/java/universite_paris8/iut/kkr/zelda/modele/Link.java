package universite_paris8.iut.kkr.zelda.modele;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.Vue.VueLink;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Accessoires;
import universite_paris8.iut.kkr.zelda.modele.Arme.Armes;

import java.util.ArrayList;

public class Link extends ActeurEnMouvement{

    private Pane panneauDeJeu;
    private TilePane tilePane;

    private Armes armeActuelle;
    private Accessoires accessoiresActuelles;
    private int vitesseOriginale;
    private int vitesseSprint;
    private boolean sprintAppuyer = false;
    public int tileId = 9;
    private Inventaire inventaire;

    VueLink afficherlink;

    public Link(Environnement env, Pane pj, TilePane tilePane) {
        super(80, 50, 2, env, 40, 10);
        this.vitesseOriginale = getVitesse();
        this.vitesseSprint = vitesseOriginale;
        this.panneauDeJeu = pj;
        this.tilePane = tilePane;
        this.inventaire = new Inventaire();
        panneauDeJeu.setFocusTraversable(true);
        panneauDeJeu.setOnKeyPressed(this::gererTouch);
        panneauDeJeu.setOnKeyReleased(this::handleKeyRelease);
       afficherlink = new VueLink(env, this, panneauDeJeu);
    }

    private void gererTouch(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            sprintAppuyer = true;
            vitesseSprint = vitesseOriginale * 2;
        }
        System.out.println("Touche pressée " + event.getCode());
        seDeplacer(event.getCode());
        event.consume();
    }

    private void handleKeyRelease(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            sprintAppuyer = false;
            vitesseSprint = vitesseOriginale;
            System.out.println("MAJ relâchée, vitesse normalisée.");
        }
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

    public void seDeplacer(KeyCode key) {
        int nouveauX = getX(), nouveauY = getY();
        Circle r = new Circle(1);
        Circle b = new Circle(1);
        r.setFill(Color.RED);
        b.setFill(Color.BLUE);

        switch (key) {

            case Z:
                nouveauY -= vitesseSprint;
                tileId = env.getTileId(getX(), nouveauY);

                if (verifobstacle(env.getTileId(getX(), nouveauY)) && verifobstacle(env.getTileId(getX() + 30, nouveauY))) {
                    setY(nouveauY);
                    tileId = env.getTileId(getX(), getY());
                }
                break;
            case S:
                nouveauY += vitesseSprint;
                if (verifobstacle(env.getTileId(getX(), nouveauY)) || verifobstacle(env.getTileId(getX() + 30, nouveauY+30))) {
                    setY(nouveauY);
                    tileId = env.getTileId(getX(), getY());
                }
                break;
            case D:
                nouveauX += vitesseSprint;
                if (verifobstacle(env.getTileId(nouveauX + 30, getY())) && verifobstacle(env.getTileId(nouveauX + 30, getY() + 30))) {
                    setX(nouveauX);
                    tileId = env.getTileId(getX() + 30, getY());
                }
                break;
            case Q:
                nouveauX -= vitesseSprint;
                if (verifobstacle(env.getTileId(nouveauX, getY())) && verifobstacle(env.getTileId(nouveauX, getY() + 30))) {
                    setX(nouveauX);
                }
                break;
            default:
                System.out.println("Autre Touch");
                tileId = env.getTileId(getX(), getY());
        }

        if (tileId == 0) { // Eau
            vitesseSprint = 1;
            System.out.println("Link se déplace dans l'eau, vitesse réduite à 1");
        } else {
            vitesseSprint = sprintAppuyer ? vitesseOriginale * 2 : vitesseOriginale; // Réinitialiser la vitesse en fonction de l'état de SHIFT
        }

        afficherlink.mettreAJourImageView(key, tileId);
        ramasserItem();
        System.out.println("s'est déplacé en (" + getX() + ", " + getY() + ")");
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

    public Armes getArme() {
        return armeActuelle;
    }
//    public void armeEnMain() {
//        if (armeActuelle != null) {
//            armeActuelle.utiliser(); //
//        } else {
//            System.out.println("Link n'a pas d'arme ");
//        }
//    }
//    public void attaquerEnnemi() {
//        Ennemi ennemiProche = getEnv().trouverEnnemiProche(getX(), getY(), armeActuelle.getPortee());
////        if (ennemiProche != null) {
////            int degats = armeActuelle.getPtAttaque();
////            ennemiProche.recevoirDegats(degats);
////            System.out.println("Ennemi touché ! Dégâts infligés: " + degats);
////        } else {
////            System.out.println("Aucun ennemi à portée.");
////        }
////    }


//    public Accessoires getAccessoireActuel() {
//        return accessoireActuel;
//    }
//
//    public void utiliserAccessoire() {
//        if (accessoireActuel instanceof BottesDAres) {
//            //faire la suite
//        }
//    }


}