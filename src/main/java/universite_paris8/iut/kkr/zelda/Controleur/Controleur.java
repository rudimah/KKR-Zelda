package universite_paris8.iut.kkr.zelda.Controleur;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.kkr.zelda.Vue.TerrainVue;
import universite_paris8.iut.kkr.zelda.Vue.VueLink;
import universite_paris8.iut.kkr.zelda.modele.*;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Flute;
import universite_paris8.iut.kkr.zelda.modele.Arme.*;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Reltih;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionAcide;
import universite_paris8.iut.kkr.zelda.utils.Constantes;

public class Controleur implements Initializable {
    private Timeline gameLoop;
    private Environnement env;
    @FXML
    private TilePane tilepane;
    @FXML
    private Pane panneauDeJeu;
    private int vitesseNormale;
    private Link link;
    private TerrainVue terrainVue;
    private VueLink afficherlink;
    private Timeline tempsSprint;
    private DialogueController roueDial;

    @FXML
    private Rectangle barreVie;

    @FXML
    private Label dialogueLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.env = new Environnement(800, 800);
        terrainVue = new TerrainVue(env, tilepane);
        tilepane.setPrefColumns(env.getTableauMap()[0].length);
        tilepane.setPrefRows(env.getTableauMap().length);
        roueDial = new DialogueController(this);
        link = new Link(env, roueDial);

        this.vitesseNormale = link.getVitesse();

        this.env.getItems().addListener(new ObservateurElement(panneauDeJeu));
        this.env.getActeurs().addListener(new ObservateurPersonnage(panneauDeJeu));
        env.ajouterItem(new Epee(300, 300));
        env.ajouterItem(new Sabre(300, 450));
        env.ajouterItem(new Flute(500, 450, env));
        env.ajouterActeur(link);
        env.ajouterActeur(new Reltih(env));
        env.ajouterItem(new PotionAcide(200, 100));

        afficherlink = new VueLink(env, link, panneauDeJeu);

        terrainVue.afficherMap();

        panneauDeJeu.setFocusTraversable(true);
        panneauDeJeu.setOnKeyPressed(this::gererTouch);
        panneauDeJeu.setOnKeyReleased(this::handleKeyRelease);

        link.getXProperty().addListener(afficherlink);
        link.getYProperty().addListener(afficherlink);
        barreVie.widthProperty().bind(link.pointDeVieProperty().multiply(100.0 / link.getPv()));
        link.pointDeVieProperty().addListener((obs, old, nouv) -> couleurBarreDeVie(nouv));

        tilepane.setMaxWidth(panneauDeJeu.getMaxWidth());
        tilepane.setMaxHeight(panneauDeJeu.getMaxHeight());

        initAnimation();
        initSpawnEnnemis();



    }

    private void couleurBarreDeVie(Number pointvie) {
        double pourcentagevie = pointvie.doubleValue() / 100.0; // Convertir en pourcentage

        if (pourcentagevie > 0.7) {
            barreVie.setFill(Color.LIMEGREEN);
        } else if (pourcentagevie > 0.3) {
            barreVie.setFill(Color.YELLOW);
        } else {
            barreVie.setFill(Color.RED);
        }
    }


    public void stopSprint() {
        link.setVitesse(vitesseNormale);
    }

    private void gererTouch(KeyEvent event) {
        KeyCode touchePresse = event.getCode();
        if (touchePresse == KeyCode.SHIFT) {
            if (link.getVitesse() == vitesseNormale) {  // Ne démarre le sprint que si Link n'est pas déjà en sprint
                link.setVitesse(vitesseNormale * 2);
                tempsSprint.playFromStart();
            }
        }
        System.out.println("Touche pressée " + event.getCode());
        deplacementLink(touchePresse);
        gererTouches(touchePresse);
        event.consume();
    }

    public void gererTouches(KeyCode touchePresse) {
        switch (touchePresse) {
            case F:
                ActeurEnMouvement ennemiLePlusProche = env.trouverEnnemiLePlusProche(link.getX(), link.getY());
                if (link.estADistanceAttaque(ennemiLePlusProche)) {
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
                link.utiliserAccessoire();
                break;
            case T:
               link.demanderDialogue();
                break;
            default:
                System.out.println("Autre Touche composé");
        }
    }
    private void handleKeyRelease(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            stopSprint();
            tempsSprint.stop();
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

    private void initAnimation() {{
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.15), event -> {
            env.agir();
            link.seDeplacer();
        });
        gameLoop = new Timeline(keyFrame);
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
    }
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.15), event -> {
            env.agir();
            env.incrementerTour();
            link.seDeplacer();
        });
        gameLoop = new Timeline(keyFrame);
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        tempsSprint = new Timeline(new KeyFrame(Duration.seconds(3), e -> stopSprint()));
        tempsSprint.setCycleCount(2);
        gameLoop.play();
    }

        public void initSpawnEnnemis() {
            Timeline tempsSpawn = new Timeline(new KeyFrame(Duration.seconds(15), e -> env.SpawnEnnemis()));
            tempsSpawn.setCycleCount(Timeline.INDEFINITE);
            tempsSpawn.play();
        }


    public void afficherDialogue(String message) {
        dialogueLabel.setText("Link : " + message);
        dialogueLabel.setVisible(true);
        new Timeline(new KeyFrame(Duration.seconds(5), e -> dialogueLabel.setVisible(false))).play();
    }

}
