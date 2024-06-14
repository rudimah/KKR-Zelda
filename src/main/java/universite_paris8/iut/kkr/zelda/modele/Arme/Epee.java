package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionVie;

public class Epee extends Arme {
    public Epee(int x, int y) {
        super("Épée de Guerrier",15, x, y,0);
    }

    public void attaquer(Ennemis ennemi) {
        super.attaquerAvecArme(ennemi);
    }
    public void appliquerPotionFeu(PotionVie potion) {
        setPtAttaque(getPtAttaque() + potion.getPtAttaque());
    }
    @Override
    public String toString() {
        return "l'épée de Guerrier" + super.toString();
    }
}
