package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.Arme.Armes;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionAcide;

public class Sabre extends Armes {
    private int degatsOrbe;

    public Sabre(int x, int y) {
        super("Sabre", x, y, 50, 1);
        this.degatsOrbe = 5;
    }

    public void appliquerPotionAcide(PotionAcide potion) {
        setPtAttaque(getPtAttaque() + potion.getPtAttaque());
    }
    public int getDegatsOrbe() {
        return degatsOrbe;
    }
}
