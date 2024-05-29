package universite_paris8.iut.kkr.zelda.modele;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;

import java.util.ArrayList;

public class Link extends ActeurEnMouvement{

    private Pane panneauDeJeu;
    private TilePane tilePane;
    private ImageView imageView;
    private int vitesseOriginale;
    private int vitesseSprint;
    private boolean sprintAppuyer = false;
    boolean pied_droite = true;
    public int tileId = 9;
    private Inventaire inventaire;

    public Link(Environnement env, Pane pj, TilePane tilePane) {
        super(80, 50, 2, env, 40, 10);
        this.vitesseOriginale = getVitesse();
        this.vitesseSprint = vitesseOriginale;
        this.panneauDeJeu = pj;
        this.tilePane = tilePane;
        this.imageView = new ImageView();
        this.inventaire = new Inventaire();
        panneauDeJeu.setFocusTraversable(true);
        panneauDeJeu.setOnKeyPressed(this::gererTouch);
        panneauDeJeu.setOnKeyReleased(this::handleKeyRelease);
        Image image1 = new Image("file:src/main/resources/image/Link/tileset.png");

        imageView.setImage(image1);
        imageView.setViewport(new Rectangle2D(20, 13, 120, 160));
        imageView.setFitWidth(20);
        imageView.setFitHeight(30);
        imageView.setTranslateX(getX());
        imageView.setTranslateY(getY());
        panneauDeJeu.getChildren().add(imageView);
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

    public boolean verifobstacle(int x, int y) {
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
        //tileId = env.getTileId(getX(), getY());
        switch (key) {

            case Z:
                nouveauY -= vitesseSprint;

                if (verifobstacle(getX(), nouveauY) && verifobstacle(getX() + 30, nouveauY)) {
                    setY(nouveauY);
                    tileId = env.getTileId(getX(), getY());
                }

                break;
            case S:
                nouveauY += vitesseSprint;
                if (verifobstacle(getX(), nouveauY) || verifobstacle(getX() + 30, nouveauY+30)) {
                    r.setTranslateX(getX());
                    r.setTranslateY(nouveauY);
//                    b.setTranslateX(getX()+20);
//                    b.setTranslateY(getY()+30);
                    setY(nouveauY);
                    tileId = env.getTileId(getX(), getY());
                }

                break;
            case D:
                nouveauX += vitesseSprint;
                if (verifobstacle(nouveauX + 30, getY()) && verifobstacle(nouveauX + 30, getY() + 30)) {
                    r.setTranslateX(nouveauX);
                    r.setTranslateY(getY());
                    setX(nouveauX);
                    tileId = env.getTileId(getX() + 30, getY());
                }
                break;
            case Q:
                nouveauX -= vitesseSprint;
                if (verifobstacle(nouveauX, getY()) && verifobstacle(nouveauX, getY() + 30)) {
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

        imageView.setTranslateX(getX());
        imageView.setTranslateY(getY());
        mettreAJourImageView(key, tileId);
        panneauDeJeu.getChildren().add(r);
        panneauDeJeu.getChildren().add(b);
        System.out.println("s'est déplacé en (" + getX() + ", " + getY() + ")");
    }

    private void mettreAJourImageView(KeyCode key, int tileId) {
        int position_image_x = 20, position_image_y = 13, position_image_eau = 0;

        switch (key) {
            case Z:
                position_image_y = 1060;
                position_image_eau = 340;
                break;
            case S:
                position_image_y = 710;
                position_image_eau = 825;
                break;
            case D:
                position_image_y = 1245;
                position_image_eau = 340;
                break;
            case Q:
                position_image_y = 902;
                position_image_eau = 980;
                break;

            case F:
                ActeurEnMouvement ennemiLePlusProche = env.trouverEnnemiLePlusProche(getX(), getY());
                if (ennemiLePlusProche != null) {
                    attaquer(ennemiLePlusProche);
                } else {
                    System.out.println("Aucun ennemi à attaquer à proximité.");
                }
                break;
        }

        if (tileId == 0 || tileId == 3) {
            imageView.setViewport(new Rectangle2D(position_image_eau, position_image_y, 120, 160));
        } else {
            if (pied_droite) {
                position_image_x = switch (key) {
                    case Z -> 170;
                    case S -> 665;
                    case D -> 180;
                    case Q -> 180;
                    default -> position_image_x;
                };
                pied_droite = false;
            } else {
                position_image_x = switch (key) {
                    case Z -> 1470;
                    case S -> 1470;
                    case D -> 1315;
                    case Q -> 1320;
                    default -> position_image_x;
                };
                pied_droite = true;
            }
            imageView.setViewport(new Rectangle2D(position_image_x, position_image_y, 120, 160));
        }
    }

    public void ramasserItem() {
        ArrayList<Item> itemsARamasser = new ArrayList<>();
        for (Item item : env.getItems()) {
            if (!item.EstRamassé() && estProcheDe(item)) {
                itemsARamasser.add(item);
            }
        }
        for (Item item : itemsARamasser) {
            inventaire.ajouterItemAInventaire(item);
            item.setEstRamassé(true);
            env.retirerItem(item);
            System.out.println("Item ramassé : " + item.getNom());
            inventaire.afficherInventaire();
        }
    }

    public boolean estProcheDe(Item item) {
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