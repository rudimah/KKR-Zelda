package universite_paris8.iut.kkr.zelda;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Observateur;

public class Controller implements Initializable {
    private Timeline gameLoop;
    private Environnement env;
    private ActeurEnMouvement acteur;

    @FXML
    private TilePane tilepane;
    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.env = new Environnement(800, 800);
        this.env.getActeurs().addListener(new Observateur(pane));
        affichermap();
        this.acteur = new ActeurEnMouvement(50, 50, 5, env, 40,3);
        this.env.ajouter(acteur);
        initAnimation();
        pane.setFocusTraversable(true);
        pane.setOnKeyPressed(this::handleKeyEvent);
        pane.setOnKeyReleased(this::handleKeyRelease);
    }

    private void initAnimation() {
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.15), event -> {
            //System.out.println("Game loop tick ");
        });
        gameLoop = new Timeline(keyFrame);
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
    }

    private void handleKeyEvent(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            return; // Si seulement la touche SHIFT est pressée, nous ne faisons rien.
        }
        boolean sprint = event.isShiftDown();
        System.out.println("Touche pressé " + event.getCode());
        KeyTouches.setDirection(acteur, event.getCode(), sprint );
        acteur.seDeplacer();
        event.consume();
    }
    private void handleKeyRelease(KeyEvent event) {
        // Reset the direction when shift is released
        if (event.getCode() == KeyCode.SHIFT) {
            KeyTouches.setDirection(acteur, event.getCode(), false);
            System.out.println("MAJ relâchée, vitesse normalisée.");
        }
    }
    public void affichermap(){
        int[][] map = this.env.getTableauMap();
        for (int x = 0; x < map.length; x++){
            for (int y = 0; y<map[x].length; y++){
                ImageView imageView = new ImageView();

                switch (map[x][y]){

                    case 9:
                        Image image = new Image("file:src/main/java/universite_paris8/iut/kkr/zelda/image/grass.png");
                        imageView.setImage(image);
                        break;
                    case 1:
                        Image image1 = new Image("file://home/etudiants/info/hrahman/Téléchargements/grass.png");
                        imageView.setImage(image1);
                }
                this.tilepane.getChildren().add(imageView);

            }
        }
    }

}