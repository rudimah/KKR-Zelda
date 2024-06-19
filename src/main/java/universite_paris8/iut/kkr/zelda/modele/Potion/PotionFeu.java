package universite_paris8.iut.kkr.zelda.modele.Potion;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class PotionFeu extends Potion {

    public PotionFeu(int x, int y,  Environnement env) {
        super("Potion de Feu", x, y, 5, 0, 0, env);  // +5 à ptAttaque

    }

    @Override
    public void appliquerPotion() {
        env.getLink().setPtAttaque(env.getLink().getPtAttaque()+5);
        System.out.println("Potion de Feu utiliser : Point d'attaque augmenté de 5");
    }
}