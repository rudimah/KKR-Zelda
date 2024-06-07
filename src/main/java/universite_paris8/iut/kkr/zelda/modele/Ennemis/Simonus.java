package universite_paris8.iut.kkr.zelda.modele.Ennemis;

import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Simonus extends Ennemis {
    public Simonus(Environnement env) {
        super(0, 0, 3, env, 15, 0);
    }

    @Override
    public void attaquer(ActeurEnMouvement acteurCible) {
        if (estADistanceAttaque(acteurCible)){
            acteurCible.decrementerPv(getPtAttaque());
        }
        System.out.println("Un Simonus attaque Link ! Il reste " + acteurCible.getPv() + " pv à Link");
    }

    @Override
    public String toString() {return "un Simonus";}
}
