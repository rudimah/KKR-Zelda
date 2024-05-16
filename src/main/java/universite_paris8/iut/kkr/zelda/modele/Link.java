package universite_paris8.iut.kkr.zelda.modele;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Link extends ActeurEnMouvement{


    private Pane panneauDeJeu;
    private TilePane tilePane;

    private ImageView imageView;
    private Image imageHautDroite;
    private Image imageHautGauche;
    private Image imageBas;
    private Image imageGauche;
    private Image imageDroite;
    boolean pied_droite = true;

    public Link(Environnement env, Pane pj, TilePane tilePane) {
        super(50, 50, 5, env, 40, 20);
        this.panneauDeJeu = pj;
        this.tilePane = tilePane;
        this.imageView = new ImageView();
        panneauDeJeu.setFocusTraversable(true);
        panneauDeJeu.setOnKeyPressed(this::gererTouch);
        panneauDeJeu.setOnKeyReleased(this::handleKeyRelease);

        this.imageHautDroite = new Image("file:src/main/resources/image/Link/pied_droit.png");
        this.imageHautGauche = new Image("file:src/main/resources/image/Link/pied_gauche.png");
        this.imageBas = new Image("file:src/main/resources/image/Link/bas.png");
        this.imageGauche = new Image("file:src/main/resources/image/Link/normal.png");
        this.imageDroite = new Image("file:src/main/resources/image/Link/normal.png");

    }

    private void gererTouch(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            setVitesse(getVitesse()*2);
        }
        System.out.println("Touche pressé " + event.getCode());
        seDeplacer(event.getCode());
        event.consume();
    }
    private void handleKeyRelease(KeyEvent event) {
        // Reset the direction when shift is released
        if (event.getCode() == KeyCode.SHIFT) {
            setVitesse(getVitesse()/2);
            System.out.println("MAJ relâchée, vitesse normalisée.");
        }
    }

    public void seDeplacer(KeyCode key) {

        int newX = getX(), newY = getY();
        ImageView imageView = new ImageView();


        switch (key) {
            case Z:

                newY = getY()-getVitesse();
                if (pied_droite){
                    imageView.setImage(imageHautDroite);
                    pied_droite= false;
                }
                else {
                    imageView.setImage(imageHautGauche);
                    pied_droite = true;
                }
                //r.setFill(Color.RED);
                break;
            case S:
                newY = getY()+getVitesse();
                imageView.setImage(imageBas);

                break;
            case D:
                newX = (getX()+getVitesse());
                imageView.setImage(imageDroite);
                break;
            case Q:
                newX = (getX()-getVitesse());
                imageView.setImage(imageGauche);
                break;

        }
        System.out.println("Essaye de passer de " + getX() + ", " + getY() );

        if (env.estPositionValide(newX, newY)) {
            panneauDeJeu.getChildren().clear();

            setX(newX);
            setY(newY);
            imageView.setTranslateX(getX());
            imageView.setTranslateY(getY());
            panneauDeJeu.getChildren().add(imageView);

            System.out.println("s'est déplacé en (" + getX() + ", " + getY() + ")");
        } else {
            System.out.println("Mouvement bloqué par un élément de l'environnement.");
        }


    }
}
