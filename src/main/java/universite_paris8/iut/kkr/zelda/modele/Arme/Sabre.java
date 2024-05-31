package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionAcide;

public class Sabre extends Arme {
    private int degatsOrbe;

    public Sabre(int x, int y) {
        super("Sabre", 50,x, y, 1);
        this.degatsOrbe = 5;
    }

    public void appliquerPotionAcide(PotionAcide potion) {
        setPtAttaque(getPtAttaque() + potion.getPtAttaque());
    }
    public int getDegatsOrbe() {
        return degatsOrbe;
    }
    public void attaquer(Ennemis ennemi) {
        super.attaquerAvecArme(ennemi);
        ennemi.recevoirDegats(degatsOrbe);  // Apply special orb damage
        System.out.println("Sabre inflige des dégâts d'orbe supplémentaires à l'ennemi.");
    }
    @Override
    public String toString() {
        return "le sabre";
    }
}
