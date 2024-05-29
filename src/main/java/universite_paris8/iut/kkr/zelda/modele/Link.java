package universite_paris8.iut.kkr.zelda.modele;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class Link extends ActeurEnMouvement {

    private Pane panneauDeJeu;
    private TilePane tilePane;
    private ImageView imageView;
    private Arme armeActuelle;
    private Accessoires accessoiresActuelles;
    private int vitesseOriginale;
    private int vitesseSprint;
    private boolean sprintAppuyer = false;
    boolean pied_droite = true;

    public Link(Environnement env, Pane pj, TilePane tilePane) {
        super(50, 50, 2, env, 40, 10);
        this.vitesseOriginale = getVitesse();
        this.vitesseSprint = 0;
        this.panneauDeJeu = pj;
        this.tilePane = tilePane;
        this.imageView = new ImageView();
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

    public void seDeplacer(KeyCode key) {
        int nouveauX = getX(), nouveauY = getY();
        int position_image_x = 20, position_image_y = 13, position_image_eau = 0;

        switch (key) {
            case Z:
                nouveauY = getY() - vitesseSprint;
                position_image_y = 1060;
                position_image_eau = 340;
                if (pied_droite) {
                    position_image_x = 170;
                    pied_droite = false;
                } else {
                    position_image_x = 1470;
                    pied_droite = true;
                }
                break;
            case S:
                nouveauY = getY() + vitesseSprint;
                position_image_eau = 825;
                position_image_y = 710;
                if (pied_droite) {
                    position_image_x = 665;
                    pied_droite = false;
                } else {
                    position_image_x = 1470;
                    pied_droite = true;
                }
                break;
            case D:
                nouveauX = getX() + vitesseSprint;
                position_image_eau = 340; // position x de l'image quand link va sur l'eau
                position_image_y = 1245;
                if (pied_droite) {
                    position_image_x = 180;
                    pied_droite = false;
                } else {
                    position_image_x = 1315;
                    pied_droite = true;
                }
                break;
            case Q:
                nouveauX = getX() - vitesseSprint;
                position_image_eau = 980;
                position_image_y = 902;
                if (pied_droite) {
                    position_image_x = 180;
                    pied_droite = false;
                } else {
                    position_image_x = 1320;
                    pied_droite = true;
                }
                break;
        }
        System.out.println("Essaye de passer de " + getX() + ", " + getY() + " à " + nouveauX + ", " + nouveauY);

        int tileId = getEnv().getTileId(nouveauX, nouveauY);
        if (tileId == 0) { // Eau
            vitesseSprint = 1;
            System.out.println("Link se déplace dans l'eau, vitesse réduite à 1");
            imageView.setViewport(new Rectangle2D(position_image_eau, position_image_y, 120, 160));
        } else {
            vitesseSprint = sprintAppuyer ? vitesseOriginale * 2 : vitesseOriginale; // Réinitialiser la vitesse en fonction de l'état de SHIFT
            imageView.setViewport(new Rectangle2D(position_image_x, position_image_y, 120, 160));
        }

        if (getEnv().estPositionValide(nouveauX, nouveauY)) {
            if (tileId == 10) { // Lave
                decrementerPv(5);
                System.out.println("Link est sur la Lave ! Point de vies restants: " + getPointsDeVie());
            }

            panneauDeJeu.getChildren().clear();
            setX(nouveauX);
            setY(nouveauY);
            imageView.setTranslateX(getX());
            imageView.setTranslateY(getY());
            panneauDeJeu.getChildren().add(imageView);

            System.out.println("s'est déplacé en (" + getX() + ", " + getY() + ")");
        } else {
            System.out.println("Action bloquée par un élément de l'environnement.");
        }
    }

    public Arme getArme() {
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