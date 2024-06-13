package universite_paris8.iut.kkr.zelda.Vue;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VueFinPartie {

        public static void afficher() {
            Label messageMort = new Label("Il est mort");
            messageMort.setStyle("-fx-font-size: 24px; -fx-text-fill: red;");

            StackPane root = new StackPane();
            root.getChildren().add(messageMort);

            Scene scene = new Scene(root, 300, 200);
            Stage stage = new Stage();
            stage.setTitle("Game Over");
            stage.setScene(scene);
            stage.show();
        }
    }

