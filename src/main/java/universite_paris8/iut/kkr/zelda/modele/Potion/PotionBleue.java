package universite_paris8.iut.kkr.zelda.modele.Potion;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class PotionBleue extends Potion {
    private Environnement environnement;
    public PotionBleue(int x, int y,  Environnement environnement) {
        super("Potion Bleue", x, y, 5, 0, 5);  // +5 à ptAttaque et +5 à la portée
        this.environnement = environnement;
    }

    @Override
    public void appliquerPotion() {
        environnement.getLink().setPtAttaque(environnement.getLink().getPtAttaque()+2);
        environnement.getLink().getArme().setPortee(environnement.getLink().getArme().getPortee()+5);
    }
}