package universite_paris8.iut.kkr.zelda.Controleur;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
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
import universite_paris8.iut.kkr.zelda.modele.Accessoires.BottesAres;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Bouclier;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Flute;
import universite_paris8.iut.kkr.zelda.modele.Arme.*;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Reltih;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Simonus;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionAcide;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionBleue;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionFeu;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionForce;
import universite_paris8.iut.kkr.zelda.utils.Constantes;

public class Controleur implements Initializable {
    private Timeline gameLoop;
    private Environnement env;
    @FXML
    private TilePane tilepane;
    @FXML
    private Pane panneauDeJeu;
    @FXML
    private Pane panneauDeJeu2;
    private int vitesseNormale;
    private Link link;
    private TerrainVue terrainVue;
    private VueLink afficherlink;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.env = new Environnement(800, 800);
        terrainVue = new TerrainVue(env, tilepane);
        tilepane.setPrefColumns(env.getTableauMap()[0].length);
        tilepane.setPrefRows(env.getTableauMap().length);
        link = new Link(env);

        // Save the initial normal speed
        this.vitesseNormale = link.getVitesse();

        this.env.getItems().addListener(new Observateur(panneauDeJeu));
        this.env.getActeurs().addListener(new ObservateurEnnemi(panneauDeJeu));
        env.ajouterItem(new Epee(300,300));
        env.ajouterItem(new Sabre(300,450));
        env.ajouterItem(new Flute(500,450,env));
        env.ajouterActeur(link);
//        env.ajouterActeur(new Reltih(env));
//        env.ajouterActeur(new Simonus(env));
        env.ajouterItem(new PotionAcide(200, 100));
        env.ajouterActeur(link);
        // env.ajouterActeur(new Reltih(env, panneauDeJeu, tilepane));
        afficherlink = new VueLink(env, link, panneauDeJeu);

        terrainVue.afficherMap();

        panneauDeJeu.setFocusTraversable(true);
        panneauDeJeu.setOnKeyPressed(this::gererTouch);
        panneauDeJeu.setOnKeyReleased(this::handleKeyRelease);

        link.getXProperty().addListener(afficherlink);
        link.getYProperty().addListener(afficherlink);

        tilepane.setMaxWidth(panneauDeJeu.getMaxWidth());
        tilepane.setMaxHeight(panneauDeJeu.getMaxHeight());



        initAnimation();

    }


    private void gererTouch(KeyEvent event) {
        KeyCode touchePresse = event.getCode();
        if (touchePresse == KeyCode.SHIFT) {
            link.setVitesse(vitesseNormale*2);
        }
        System.out.println("Touche pressée " + event.getCode());
        deplacementLink(touchePresse);
        gererTouches(touchePresse);
        event.consume();
    }

    public void gererTouches(KeyCode touchePresse){
        switch (touchePresse){
            case F:
                ActeurEnMouvement ennemiLePlusProche = env.trouverEnnemiLePlusProche(link.getX(), link.getY());
                if (link.estADistanceAttaque(ennemiLePlusProche)){
                    link.attaquer(ennemiLePlusProche);
                } else {
                    System.out.println("Aucun ennemi à attaquer à proximité.");
                }
                break;
            case A:
                link.equiperArme();
                break;
            case X:
                link.equiperAccessoire();
                break;
            case C:
                link.utilserAccessoire();
                break;
        }
    }

    private void handleKeyRelease(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            link.setVitesse(vitesseNormale);
            System.out.println("SHIFT relâchée, vitesse normalisée.");
        }
    }

    public void deplacementLink(KeyCode touchePresse) {

        switch (touchePresse) {
            case Z:
                link.setDirection(Constantes.Haut);
                break;
            case S:
                link.setDirection(Constantes.Bas);
                break;
            case D:
                link.setDirection(Constantes.Droite);
                break;
            case Q:
                link.setDirection(Constantes.Gauche);
                break;
            default:
                System.out.println("Autre Touche");
        }

    }

    private void initAnimation() {
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.15), event -> {
            env.agir();
            link.seDeplacer();
        });
        gameLoop = new Timeline(keyFrame);
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
    }


}
