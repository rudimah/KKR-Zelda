package universite_paris8.iut.kkr.zelda.modele.Ennemis;

import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Cataltos extends Ennemis {

    public Cataltos(Environnement env) {
        super(0, 0, 3, env, 15, 0);
    }

    @Override
    public void attaquer(ActeurEnMouvement acteurCible) {
        acteurCible.decrementerPv(getPtAttaque());
        System.out.println("Un Cataltos attaque Link ! Il reste " + acteurCible.getPv() + " pv à Link");
    }

    @Override
    public String toString() {return "un Cataltos";}
}