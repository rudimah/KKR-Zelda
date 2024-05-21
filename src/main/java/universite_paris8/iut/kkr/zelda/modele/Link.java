package universite_paris8.iut.kkr.zelda.modele;

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
    private Image imageHautDroite;
    private Image imageHautGauche;
    private Image imageBas;
    private Image imageGauche;
    private Image imageDroite;
    boolean pied_droite = true;

    public Link(Environnement env, Pane panneauDeJeu, TilePane tilePane) {
        super(50, 50, 2, env, 50, 5);
        this.panneauDeJeu = panneauDeJeu;
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

        afficherPersonnage();
    }

    private void afficherPersonnage() {
        imageView.setTranslateX(getX());
        imageView.setTranslateY(getY());
        panneauDeJeu.getChildren().add(imageView);
    }

    private void gererTouch(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            setVitesse(getVitesse() * 2);
        }
        System.out.println("Touche pressée " + event.getCode());
        seDeplacer(event.getCode());
        event.consume();
    }

    private void handleKeyRelease(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            setVitesse(getVitesse() / 2);
            System.out.println("MAJ relâché vitesse normalisée.");
        }
    }

    public void seDeplacer(KeyCode key) {
        int nouveauX = getX(), nouveauY = getY();

        switch (key) {
            case Z:
                nouveauY = getY() - getVitesse();
                if (pied_droite) {
                    imageView.setImage(imageHautDroite);
                    pied_droite = false;
                } else {
                    imageView.setImage(imageHautGauche);
                    pied_droite = true;
                }
                break;
            case S:
                nouveauY = getY() + getVitesse();
                imageView.setImage(imageBas);
                break;
            case D:
                nouveauX = getX() + getVitesse();
                imageView.setImage(imageDroite);
                break;
            case Q:
                nouveauX = getX() - getVitesse();
                imageView.setImage(imageGauche);
                break;
        }

        System.out.println("passe des positions " + getX() + ", " + getY() + " à " + nouveauX + ", " + nouveauY);

        if (getEnv().estPositionValide(nouveauX, nouveauY)) {
            // Gestion des effets des tuiles spécifiques
            int tileId = getEnv().getTileId(nouveauX, nouveauY);
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
            System.out.println("Action bloqué par un élément de l'environnement.");
        }
    }
}
