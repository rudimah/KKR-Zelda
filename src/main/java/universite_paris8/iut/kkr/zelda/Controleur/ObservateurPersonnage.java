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
        switch (a.getNom()) {
            case "Reltih":
                imageView.setImage(new Image("file:src/main/resources/image/Ennemie/Runner.png"));
                break;
            case "Simonus":
                imageView.setImage(new Image("file:src/main/resources/image/Ennemie/Titan.png"));
                break;
            case "Cataltos":
                imageView.setImage(new Image("file:src/main/resources/image/Ennemie/enemie3.png"));
                break;
            case "Marcos":
                imageView.setImage(new Image("file:src/main/resources/image/Ennemie/enemie4.png"));
                break;
            case "Bonnoctus":
                imageView.setImage(new Image("file:src/main/resources/image/Ennemie/enemie5.png"));
                break;
        }

        imageView.setId(a.getId());
        imageView.translateXProperty().bind(a.getXProperty());
        imageView.translateYProperty().bind(a.getYProperty());
        panneauJeu.getChildren().add(imageView);

        // Création de la vue pour les ennemis
        if (a instanceof ActeurEnMouvement && !(a instanceof Link)) {
            new VueEnnemi((ActeurEnMouvement) a, panneauJeu);
        }
    }
}
