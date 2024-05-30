package universite_paris8.iut.kkr.zelda.Controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.kkr.zelda.Vue.TerrainVue;
import universite_paris8.iut.kkr.zelda.Vue.VueLink;
import universite_paris8.iut.kkr.zelda.modele.*;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Reltih;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionAcide;
import universite_paris8.iut.kkr.zelda.utils.Constantes;

public class Controleur implements Initializable {
    private Timeline gameLoop;
    private Environnement env;
    private ActeurEnMouvement acteur;
    @FXML
    private TilePane tilepane;
    @FXML
    private Pane panneauDeJeu;
    private int vitesseNormale;
    private Link link;
    private TerrainVue terrainVue;
    private VueLink afficherlink;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.env = new Environnement(800, 800);
        terrainVue = new TerrainVue(env, tilepane);
        link = new Link(env);

        // Save the initial normal speed
        this.vitesseNormale = link.getVitesse();

        this.env.getItems().addListener(new Observateur(panneauDeJeu));
        env.ajouterItem(new PotionAcide(200, 100));
        env.ajouterActeur(link);
        // env.ajouterActeur(new Reltih(env, panneauDeJeu, tilepane));
        afficherlink = new VueLink(env, link, panneauDeJeu);

        terrainVue.afficherMap();
        panneauDeJeu.setFocusTraversable(true);
        panneauDeJeu.setOnKeyPressed(this::gererTouch);
        panneauDeJeu.setOnKeyReleased(this::handleKeyRelease);

        initAnimation();
    }

    private void gererTouch(KeyEvent event) {
        KeyCode touchePresse = event.getCode();
        if (touchePresse == KeyCode.SHIFT) {
            link.setVitesse(vitesseNormale*2);
        }
        System.out.println("Touche pressée " + event.getCode());
        deplacementLink(touchePresse);
        event.consume();
    }

    private void handleKeyRelease(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            link.setVitesse(vitesseNormale);
            System.out.println("SHIFT relâchée, vitesse normalisée.");
        }
    }

    public void deplacementLink(KeyCode touchePresse) {
        int direction = 0;
        switch (touchePresse) {
            case Z:
                direction = Constantes.Haut;
                break;
            case S:
                direction = Constantes.Bas;
                break;
            case D:
                direction = Constantes.Droite;
                break;
            case Q:
                direction = Constantes.Gauche;
                break;
            default:
                System.out.println("Autre Touche");
        }
        link.seDeplace(direction);
        afficherlink.mettreAJourImageView(direction, link.getTileId());
    }

    private void initAnimation() {
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.15), event -> {
            env.miseAJour();
        });
        gameLoop = new Timeline(keyFrame);
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
    }
}
