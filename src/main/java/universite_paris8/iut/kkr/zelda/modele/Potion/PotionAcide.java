package universite_paris8.iut.kkr.zelda.modele.Potion;

import universite_paris8.iut.kkr.zelda.modele.Environnement;


public class PotionAcide extends Potion {

    public PotionAcide(int x, int y, Environnement env) {
        super("Potion Acide", x, y, 2, 0, 0, env);  // +2 à ptAttaque
    }

    @Override
    public void appliquerPotion() {
        env.getLink().setPtAttaque(env.getLink().getPtAttaque()+2);
        System.out.println("Potion Acide utilisée : Point d'attaque augmenté de 2");
    }
}