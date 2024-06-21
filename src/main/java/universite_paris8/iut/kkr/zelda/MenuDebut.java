package universite_paris8.iut.kkr.zelda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuDebut extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
        Scene scene = new Scene(root, 800, 800);
        String css = this.getClass().getResource("dark.css").toExternalForm();
        scene.getStylesheets().add(css);
        Font.loadFont(getClass().getResourceAsStream("/Police/Triforce.ttf"), 48);
        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

