package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.application.Platform;
import javafx.scene.control.ChoiceDialog;
import universite_paris8.iut.kkr.zelda.modele.Link;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DialogueController implements InterfaceDialogue {


    @Override
    public void roueDialogue(Link link) {
        Platform.runLater(() -> {
            // Définition des choix disponibles pour Link
            List<String> choix = Arrays.asList(
                    "Salut ! Je suis Link !",
                    "Oh non ! À l'aide !",
                    "Tiens, prends ça !",
                    "Bien joué !",
                    "Que se passe-t-il ?"
            );

            // Création du dialogue de choix
            ChoiceDialog<String> dialog = new ChoiceDialog<>(choix.get(0), choix);
            dialog.setTitle("Dialogue de Link");
            dialog.setHeaderText("Link parle...");
            dialog.setContentText("Choisissez une réplique:");

            // Affichage du dialogue et traitement de la réponse
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(response -> System.out.println("Link dit : " + response));
        });
    }
}