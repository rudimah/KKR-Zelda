package universite_paris8.iut.kkr.zelda.Controleur;
import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.kkr.zelda.Vue.VueEnnemi;
import universite_paris8.iut.kkr.zelda.modele.Acteur;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.*;
import universite_paris8.iut.kkr.zelda.modele.Link;


public class ObservateurPersonnage implements ListChangeListener<Acteur> {
    private Pane panneauJeu;
    private ImageView imageView;
    public ObservateurPersonnage(Pane panneauDeJeu) {
        this.panneauJeu = panneauDeJeu;

    }
    //creation du sprite de l'acteur
    @Override
    public void onChanged(Change<? extends Acteur> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (Acteur a : change.getAddedSubList()) {
                    creerSprite(a);
                }
            } else if (change.wasRemoved()) {
                for (Acteur a : change.getRemoved()) {
                    VueEnnemi.retirerBarreDeVie(panneauJeu, a.getId());
                    panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getId()));
                }
            }
        }
    }

    //cree le sprite des ennemis selon leur images
    public void creerSprite(Acteur a) {
        imageView = new ImageView();
        if (a instanceof Reltih){
            imageView.setImage(new Image("file:src/main/resources/image/Ennemie/relith.png"));
        } else if (a instanceof Simonus) {
            imageView.setImage(new Image("file:src/main/resources/image/Ennemie/simonus.png"));
        } else if (a instanceof Cataltos) {
            imageView.setImage(new Image("file:src/main/resources/image/Ennemie/cataltos.png"));
        } else if (a instanceof Marcos) {
            imageView.setImage(new Image("file:src/main/resources/image/Ennemie/marcos.png"));
        } else if (a instanceof Bonnoctus) {
            imageView.setImage(new Image("file:src/main/resources/image/Ennemie/bonoctus.png"));
        }
        imageView.setId(a.getId());
        imageView.translateXProperty().bind(a.getXProperty());
        imageView.translateYProperty().bind(a.getYProperty());
        panneauJeu.getChildren().add(imageView);
        if (a instanceof ActeurEnMouvement && !(a instanceof Link)) {
            new VueEnnemi((ActeurEnMouvement) a, panneauJeu);

        }
    }
}
