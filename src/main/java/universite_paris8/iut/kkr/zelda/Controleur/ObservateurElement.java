package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import universite_paris8.iut.kkr.zelda.modele.Accessoires.BottesAres;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Bouclier;
import universite_paris8.iut.kkr.zelda.modele.Arme.*;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;
import universite_paris8.iut.kkr.zelda.modele.Potion.*;

public class ObservateurElement implements ListChangeListener<ObjetEnvironnement> {
    private final Pane panneauJeu;


    public ObservateurElement(Pane panneauJeu) {
        this.panneauJeu = panneauJeu;
    }
    @Override
    public void onChanged(Change<? extends ObjetEnvironnement> change) {

        while(change.next()){

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
        Image image = null;
        ImageView element = new ImageView();
        element.setFitWidth(30);
        element.setFitHeight(30);

        if (a instanceof PotionAcide){
            image  = new Image("file:src/main/resources/image/Potions & Armes/pt3.png");
        }
        else if (a instanceof PotionBleue){
            image  = new Image("file:src/main/resources/image/Potions & Armes/pt2.png");
        }
        else if (a instanceof PotionFeu){
            image  = new Image("file:src/main/resources/image/Potions & Armes/pt1.png");
        }
        else if (a instanceof PotionForce){
            image  = new Image("file:src/main/resources/image/Potions & Armes/pt4.png");
        }
        else if (a instanceof Sabre){
            image  = new Image("file:src/main/resources/image/Potions & Armes/sabre.png");
        }
        else if (a instanceof Epee){
            image  = new Image("file:src/main/resources/image/Potions & Armes/epees.png");

        }
        else if (a instanceof Arc){
            image  = new Image("file:src/main/resources/image/Potions & Armes/Arc&Fleche.png");
        }
        else if (a instanceof Boomerang){
            image  = new Image("file:src/main/resources/image/Potions & Armes/boomerang.png");
        }
        else if (a instanceof Fleche){
            image  = new Image("file:src/main/resources/image/Potions & Armes/fleche.png");
        }
        else if (a instanceof BottesAres){
            image  = new Image("file:src/main/resources/image/Potions & Armes/bottes.gif");
        }
        else if (a instanceof Bouclier){
            image  = new Image("file:src/main/resources/image/Potions & Armes/bouclier.png");
        }
        else if (a instanceof Bouclier){
            image  = new Image("file:src/main/resources/image/Potions & Armes/flute.png");
        }
        element.setImage(image);
        element.setId(a.getId());
        element.translateXProperty().bind(a.xProperty());
        element.translateYProperty().bind(a.yProperty());
        panneauJeu.getChildren().add(element);
    }
}