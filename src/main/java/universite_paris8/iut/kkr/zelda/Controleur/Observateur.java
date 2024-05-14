package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.modele.Acteur;

public class Observateur implements ListChangeListener<Acteur> {
    private Pane panneauJeu;

    public Observateur(Pane panneauJeu) {
        super();
        this.panneauJeu = panneauJeu;
    }
    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while(change.next()){
            System.out.println("changement");
            if (change.wasAdded()){
                for (Acteur a: change.getAddedSubList()) {
                    creerSprite(a);
                }
            } else if (change.wasRemoved()) {
                for (Acteur a : change.getRemoved()){
                    System.out.println("mort");
                    this.panneauJeu.getChildren().remove(panneauJeu.lookup("#"+a.getId()));
                }
            }
        }
    }
    private void creerSprite(Acteur a) {
        System.out.println("ajouter sprite");
        Circle r;
        r= new Circle(5);
        r.setFill(Color.RED);

        r.setId(a.getId());
        r.translateXProperty().bind(a.getXProperty());
        r.translateYProperty().bind(a.getYProperty());
        panneauJeu.getChildren().add(r);
    }
}