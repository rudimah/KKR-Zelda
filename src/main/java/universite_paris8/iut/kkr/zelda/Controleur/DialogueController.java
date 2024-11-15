package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.application.Platform;
import javafx.scene.control.ChoiceDialog;
import universite_paris8.iut.kkr.zelda.modele.Link;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DialogueController {

    private Controleur controleur;

    public DialogueController(Controleur controleur) {
        this.controleur = controleur;
    }


    //méthode pour la roue de dialogue et l'affichage d'une petit fenetre avec
    public void roueDialogue() {
        Platform.runLater(() -> {
            List<String> choix = Arrays.asList(
                    "Salut ! Je suis Link !",
                    "Oh non ! À l'aide !",
                    "Tiens, prends ça !",
                    "Bien joué !",
                    "Que se passe-t-il ?",
                    "Tu veux te battre ?! Alors viens !!"
            );

            ChoiceDialog<String> choixdialogue = new ChoiceDialog<>(choix.get(0), choix); //prend la premiere replique
            choixdialogue.setTitle("Dialogue de Link");
            choixdialogue.setHeaderText("Link parle...");
            choixdialogue.setContentText("Choisissez une réplique:");

            Optional<String> choixutilisateur = choixdialogue.showAndWait();
            choixutilisateur.ifPresent(reponse -> controleur.afficherDialogue(reponse));
        });
    }
}