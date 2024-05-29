package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.modele.Acteur;

public class Observateur implements ListChangeListener<Acteur> {
    private Pane panneauJeu;

    public Observateur(Pane panneauJeu) {
        this.panneauJeu = panneauJeu;
    }

    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while (change.next()) {
            System.out.println("Changement détecté");
            if (change.wasAdded()) {
                for (Acteur a : change.getAddedSubList()) {
                    creerSprite(a);
                }
            } else if (change.wasRemoved()) {
                for (Acteur a : change.getRemoved()) {
                    System.out.println("Acteur retiré");
                    this.panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getId()));
                }
            }
        }
    }

    private void creerSprite(Acteur a) {
        System.out.println("Création du sprite");
        Circle r = new Circle(5);
        r.setFill(Color.RED);
        r.setId(a.getId());
        r.translateXProperty().bind(a.getXProperty());
        r.translateYProperty().bind(a.getYProperty());
        panneauJeu.getChildren().add(r);
    }
}
