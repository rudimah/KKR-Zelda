package universite_paris8.iut.kkr.zelda.Controleur;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.modele.Acteur;


public class ObservateurEnnemi implements ListChangeListener<Acteur> {
    private Pane panneauJeu;

    public ObservateurEnnemi(Pane panneauDeJeu) {
        super();
        this.panneauJeu = panneauDeJeu;
    }

    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                System.out.println("Ennemi ajouté à l'environnement");
                for (Acteur a : change.getAddedSubList()) {
                    creerSprite(a);
                }
            } else if (change.wasRemoved()) {
                System.out.println("Ennemi retiré de l'environnement");
                for (Acteur a : change.getRemoved()) {
                    this.panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getId()));
                }
            }
        }
    }

    public void creerSprite(Acteur a){
        Circle r;
        r= new Circle(3);
        r.setFill(Color.RED);
        r.setId(a.getId());
        r.translateXProperty().bind(a.getXProperty());
        r.translateYProperty().bind(a.getYProperty());
        panneauJeu.getChildren().add(r);
    }
}
