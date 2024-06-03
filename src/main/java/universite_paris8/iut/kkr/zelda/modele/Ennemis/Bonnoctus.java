package universite_paris8.iut.kkr.zelda.modele.Ennemis;

import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Bonnoctus extends Ennemis {
    private Pane panneauDeJeu;
    private TilePane tilePane;

    public Bonnoctus(Environnement env, Pane pj, TilePane tilePane) {
        super(0, 0, 3, env, 10000, 250);
        this.panneauDeJeu = pj;
        this.tilePane = tilePane;
    }

    @Override
    public void attaquer(ActeurEnMouvement acteurCible) {
        acteurCible.decrementerPv(getPtAttaque());
        System.out.println("Un Bonnoctus attaque Link ! Il reste " + acteurCible.getPv() + " pv à Link");
    }



    @Override
    public String toString() {return "Bonnoctus";}
}