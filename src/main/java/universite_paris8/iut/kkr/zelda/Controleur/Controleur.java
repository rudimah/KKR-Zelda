package universite_paris8.iut.kkr.zelda.Controleur;
import java.io.IOException;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.kkr.zelda.Vue.TerrainVue;
import universite_paris8.iut.kkr.zelda.Vue.VueLink;
import universite_paris8.iut.kkr.zelda.modele.*;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.BottesAres;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Bouclier;
import universite_paris8.iut.kkr.zelda.modele.Accessoires.Flute;
import universite_paris8.iut.kkr.zelda.modele.Arme.*;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Reltih;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionAcide;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionForce;
import universite_paris8.iut.kkr.zelda.utils.Constantes;


public class Controleur implements Initializable {


    //// Déclarations de variables et éléments d'interface graphique (FXML)
    // tel que initialisation de l'environnment ou autre objets
    private Timeline gameLoop;
    private Link link;
    private Environnement env;
    @FXML
    private TilePane tilepane;
    @FXML
    private Pane panneauDeJeu;
    @FXML
    private ImageView case1; @FXML private ImageView case2; @FXML private ImageView case3; @FXML private ImageView case4;
    @FXML private StackPane emplacement1; @FXML private StackPane emplacement2; @FXML private StackPane emplacement3; @FXML private StackPane emplacement4;
    private ArrayList<ImageView> imageViews = new ArrayList<>();
    private ArrayList<StackPane> stackPanes = new ArrayList<>();

    private int indexCaseActuelle = 0;
    private int vitesseNormale;
    private TerrainVue terrainVue;
    private VueLink afficherlink;
    private Timeline tempsSprint;
    private DialogueController roueDial;

    @FXML
    private Rectangle barreVie;

    @FXML
    private Label dialogueLabel;

    // Initialisation de l'environnement, des vues et bind/addlistener d'événements
    // Ajout d'éléments et d'acteurs dans l'environnement

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        env = new Environnement(800, 800);
        terrainVue = new TerrainVue(env, tilepane);
        tilepane.setPrefColumns(env.getTableauMap()[0].length);
        tilepane.setPrefRows(env.getTableauMap().length);
        roueDial = new DialogueController(this);
        link = new Link(env, roueDial);

        // Vitesse initiale
        this.vitesseNormale = link.getVitesse();

        this.env.getItems().addListener(new ObservateurElement(panneauDeJeu));
        this.env.getActeurs().addListener(new ObservateurPersonnage(panneauDeJeu));
        env.ajouterItem(new BottesAres(200, 100, env));
        env.ajouterItem(new Bouclier(200, 150, env));
        env.ajouterItem(new Flute(150, 200, env));
//        env.ajouterItem(new Epee(300, 300, env));
//        env.ajouterItem(new Sabre(300, 450, env));
//        env.ajouterItem(new Bouclier(500, 450, env));
//        env.ajouterItem(new Arc(40, 30, env));
//        env.ajouterItem(new Boomerang(500, 450, env));
//        env.ajouterItem(new PotionForce(480, 203, env));
//        env.ajouterItem(new BottesAres(500,400, env));
//        env.ajouterItem(new PotionAcide(200, 100, env));
        env.ajouterActeur(link);
        env.ajouterActeur(new Reltih(env));



        afficherlink = new VueLink(env, link, panneauDeJeu);
        terrainVue.afficherMap();

        link.getInventaire().getInventaire().addListener(new ObservateurInventaire(imageViews));
        imageViews.add(case1); imageViews.add(case2); imageViews.add(case3); imageViews.add(case4);
        stackPanes.add(emplacement1); stackPanes.add(emplacement2); stackPanes.add(emplacement3); stackPanes.add(emplacement4);

        panneauDeJeu.setFocusTraversable(true);
        panneauDeJeu.setOnKeyPressed(this::gererTouch);
        panneauDeJeu.setOnKeyReleased(this::handleKeyRelease);

        link.getXProperty().addListener(afficherlink);
        link.getXProperty().addListener((obs, oldVal, newVal) -> {finDeJeu();
        });
        link.getYProperty().addListener(afficherlink);
        link.getYProperty().addListener((obs, oldVal, newVal) -> {finDeJeu();});
        barreVie.widthProperty().bind(link.pointDeVieProperty().multiply(100.0 / link.getPv()));
        link.pointDeVieProperty().addListener((obs, old, nouv) -> couleurBarreDeVie(nouv));

        tilepane.setMaxWidth(panneauDeJeu.getMaxWidth());
        tilepane.setMaxHeight(panneauDeJeu.getMaxHeight());

