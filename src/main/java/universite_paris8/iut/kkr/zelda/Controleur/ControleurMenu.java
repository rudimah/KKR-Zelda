package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import universite_paris8.iut.kkr.zelda.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleurMenu implements Initializable {
    @FXML
    ImageView imageFond;

    @FXML
    public void gererBoutonJouer(ActionEvent event) {
        try {
            Main main = new Main();
            main.start(new Stage());
            Scene scene = ((Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow()).getScene();
            // Fermez la fenêtre actuelle
            Stage stage = (Stage) scene.getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer l'exception selon vos besoins
        }
    }
    @FXML
    public void gererBoutonCredits(ActionEvent event){
        System.out.println("Affichage des crédits en cours...");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//////        // Récupérer les dimensions de l'image de fond
//        double imageWidth = imageFond.getImage().getWidth();
//        double imageHeight = imageFond.getImage().getHeight();
//////
//////        // Obtenir la scène associée à l'image de fond
//        Stage stage = (Stage) imageFond.getScene().getWindow();
//////
//////        // Définir la taille de la fenêtre en fonction des dimensions de l'image
//        stage.setWidth(imageWidth);
//        stage.setHeight(imageHeight);
  }
}
