package universite_paris8.iut.kkr.zelda.modele.Potion;

import universite_paris8.iut.kkr.zelda.modele.Environnement;

public class PotionForce extends Potion {
    private Environnement environnement;
    public PotionForce(int x, int y,   Environnement environnement) {
        super("Potion de Force", x, y, 0, 0, 3);  // Augmente la portée de 3
        this.environnement = environnement;
    }

    @Override
    public void appliquerPotion() {
        if (environnement.getLink().getArme()!=null){
            environnement.getLink().getArme().setPortee(environnement.getLink().getArme().getPortee()+3);
            System.out.println("Potion de Froce utiliser : Point de portée augmenté de 3");
        }
        else {
            System.out.println("Vous n'avez pas d'arme : Potion gaspiller");
        }
    }
}