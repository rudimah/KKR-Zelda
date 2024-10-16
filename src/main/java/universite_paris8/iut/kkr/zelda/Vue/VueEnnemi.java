package universite_paris8.iut.kkr.zelda.Vue;

import javafx.beans.binding.Bindings;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;

public class VueEnnemi {
    private Rectangle fondBarreVie;
    private Rectangle barreVie;

    public VueEnnemi(ActeurEnMouvement acteur, Pane pane) {
        creerBarreDeVie(acteur, pane);
        fondBarreVie.setId("fondBarreVie" + acteur.getId());
        barreVie.setId("barreVie" + acteur.getId());
    }

    private void creerBarreDeVie(ActeurEnMouvement acteur, Pane pane) {
        fondBarreVie = new Rectangle();
        fondBarreVie.setFill(Color.DARKGRAY);
        fondBarreVie.setWidth(acteur.getLargeur() + 20);
        fondBarreVie.setHeight(8);
        fondBarreVie.setArcWidth(5);
        fondBarreVie.setArcHeight(5);
        pane.getChildren().add(fondBarreVie);

        barreVie = new Rectangle();
        barreVie.setFill(Color.LIMEGREEN);
        barreVie.setHeight(8);
        barreVie.setArcWidth(5);
        barreVie.setArcHeight(5);
        pane.getChildren().add(barreVie);

        // Bindings
        barreVie.widthProperty().bind(acteur.pointDeVieProperty().divide(2));
        fondBarreVie.translateXProperty().bind(acteur.getXProperty().subtract(acteur.getLargeur()/2));
        fondBarreVie.translateYProperty().bind(acteur.getYProperty().subtract(acteur.getHauteur() + 10));
        barreVie.translateXProperty().bind(fondBarreVie.translateXProperty());
        barreVie.translateYProperty().bind(fondBarreVie.translateYProperty());

        // Mettre à jour la couleur de la barre de vie
        barreVie.fillProperty().bind(Bindings.when(acteur.pointDeVieProperty().greaterThan(acteur.getPv() * 0.7)).then(Color.LIMEGREEN).otherwise(Bindings.when(acteur.pointDeVieProperty().greaterThan(acteur.getPv() * 0.4)).then(Color.YELLOW).otherwise(Color.RED))
        );
    }

    public static void retirerBarreDeVie(Pane pane, String acteurId) {
        Rectangle fondBarreVie = (Rectangle) pane.lookup("#fondBarreVie" + acteurId);
        Rectangle barreVie = (Rectangle) pane.lookup("#barreVie" + acteurId);
        if (fondBarreVie != null) {
            pane.getChildren().remove(fondBarreVie);
        }
        if (barreVie != null) {
            pane.getChildren().remove(barreVie);
        }
    }
}