        link.pointDeVieProperty().addListener((obs, oldVal, newVal) -> {finDeJeu();});
        stackPanes.get(indexCaseActuelle).getStyleClass().add("case-inventaire-actuelle");
        initAnimation();
        initSpawnEnnemis();

    }
    //methode sur la couleur de la barre de vie de link
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
    //methode de fin de jeu afin de relancer le jeu sur le menu du départ
    private void finDeJeu() {

        if (link.estMort() || link.tileId == Constantes.COFFRE) {
            gameLoop.stop();
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText(null);
                if (link.estMort()) {
                    alert.setContentText("Link est mort. \nFin de Partie appuyer sur OK pour revenir sur le menu principal");
                } else {

                    alert.setContentText("Bien joué, Vous avez la clé. \nFin de Partie appuyer sur OK pour revenir sur le menu principal");

                }

                alert.setOnHidden(evt -> {
                    try {
                        Stage primaryStage = (Stage) panneauDeJeu.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("/universite_paris8/iut/kkr/zelda/GameMenu.fxml"));
                        Scene scene = new Scene(root, 800, 800);
                        String css = getClass().getResource("/universite_paris8/iut/kkr/zelda/dark.css").toExternalForm();
                        scene.getStylesheets().add(css);
                        primaryStage.setScene(scene);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                alert.show();
            });
        }
    }



    // Méthodes pour gérer les entrées utilisateur, comme les touches du clavier
    private void gererTouch(KeyEvent event) {
        KeyCode touchePresse = event.getCode();
        if (touchePresse == KeyCode.SHIFT) {
            if (link.getVitesse() == vitesseNormale) {  // Ne démarre le sprint que si Link n'est pas déjà en sprint
                link.setVitesse(vitesseNormale * 2);
                tempsSprint.playFromStart();
            }
        }
        deplacementLink(touchePresse);
        mecaniqueTouche(touchePresse);
        event.consume();
    }
    private void handleKeyRelease(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            stopSprint();
            tempsSprint.stop();
        }
    }
    //méthode qui stop le sprint de Link, il a donc un sprint limité.
    public void stopSprint() {
        link.setVitesse(vitesseNormale);
    }
    //méthode des entrées utilisateurs et leur fonctionnement sur chaque touche pressé
    public void mecaniqueTouche(KeyCode touchePresse) {
        switch (touchePresse) {
            case A:
                if (link.getInventaire().getInventaire().size() > indexCaseActuelle) {
                    link.utiliser(link.getInventaire().getInventaire().get(indexCaseActuelle));
                    link.getInventaire().getInventaire().remove(indexCaseActuelle);
                } else {
                    System.out.println("Case vide");
                }
                break;

            case F:
                ActeurEnMouvement ennemiLePlusProche = env.trouverEnnemiLePlusProche(link.getX(), link.getY());
                if (link.estADistanceAttaque(ennemiLePlusProche)) {
                    link.attaquer(ennemiLePlusProche);
                } else {
                    System.out.println("Aucun ennemi à attaquer à proximité.");
                }
                break;

            case L:
                updateSelectedCase();
                break;
            case T:
                link.demanderDialogue();
                break;

        }
    }

    private void updateSelectedCase() {
        // Enleve les contours actuelle
        stackPanes.get(indexCaseActuelle).getStyleClass().remove("case-inventaire-actuelle");
        //Change l'index
        indexCaseActuelle = (indexCaseActuelle + 1) % imageViews.size();
        // Ajoute les contours à la nouvelle case
        stackPanes.get(indexCaseActuelle).getStyleClass().add("case-inventaire-actuelle");

    }
    //  Cette méthode modifie la direction (gauche, droite, haut et bas) de Link selon la touche du clavier utilisée.
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
        }

    }

    //Cette méthode crée un cadre d'animation qui sera exécuté toutes les 0.15 secondes,
// faisant agir l'environnement, incrémentant le tour de jeu, et déplaçant Link.
    private void initAnimation() {

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
    //Les ennemis sont générés toutes les 15 secondes pour augmenter la difficulté du jeu avec un timer
    public void initSpawnEnnemis() {
        Timeline tempsSpawn = new Timeline(new KeyFrame(Duration.seconds(15), e -> env.SpawnEnnemis()));
        tempsSpawn.setCycleCount(Timeline.INDEFINITE);
        tempsSpawn.play();
    }
//affichage du dialogue roue de dialogue
    public void afficherDialogue(String message) {
        dialogueLabel.setText("Link : " + message);
        dialogueLabel.setVisible(true);
        new Timeline(new KeyFrame(Duration.seconds(5), e -> dialogueLabel.setVisible(false))).play();
    }

}
