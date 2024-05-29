package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.modele.ObjetEnvironnement;

public class Observateur implements ListChangeListener<ObjetEnvironnement> {
    private Pane panneauJeu;

    public Observateur(Pane panneauJeu) {
        super();
        this.panneauJeu = panneauJeu;
    }
    @Override
    public void onChanged(Change<? extends ObjetEnvironnement> change) {
        while(change.next()){
            System.out.println("changement");
            if (change.wasAdded()){
                for (ObjetEnvironnement a: change.getAddedSubList()) {
                    creerSprite(a);
                }
            } else if (change.wasRemoved()) {
                for (ObjetEnvironnement a : change.getRemoved()){
                    System.out.println("mort");
                    this.panneauJeu.getChildren().remove(panneauJeu.lookup("#"+a.getId()));
                }
            }
        }
    }
    private void creerSprite(ObjetEnvironnement a) {
        System.out.println("ajouter sprite");
        Circle r;
        r= new Circle(5);
        r.setFill(Color.RED);

        r.setId(a.getId());
        r.translateXProperty().bind(a.xProperty());
        r.translateYProperty().bind(a.yProperty());
        panneauJeu.getChildren().add(r);
    }
}