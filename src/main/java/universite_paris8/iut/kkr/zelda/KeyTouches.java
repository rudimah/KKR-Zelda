package universite_paris8.iut.kkr.zelda;

import javafx.scene.input.KeyCode;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;

public class KeyTouches {

    public static void setDirection(ActeurEnMouvement acteur, KeyCode key, boolean sprint) {
        int dx = 0;
        int dy = 0;
        int v = acteur.getVitesse();

        // Si la touche Maj est pressée, doubler la vitesse
        if (sprint) {
            v *= 2;
        }
        switch (key) {
            case Z:
                dy = -v;
                break;
            case S:
                dy = v;
                break;
            case D:
                dx = v;
                break;
            case Q:
                dx = -v;
                break;
            default:
                dx = 0;
                dy = 0;
                break;
        }

        acteur.setDx(dx);
        acteur.setDy(dy);
    }
}