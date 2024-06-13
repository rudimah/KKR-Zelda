package universite_paris8.iut.kkr.zelda.modele.Potion;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class PotionFeu extends Potion {
    private Environnement environnement;
    public PotionFeu(int x, int y,  Environnement environnement) {
        super("Potion de Feu", x, y, 5, 0, 0);  // +5 à ptAttaque
        this.environnement = environnement;
    }

    @Override
    public void appliquerPotion() {
        environnement.getLink().setPtAttaque(environnement.getLink().getPtAttaque()+5);
    }
}