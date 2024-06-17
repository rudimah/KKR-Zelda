package universite_paris8.iut.kkr.zelda.modele.Potion;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class PotionVie extends Potion {
    private Environnement environnement;
    public PotionVie(int x, int y, Environnement environnement) {
        super("Potion de Feu", x, y, 0, 5, 0);  // +5 à pt de vies
        this.environnement = environnement;
    }

    @Override
    public void appliquerPotion() {
        environnement.getLink().setPv(environnement.getLink().getPv()+5);
        System.out.println("Potion Vie utiliser : Point de vie augmenté de 5");

    }
}