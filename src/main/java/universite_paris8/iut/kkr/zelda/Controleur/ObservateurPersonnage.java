package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.Vue.VueEnnemi;
import universite_paris8.iut.kkr.zelda.modele.Acteur;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Link;

public class ObservateurPersonnage implements ListChangeListener<Acteur> {
    private Pane panneauJeu;

    public ObservateurPersonnage(Pane panneauDeJeu) {
        this.panneauJeu = panneauDeJeu;
    }

    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (Acteur a : change.getAddedSubList()) {
                    if (a instanceof ActeurEnMouvement) {
                        creerSprite(a);
                    }
                }
            } else if (change.wasRemoved()) {
                for (Acteur a : change.getRemoved()) {
                    if (a instanceof ActeurEnMouvement) {
                        VueEnnemi.retirerBarreDeVie(panneauJeu, a.getId());
                    }
                    panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getId()));
                }
            }
        }
    }
    public void creerSprite(Acteur a) {
        // Vérifie si un sprite existe déjà


        if (panneauJeu.lookup("#" + a.getId()) == null &&  !(a instanceof Link)) {
            Circle r = new Circle(5);
            r.setFill(Color.RED);
            r.setId(a.getId());
            r.translateXProperty().bind(a.getXProperty());
            r.translateYProperty().bind(a.getYProperty());
            panneauJeu.getChildren().add(r);
        }

        if (a instanceof ActeurEnMouvement && !(a instanceof Link)) {
            new VueEnnemi((ActeurEnMouvement) a, panneauJeu);
        }
    }
}
