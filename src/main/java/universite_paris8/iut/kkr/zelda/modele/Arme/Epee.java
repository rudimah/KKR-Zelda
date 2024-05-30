package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionFeu;

public class Epee extends Arme {
    public Epee(int x, int y) {
        super("Épée de Guerrier", x, y, 15, 0);
    }

    public void attaquer(Ennemis ennemi) {
        super.attaquer(ennemi);
    }
    public void appliquerPotionFeu(PotionFeu potion) {
        setPtAttaque(getPtAttaque() + potion.getPtAttaque());
    }
}
