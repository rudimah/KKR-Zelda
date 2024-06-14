package universite_paris8.iut.kkr.zelda.Controleur;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FinDePartieController {

    @FXML
    private Button buttonQuitter;

    @FXML
    private void QuitterleJeu() {
        Platform.exit();
    }
}
