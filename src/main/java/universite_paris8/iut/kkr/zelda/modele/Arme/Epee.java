package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionVie;

public class Epee extends Arme {
    public Epee(int x, int y, Environnement env) {
        super("Épée de Guerrier",15, x, y,0, env);
    }


    public void attaquer(ActeurEnMouvement ennemi) {ennemi.recevoirDegats(getPtAttaque());}

    public void appliquerPotionFeu(PotionVie potion) {
        setPtAttaque(getPtAttaque() + potion.getPtAttaque());
    }

    @Override
    public String toString() {
        return "l'épée de Guerrier" + super.toString();
    }
}
