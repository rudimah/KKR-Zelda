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

        System.out.println("Potion Bleu utiliser : Point d'attaque augmenté de 2");
        if (environnement.getLink().getArme()!=null) {
            environnement.getLink().getArme().setPortee(environnement.getLink().getArme().getPortee() + 5);
        }
        else {
            System.out.println("Vous n'avez pas d'arme : pas d'amélioration de portée");
        }

    }
}