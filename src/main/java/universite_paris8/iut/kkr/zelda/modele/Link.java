package universite_paris8.iut.kkr.zelda.modele;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class Link extends ActeurEnMouvement{


    private Pane panneauDeJeu;
    private TilePane tilePane;
    private ImageView imageView;
    boolean pied_droite = true;

    public Link(Environnement env, Pane pj, TilePane tilePane) {
        super(50, 50, 2, env, 40, 10);
        this.panneauDeJeu = pj;
        this.tilePane = tilePane;
        this.imageView = new ImageView();
        panneauDeJeu.setFocusTraversable(true);
        panneauDeJeu.setOnKeyPressed(this::gererTouch);
        panneauDeJeu.setOnKeyReleased(this::handleKeyRelease);
        Image image1 = new Image("file:src/main/resources/image/Link/tileset.png");


        imageView.setImage(image1);
        imageView.setViewport(new Rectangle2D( 20,13,120,160));
        imageView.setFitWidth(20);
        imageView.setFitHeight(30);

        imageView.setTranslateX(getX());
        imageView.setTranslateY(getY());
        panneauDeJeu.getChildren().add(imageView);
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

        int nouveauX = getX(), nouveauY = getY();
        int position_image_x = 20, position_image_y = 13, position_image_eau = 0;

        switch (key) {
            case Z:
                nouveauY = getY()-getVitesse();
                position_image_y = 1060;
                position_image_eau = 320;
                if (pied_droite){
                    position_image_x = 170;
                    pied_droite= false;
                }
                else {
                    position_image_x = 1470;
                    pied_droite = true;
                }

                break;
            case S:
                nouveauY = getY()+getVitesse();
                position_image_eau = 800;
                position_image_y = 710;
                if (pied_droite){
                    position_image_x = 665;
                    pied_droite= false;
                }
                else {
                    position_image_x = 1470;
                    pied_droite = true;
                }


                break;
            case D:
                nouveauX = (getX()+getVitesse());
                position_image_eau = 335; //position x de l'image quand link va sur l'eau
                position_image_y = 1245;
                if (pied_droite){
                    position_image_x = 180;
                    pied_droite= false;
                }
                else {
                    position_image_x = 1315;
                    pied_droite = true;
                }
                break;
            case Q:
                nouveauX = (getX()-getVitesse());
                position_image_y = 895;
                if (pied_droite){
                    position_image_x = 180;
                    pied_droite= false;
                }
                else {
                    position_image_x = 1320;
                    pied_droite = true;
                }
                break;
            default:
                position_image_x = position_image_x;
                position_image_y = position_image_y;
                ;
        }
        System.out.println("Essaye de passer de " + getX() + ", " + getY() );

        if (getEnv().estPositionValide(nouveauX, nouveauY)) {
            // Gestion des effets des tuiles spécifiques
            int tileId = getEnv().getTileId(nouveauX, nouveauY);
            if (tileId == 10) { // Lave
                decrementerPv(5);
                System.out.println("Link est sur la Lave ! Point de vies restants: " + getPointsDeVie());
            }

            if (tileId ==0){
                imageView.setViewport(new Rectangle2D(position_image_eau, position_image_y, 120, 160));
            }
            else {
                imageView.setViewport(new Rectangle2D(position_image_x, position_image_y, 120, 160));
            }
            panneauDeJeu.getChildren().clear();
            imageView.setTranslateX(getX());
            imageView.setTranslateY(getY());
            panneauDeJeu.getChildren().add(imageView);
            setX(nouveauX);
            setY(nouveauY);

            System.out.println("s'est déplacé en (" + getX() + ", " + getY() + ")");
        } else {
            System.out.println("Action bloqué par un élément de l'environnement.");
        }
    }
}
