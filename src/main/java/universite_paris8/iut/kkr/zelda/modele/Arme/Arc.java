package universite_paris8.iut.kkr.zelda.modele.Arme;

import universite_paris8.iut.kkr.zelda.modele.ActeurEnMouvement;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionForce;

public class Arc extends Arme {
    private int degatsFeu;

    public Arc(int x, int y, Environnement env) {
        super("Arc du Héros",55, x, y, 15, env);
        this.degatsFeu = 5;
    }
    public void appliquerPotionDeForce(PotionForce potion) {
        setPortee(getPortee() + potion.getPortee());
    }

    public int getDegatsFeu() {
        return degatsFeu;
    }

    //méthode visant à implémenter les spécificités d'attaques de
    public void attaquer(ActeurEnMouvement ennemi) {
        ennemi.recevoirDegats(getPtAttaque() + degatsFeu); // Applique des dégâts de feu supplémentaires
        System.out.println("Arc inflige des dégâts de feu ");
    }

    @Override
    public String toString() {
        return "l'arc du héros" +super.toString();
    }
}
