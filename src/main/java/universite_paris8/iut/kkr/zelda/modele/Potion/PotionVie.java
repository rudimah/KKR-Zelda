package universite_paris8.iut.kkr.zelda.modele.Potion;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class PotionVie extends Potion {

    public PotionVie(int x, int y, Environnement env) {
        super("Potion de Feu", x, y, 0, 5, 0, env);  // +5 à pt de vies
    }

    @Override
    public void appliquerPotion() {
        env.getLink().setPv(env.getLink().getPv()+5);
        System.out.println("Potion Vie utiliser : Point de vie augmenté de 5");

    }
}