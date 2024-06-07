package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.collections.ListChangeListener;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.BottesAres;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Bouclier;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Flute;
import universite_paris8.iut.kkr.zelda.modele.Arme.*;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;
import universite_paris8.iut.kkr.zelda.modele.Potion.*;

import java.util.EventListener;

public class Observateur implements ListChangeListener<ObjetEnvironnement> {
    private Pane panneauJeu;

    public Observateur(Pane panneauJeu) {
        super();
        this.panneauJeu = panneauJeu;
    }
    @Override
    public void onChanged(Change<? extends ObjetEnvironnement> change) {
        while(change.next()){
            System.out.println("Item ajouté à l'environnement");
            if (change.wasAdded()){
                for (ObjetEnvironnement a: change.getAddedSubList()) {
                    creerItem(a);
                }
            } else if (change.wasRemoved()) {
                for (ObjetEnvironnement a : change.getRemoved()){
                    this.panneauJeu.getChildren().remove(panneauJeu.lookup("#"+a.getId()));
                }
            }
        }
    }
    private void creerItem(ObjetEnvironnement a) {

        ImageView element = new ImageView();
        if (a instanceof PotionAcide){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/pt3.png");
            element.setImage(image);
            element.setViewport(new Rectangle2D(16, 8, 294, 359));
            element.setFitWidth(20);
            element.setFitHeight(25);
        }
        else if (a instanceof PotionBleue){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/pt2.png");
            element.setImage(image);
            element.setViewport(new Rectangle2D(16, 8, 294, 359));
            element.setFitWidth(20);
            element.setFitHeight(25);
        }
        else if (a instanceof PotionFeu){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/pt1.png");
            element.setImage(image);
            element.setViewport(new Rectangle2D(16, 8, 294, 359));
            element.setFitWidth(20);
            element.setFitHeight(25);
        }
        else if (a instanceof PotionForce){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/pt4.png");
            element.setImage(image);
            element.setViewport(new Rectangle2D(16, 8, 294, 359));
            element.setFitWidth(20);
            element.setFitHeight(25);
        }
        else if (a instanceof Sabre){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/epees.png");
            element.setImage(image);
            element.setViewport(new Rectangle2D(161, 160, 31, 32));
            element.setFitWidth(20);
            element.setFitHeight(25);
        }
        else if (a instanceof Epee){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/epees.png");
            element.setImage(image);
            element.setViewport(new Rectangle2D(2, 2, 27, 27));
            element.setFitWidth(20);
            element.setFitHeight(25);
        }
        else if (a instanceof Arc){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/Arc&Fleche.png");
            element.setImage(image);
            element.setViewport(new Rectangle2D(258, 77, 957, 3113));
            element.setFitWidth(20);
            element.setFitHeight(25);
        }
        else if (a instanceof Boomerang){

        }
        else if (a instanceof Fleche){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/Arc&Fleche.png");
            element.setImage(image);
            element.setViewport(new Rectangle2D(1634, 578, 308, 2007));
            element.setFitWidth(20);
            element.setFitHeight(25);
        }
        else if (a instanceof BottesAres){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/bottes.gif");
            element.setImage(image);
            element.setViewport(new Rectangle2D(0, 0, 32, 32));
            element.setFitWidth(20);
            element.setFitHeight(25);
        }
        else if (a instanceof Bouclier){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/bouclier.png");
            element.setImage(image);
            element.setViewport(new Rectangle2D(13, 13, 39, 39));
            element.setFitWidth(20);
            element.setFitHeight(25);
        }
        else if (a instanceof Flute){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/flute.png");
            element.setImage(image);
            element.setViewport(new Rectangle2D(0, 47, 291, 198));
            element.setFitWidth(20);
            element.setFitHeight(25);
        }
        element.setId(a.getId());
        element.translateXProperty().bind(a.xProperty());
        element.translateYProperty().bind(a.yProperty());
        panneauJeu.getChildren().add(element);
        System.out.println("ajouter sprite");
    }

}