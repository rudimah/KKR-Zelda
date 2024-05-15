package universite_paris8.iut.kkr.zelda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameMenu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(new Scene(root, 800, 445));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

