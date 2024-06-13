package universite_paris8.iut.kkr.zelda.Vue;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class VueFinPartie {

    public void finDePartie() {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/home/etudiants/info/zkhan/IdeaProjects/SaeTowerDefense/SaeInvasion/test/KKR-Zelda/src/main/resources/universite_paris8/iut/kkr/zelda/FinDePartie.fxml"));
                VBox root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Fin de Partie");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    }

