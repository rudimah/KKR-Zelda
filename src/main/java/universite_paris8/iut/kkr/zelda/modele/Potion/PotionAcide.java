package universite_paris8.iut.kkr.zelda.modele.Potion;

import universite_paris8.iut.kkr.zelda.modele.Environnement;


public class PotionAcide extends Potion {
    private Environnement environnement;
    public PotionAcide(int x, int y, Environnement environnement) {
        super("Potion Acide", x, y, 2, 0, 0);  // +2 à ptAttaque
        this.environnement = environnement;
    }

    @Override
    public void appliquerPotion() {
        environnement.getLink().setPtAttaque(environnement.getLink().getPtAttaque()+2);
        System.out.println("Potion Acide utiliser : Point d'attaque augmenté de 2");
    }
}