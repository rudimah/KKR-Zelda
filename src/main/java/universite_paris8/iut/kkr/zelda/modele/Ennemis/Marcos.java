package universite_paris8.iut.kkr.zelda.modele.Ennemis;

import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Marcos extends Ennemis {
    private Pane panneauDeJeu;
    private TilePane tilePane;

    public Marcos(Environnement env, Pane pj, TilePane tilePane) {
        super(0,0 , 2, env, 15, 0);
        this.panneauDeJeu = pj;
        this.tilePane = tilePane;
    }

    @Override
    public void attaquer(ActeurEnMouvement acteurCible) {
        acteurCible.decrementerPv(getPtAttaque());
        System.out.println("Un Marcos lance un projectile !");
    }

    @Override
    public String toString() {return "un Marcos";}
}
