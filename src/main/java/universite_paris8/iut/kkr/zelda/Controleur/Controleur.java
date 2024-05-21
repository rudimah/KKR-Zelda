package universite_paris8.iut.kkr.zelda.Controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.kkr.zelda.Vue.TerrainVue;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Link;

public class Controleur implements Initializable {
    private Timeline gameLoop;
    private Environnement env;

    @FXML
    private TilePane tilepane;
    @FXML
    private Pane panneauDeJeu;

    private TerrainVue terrainVue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.env = new Environnement(1300, 1300);

        terrainVue = new TerrainVue(env, tilepane);
        terrainVue.afficherMap();

        // Initialisation de Link
        new Link(env, panneauDeJeu, tilepane);
        //initAnimation();
    }

    private void initAnimation() {
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.15), event -> {
            // Système de boucle de jeu (Game loop)
        });
        gameLoop = new Timeline(keyFrame);
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
    }
}
