package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.Potion.PotionFeu;

public class Epee extends Armes {
    public Epee(int x, int y) {
        super("Épée de Guerrier", x, y, 15, 0);
    }

    public void appliquerPotionFeu(PotionFeu potion) {
        setPtAttaque(getPtAttaque() + potion.getPtAttaque());
    }
}
