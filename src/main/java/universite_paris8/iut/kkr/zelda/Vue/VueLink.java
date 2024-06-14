package universite_paris8.iut.kkr.zelda.Vue;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;
import universite_paris8.iut.kkr.zelda.utils.Constantes;



public class VueLink implements ChangeListener<Number>{

    boolean pied_droite = true;
    Environnement environnement;
    Link link;
    private Pane panneauDeJeu;
    private ImageView imageView;

    private int direction;

    public VueLink(Environnement env, Link link,  Pane panneauDeJeu){
        environnement = env;
        this.link = link;
        this.panneauDeJeu = panneauDeJeu;
        this.imageView = new ImageView();
        Image image1 = new Image("file:src/main/resources/image/Link/tileset.png");

        imageView.setImage(image1);
        imageView.setViewport(new Rectangle2D(20, 13, 120, 160));
        imageView.setFitWidth(link.getLargeur());
        imageView.setFitHeight(link.getLongueur());
        imageView.setTranslateX(link.getX());
        imageView.setTranslateY(link.getY());
        panneauDeJeu.getChildren().add(imageView);
    }


    @Override
    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

        this.panneauDeJeu.setTranslateX( panneauDeJeu.getPrefWidth() / 2 - link.getX()-(30));
        this.panneauDeJeu.setTranslateY( panneauDeJeu.getPrefHeight() / 2 - link.getY()-(30));
        panneauDeJeu.setTranslateX(panneauDeJeu.getPrefWidth() / 2 - link.getX()-(30));
        panneauDeJeu.setTranslateY(panneauDeJeu.getPrefHeight() /2 - link.getY()-(30));


        imageView.setTranslateX(link.getX());
        imageView.setTranslateY(link.getY());
            int position_image_x = 20, position_image_y = 13, position_image_eau = 0;

        direction = link.getDirection();
        switch (direction) {
                case Constantes.Haut:
                    position_image_y = 1060;
                    position_image_eau = 340;
                    break;
                case Constantes.Bas:
                    position_image_y = 710;
                    position_image_eau = 825;
                    break;
                case Constantes.Droite:
                    position_image_y = 1245;
                    position_image_eau = 340;
                    break;
                case Constantes.Gauche:
                    position_image_y = 902;
                    position_image_eau = 980;
                    break;

            }
            int tileId = link.tileId;
            if (tileId == 0 || tileId == 3) {
                imageView.setViewport(new Rectangle2D(position_image_eau, position_image_y, 120, 160));
            } else {
                if (pied_droite) {
                    position_image_x = switch (direction) {
                        case Constantes.Haut -> 170;
                        case Constantes.Bas -> 665;
                        case Constantes.Droite -> 180;
                        case Constantes.Gauche -> 180;
                        default -> position_image_x;
                    };
                    pied_droite = false;
                } else {
                    position_image_x = switch (direction) {
                        case Constantes.Haut -> 1470;
                        case Constantes.Bas -> 1470;
                        case Constantes.Droite -> 1315;
                        case Constantes.Gauche -> 1320;
                        default -> position_image_x;
                    };
                    pied_droite = true;
                }
                imageView.setViewport(new Rectangle2D(position_image_x, position_image_y, 120, 160));
            }
        }

    }

