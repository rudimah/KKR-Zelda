package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import universite_paris8.iut.kkr.zelda.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleurMenu implements Initializable {
    @FXML
    ImageView imageFond;
    @FXML
    VBox contenuRegles;
    @FXML
    VBox contenuBoutons;
    @FXML
    VBox contenuCredits;
    @FXML
    VBox contenuQuitter;



    @FXML
    public void gererBoutonJouer(ActionEvent event) {
        System.out.println("Lancement du jeu...");
        try {
            Main main = new Main();
            main.start(new Stage());
            Scene scene = ((Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow()).getScene();
            Stage stage = (Stage) scene.getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void gererBoutonRegles(ActionEvent event){
        System.out.println("Affichage des règles...");
        cacherLeContenu();
        contenuBoutons.setVisible(false);
        contenuRegles.setVisible(true);
    }

    @FXML
    public void gererBoutonCredits(ActionEvent event){
        System.out.println("Affichage des crédits en cours...");
        cacherLeContenu();
        contenuBoutons.setVisible(false);
        contenuCredits.setVisible(true);
    }

    @FXML
    public void gererBoutonQuitter(ActionEvent event){
        System.out.println("Ouverture de la fenêtre de quittage...");
        cacherLeContenu();
        contenuBoutons.setVisible(false);
        contenuQuitter.setVisible(true);
    }

    @FXML
    private void retourAuMenu(ActionEvent event) {
        cacherLeContenu();
    }

    @FXML
    private void confirmerQuitter() {
        System.exit(0);
    }

    @FXML
    private void annulerQuitter() {
        contenuQuitter.setVisible(false);
        contenuBoutons.setVisible(true);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    private void cacherLeContenu() {
        contenuBoutons.setVisible(true);
        contenuRegles.setVisible(false);
        contenuCredits.setVisible(false);
        contenuQuitter.setVisible(false);
    }
}
