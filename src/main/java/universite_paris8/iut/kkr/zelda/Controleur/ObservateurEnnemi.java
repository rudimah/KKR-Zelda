package universite_paris8.iut.kkr.zelda.Controleur;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;

public class ObservateurEnnemi implements ListChangeListener<Ennemis> {
    private Pane panneauJeu;

    public ObservateurEnnemi(Pane panneauDeJeu) {
        super();
        this.panneauJeu = panneauDeJeu;
    }

    @Override
    public void onChanged(Change<? extends Ennemis> change) {
        while (change.next()) {
            System.out.println("Ennemi ajouté à l'environnement");
            if (change.wasAdded()) {
                for (Ennemis a : change.getAddedSubList()) {
                    creerSprite(a);
                }
            } else if (change.wasRemoved()) {
                for (Ennemis a : change.getRemoved()) {
                    this.panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getId()));
                }
            }
        }
    }

    public void creerSprite(Ennemis a){
        Circle r;
        r= new Circle(3);
        r.setFill(Color.RED);
        r.setId(a.getId());
        r.translateXProperty().bind(a.getXProperty());
        r.translateYProperty().bind(a.getYProperty());
        panneauJeu.getChildren().add(r);
    }
}
