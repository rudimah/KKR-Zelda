package universite_paris8.iut.kkr.zelda.modele.Accessoires;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;

public class Bouclier extends Accessoires {
    public Bouclier(int x, int y) {
        super("Bouclier", x, y, 0, 0, 0);
    }

    public void augmenterPointsDeVie(ActeurEnMouvement a) {
        a.setPv(a.getPv() + 30);
        System.out.println("Points de vie augmentés de 30 grâce au Bouclier.");
    }
}
