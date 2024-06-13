package universite_paris8.iut.kkr.zelda.modele.Accessoires;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class Bouclier extends Accessoires {
    public Bouclier(int x, int y, Environnement env) {
        super("Bouclier", x, y, 0, 0, env);
    }

    @Override
    public void appliquerEffet() {
        env.getLink().setPv(env.getLink().getPv() + 30);
        System.out.println("Points de vie augmentés de 30 grâce au Bouclier");
    }
}
