package universite_paris8.iut.kkr.zelda.modele;

import org.junit.jupiter.api.Test;
import universite_paris8.iut.kkr.zelda.Controleur.DialogueController;
import universite_paris8.iut.kkr.zelda.utils.Constantes;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest {
    private Environnement env= new Environnement(800, 800);

    private DialogueController dialogueController= new DialogueController(null);
    private Link link= new Link(env, dialogueController);;

    @Test
    public void testSeDeplacer() {
        int initialY = link.getY();
        link.setDirection(Constantes.Haut);
        link.seDeplacer();
        assertEquals(initialY - link.getVitesse(), link.getY(), "Link devrait se déplacer vers le haut selon la vitesse définie");
    }

}