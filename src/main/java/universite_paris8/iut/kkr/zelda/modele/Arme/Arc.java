package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionForce;

public class Arc extends Arme {
    private int degatsFeu;

    public Arc(int x, int y) {
        super("Arc du Héros", x, y, 55, 15);
        this.degatsFeu = 5;
    }
    public void appliquerPotionDeForce(PotionForce potion) {
        setPortee(getPortee() + potion.getPortee());
    }

    public int getDegatsFeu() {
        return degatsFeu;
    }

    public void attaquer(Ennemis ennemi) {
        super.attaquer(ennemi);
        if (estAProximite(ennemi)) {
            ennemi.recevoirDegats(degatsFeu);  // Applique des dégâts de feu supplémentaires
            System.out.println("Arc inflige des dégâts de feu supplémentaires à l'ennemi.");
        }
    }

}
