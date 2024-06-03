package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.collections.ListChangeListener;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.BottesAres;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Bouclier;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Flute;
import universite_paris8.iut.kkr.zelda.modele.Arme.*;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;
import universite_paris8.iut.kkr.zelda.modele.Potion.*;

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
                    creerSprite(a);
                }
            } else if (change.wasRemoved()) {
                for (ObjetEnvironnement a : change.getRemoved()){
                    this.panneauJeu.getChildren().remove(panneauJeu.lookup("#"+a.getId()));
                }
            }
        }
    }
    private void creerSprite(ObjetEnvironnement a) {
        System.out.println("ajouter sprite");
        ImageView r;
        r= new ImageView();
        if (a instanceof PotionAcide){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/pt3.png");
            r.setImage(image);
            r.setViewport(new Rectangle2D(16, 8, 294, 359));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        else if (a instanceof PotionBleue){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/pt2.png");
            r.setImage(image);
            r.setViewport(new Rectangle2D(16, 8, 294, 359));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        else if (a instanceof PotionFeu){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/pt1.png");
            r.setImage(image);
            r.setViewport(new Rectangle2D(16, 8, 294, 359));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        else if (a instanceof PotionForce){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/pt4.png");
            r.setImage(image);
            r.setViewport(new Rectangle2D(16, 8, 294, 359));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        else if (a instanceof Sabre){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/epees.png");
            r.setImage(image);
            r.setViewport(new Rectangle2D(161, 160, 31, 32));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        else if (a instanceof Epee){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/epees.png");
            r.setImage(image);
            r.setViewport(new Rectangle2D(2, 2, 27, 27));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        else if (a instanceof Arc){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/arc.png");
            r.setImage(image);
            r.setViewport(new Rectangle2D(1, 1, 30, 30));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        else if (a instanceof Boomerang){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/boomerang.png");
            r.setImage(image);
            r.setViewport(new Rectangle2D(58, 104, 943, 892));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        else if (a instanceof Fleche){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/fleche.png");
            r.setImage(image);
            r.setViewport(new Rectangle2D(1, 1, 30, 30));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        else if (a instanceof BottesAres){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/bottes.gif");
            r.setImage(image);
            r.setViewport(new Rectangle2D(0, 0, 32, 32));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        else if (a instanceof Bouclier){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/bouclier.png");
            r.setImage(image);
            r.setViewport(new Rectangle2D(13, 13, 39, 39));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        else if (a instanceof Flute){
            Image image  = new Image("file:src/main/resources/image/Potions & Armes/flute.png");
            r.setImage(image);
            r.setViewport(new Rectangle2D(0, 47, 291, 198));
            r.setFitWidth(20);
            r.setFitHeight(25);
        }
        r.setId(a.getId());
        r.translateXProperty().bind(a.xProperty());
        r.translateYProperty().bind(a.yProperty());
        panneauJeu.getChildren().add(r);
    }
}