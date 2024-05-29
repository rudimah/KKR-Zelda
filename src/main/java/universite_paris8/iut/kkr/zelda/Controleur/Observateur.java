package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.modele.Acteur;
import universite_paris8.iut.kkr.zelda.modele.Item;

public class Observateur implements ListChangeListener<Item> {
    private Pane panneauJeu;

    public Observateur(Pane panneauJeu) {
        super();
        this.panneauJeu = panneauJeu;
    }
    @Override
    public void onChanged(Change<? extends Item> change) {
        while(change.next()){
            System.out.println("changement");
            if (change.wasAdded()){
                for (Item a: change.getAddedSubList()) {
                    creerSprite(a);
                }
            } else if (change.wasRemoved()) {
                for (Item a : change.getRemoved()){
                    System.out.println("mort");
                    this.panneauJeu.getChildren().remove(panneauJeu.lookup("#"+a.getId()));
                }
            }
        }
    }
    private void creerSprite(Item a) {
        System.out.println("ajouter sprite");
        Circle r;
        r= new Circle(5);
        r.setFill(Color.RED);

        r.setId(a.getId());
        r.translateXProperty().bind(a.XProperty());
        r.translateYProperty().bind(a.YProperty());
        panneauJeu.getChildren().add(r);
    }
}