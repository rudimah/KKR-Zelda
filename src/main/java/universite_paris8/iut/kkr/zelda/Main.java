package universite_paris8.iut.kkr.zelda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Map1.fxml"));
        Scene scene = new Scene(fxmlLoader. load(), 800, 800);
        //scene.setOnKeyPressed();
        stage.setTitle("Hyrule - La fin des temps");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



