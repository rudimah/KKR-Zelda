package universite_paris8.iut.kkr.zelda.Controleur;
import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.kkr.zelda.modele.Acteur;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Reltih;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Simonus;


public class ObservateurEnnemi implements ListChangeListener<Acteur> {
    private final Pane panneauJeu;
    private ImageView imageView;

    public ObservateurEnnemi(Pane panneauDeJeu) {
        super();
        this.panneauJeu = panneauDeJeu;
        imageView = new ImageView();
        panneauJeu.getChildren().add(imageView);
    }

    @Override
    public void onChanged(Change<? extends Acteur> change) {

        while (change.next()) {
            if (change.wasAdded()) {
                for (Acteur a : change.getAddedSubList()) {
                    creerSprite(a);
                }
            } else if (change.wasRemoved()) {

                for (Acteur a : change.getRemoved()) {
                    this.panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getId()));
                }
            }
        }
    }

    public void creerSprite(Acteur a){

        if (a instanceof Reltih){
            imageView.setImage(new Image("file:src/main/resources/image/Ennemie/Runner.png"));
        } else if (a instanceof Simonus) {
            imageView.setImage(new Image("file:src/main/resources/image/Ennemie/Titan.png"));
        }
        imageView.translateXProperty().bind(a.getXProperty());
        imageView.translateYProperty().bind(a.getYProperty());

    }
}
